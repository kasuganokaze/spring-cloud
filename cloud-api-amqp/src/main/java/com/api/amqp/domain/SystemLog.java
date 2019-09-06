package com.api.amqp.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * @author kaze 2017/10/29
 */
@Data
@Document(collection = "system_log")
public class SystemLog {

    @Indexed(unique = true)
    @Field("log_code")
    private Long logCode;

    @Field("username")
    private String username;

    @Field("create_time")
    private Date createTime;

    @Field("client_ip")
    private String clientIp;

    @Field("server_ip")
    private String serverIp;

    @Field("detail")
    private String detail;

    @Field("user_agent")
    private String userAgent;

}
