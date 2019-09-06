package com.api.redis;

import com.api.uitl.SerializerUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author kaze 2017/10/29
 */
@Component
@Aspect
public class RedisAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private JedisPool jedisPool;

    @Value("${spring.redis.expireSeconds}")// 单位秒
    private int expireSeconds;

    @Pointcut("execution(* com.api.mapper.*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Class<?> clazz = joinPoint.getTarget().getClass();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Object[] params = joinPoint.getArgs();
        Jedis jedis;
        if (method.isAnnotationPresent(UseRedis.class)) {// 有UseCache注解的才执行缓存
            String key = generateKey(clazz, method, params);
            jedis = jedisPool.getResource();
            Object redisValue = SerializerUtil.deserialize(jedis.get(SerializerUtil.serialize(key)));
            // 没有缓存，先获取查询结果，存入缓存，再返回执行结果，否则，直接返回缓存的结果，不查询数据库
            if (redisValue == null) {
                logger.info("没有缓存key: {}", key);
                Object object = joinPoint.proceed();
                jedis.setex(SerializerUtil.serialize(key), expireSeconds, SerializerUtil.serialize(object));
                return object;
            } else {
                logger.info("有缓存key: {}", key);
                return redisValue;
            }
        } else {
            return joinPoint.proceed();
        }
    }

    public String generateKey(Class<?> clazz, Method method, Object[] params) {
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getName());
        sb.append(method.getName());
        for (Object obj : params) {
            sb.append(obj.toString());
        }
        return sb.toString();
    }

}
