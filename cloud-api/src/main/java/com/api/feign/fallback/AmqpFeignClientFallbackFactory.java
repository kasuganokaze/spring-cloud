package com.api.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.api.feign.AmqpFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author kaze 2017/10/29
 */
@Component
public class AmqpFeignClientFallbackFactory implements FallbackFactory<AmqpFeignClient> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AmqpFeignClient create(Throwable throwable) {
        return new AmqpFeignClient() {
            @Override
            public String send(@RequestBody JSONObject json) {
                logger.error("客户端调用失败，异常为:" + throwable);
                return "fail";
            }

            @Override
            public String send() {
                logger.error("客户端调用失败，异常为:" + throwable);
                return "fail";
            }
        };
    }

}
