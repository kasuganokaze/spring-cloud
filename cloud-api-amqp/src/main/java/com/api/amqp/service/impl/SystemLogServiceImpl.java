package com.api.amqp.service.impl;

import com.api.amqp.domain.SystemLog;
import com.api.amqp.repository.SystemLogRepository;
import com.api.amqp.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kaze 2017/10/29
 */
@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogRepository systemLogRepository;

    @Override
    public void save(SystemLog log) {
        systemLogRepository.save(log);
    }

    @Override
    public SystemLog findByLogCode(String logCode) {
        return systemLogRepository.findByLogCode(logCode);
    }

}
