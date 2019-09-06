package com.api.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author kaze 2017/10/29
 */
@Entity
@Table(name = "SYS_USER")
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = -2991037758603101417L;

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "REALNAME")
    private String realName;

    @Column(name = "SEX")
    private int sex;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

}
