package com.api.amqp.controller;

import com.alibaba.fastjson.JSONObject;
import com.api.amqp.producer.LogProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kaze 2017/10/29
 */
@Api(tags = "日志模块", description = "com.api.amqp.controller.LogController")
@RestController
public class LogController {

    @Resource
    private LogProducer logProducer;

    @ApiOperation(value = "测试", notes = "测试数据")
    @GetMapping("/test")
    public String test() {
        System.out.println("test");
        return null;
    }

    @ApiOperation(value = "日志", notes = "保存日志")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "json", value = "json", required = true, paramType = "body", dataType = "JSONObject")
    })
    @PostMapping("/log")
    public String log(@RequestBody JSONObject json) {
        logProducer.produce(json);
        return null;
    }

}
