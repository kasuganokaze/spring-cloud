package com.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author kaze 2017/11/2
 */
@Data
@AllArgsConstructor
public class ResponseResult {

    private Integer status;
    private String msg;
    private Object data;

    public static ResponseResult ok() {
        return new ResponseResult(200, "OK", null);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(200, "OK", data);
    }

    public static ResponseResult build(Integer status, String msg, Object data) {
        return new ResponseResult(status, msg, data);
    }

}
