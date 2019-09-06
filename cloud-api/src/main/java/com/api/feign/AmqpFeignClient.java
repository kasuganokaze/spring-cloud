package com.api.feign;

import com.alibaba.fastjson.JSONObject;
import com.api.feign.fallback.AmqpFeignClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author kaze 2017/10/29
 */
@FeignClient(name = "cloud-api-amqp", configuration = FeignClientConfig.class, fallbackFactory = AmqpFeignClientFallbackFactory.class)
public interface AmqpFeignClient {

    /**
     * 测试接口
     *
     * @return
     */
    @GetMapping("/test")
    String send();

    /**
     * 发送日志
     *
     * @param json
     * @return
     */
    @PostMapping("/log")
    String send(@RequestBody JSONObject json);

}
