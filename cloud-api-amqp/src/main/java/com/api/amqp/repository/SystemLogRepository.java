package com.api.amqp.repository;

import com.api.amqp.domain.SystemLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author kaze 2017/10/29
 */
public interface SystemLogRepository extends MongoRepository<SystemLog, String> {

    /**
     * 根据code找日志记录
     *
     * @param logCode
     * @return
     */
    SystemLog findByLogCode(String logCode);

}
