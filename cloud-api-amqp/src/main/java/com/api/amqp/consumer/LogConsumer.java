package com.api.amqp.consumer;

import com.alibaba.fastjson.JSONObject;
import com.api.amqp.config.AmqpConfig;
import com.api.amqp.domain.SystemLog;
import com.api.amqp.service.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author kaze 2017/10/29
 */
@Component
@RabbitListener(queues = AmqpConfig.AMQP_QUEUE)
public class LogConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SystemLogService systemLogService;

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(AmqpConfig.AMQP_EXCHANGE);
    }

    @Bean
    public Queue queue() {
        //队列持久
        return new Queue(AmqpConfig.AMQP_QUEUE, true);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.AMQP_ROUTE);
    }

    @RabbitHandler
    public void consume(JSONObject json) {
        SystemLog systemLog = new SystemLog();
        systemLog.setLogCode(System.nanoTime());
        systemLog.setUsername(String.valueOf(json.get("username")));
        systemLog.setCreateTime(new Date());
        systemLog.setClientIp(String.valueOf(json.get("clientIp")));
        systemLog.setServerIp(String.valueOf(json.get("serverIp")));
        systemLog.setDetail(String.valueOf(json.get("detail")));
        systemLog.setUserAgent(String.valueOf(json.get("userAgent")));
//        systemLogService.save(systemLog);
        logger.info("收到信息：{}", json);
    }

}
