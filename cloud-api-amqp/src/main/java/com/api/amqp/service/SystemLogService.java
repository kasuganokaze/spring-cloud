package com.api.amqp.service;

import com.api.amqp.domain.SystemLog;

/**
 * @author kaze 2017/10/29
 */
public interface SystemLogService {

    /**
     * 保存日志
     *
     * @param log
     */
    void save(SystemLog log);

    /**
     * 根据code查找日志记录
     *
     * @param logCode
     * @return
     */
    SystemLog findByLogCode(String logCode);

}
