package com.api.service.impl;

import com.api.domain.SysUser;
import com.api.mapper.SysUserMapper;
import com.api.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kaze 2017/10/29
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

}
