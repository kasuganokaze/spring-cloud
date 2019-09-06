package com.api.mapper;

import com.api.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kaze 2017/10/29
 */
@Mapper
public interface SysUserMapper extends tk.mybatis.mapper.common.Mapper<SysUser> {

    /**
     * 根据登录名查找用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser findByUsername(String username);

}
