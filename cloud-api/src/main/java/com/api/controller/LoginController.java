package com.api.controller;

import com.api.domain.SysUser;
import com.api.service.SysUserService;
import com.api.uitl.SHA256Util;
import com.api.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author kaze 2017/10/29
 */
@Api(tags = "登录模块", description = "com.web.controller.LoginController")
@RestController
public class LoginController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "登录", notes = "登录验证")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult login(String username, String password) {
        SysUser sysUser = sysUserService.findByUsername(username);
        if (sysUser == null) {
            return ResponseResult.build(201, "用户不存在", null);
        }
        if (!sysUser.getPassword().equals(SHA256Util.getSHA256(password))) {
            return ResponseResult.build(201, "密码错误", null);
        }
        return ResponseResult.ok(sysUser);
    }

}
