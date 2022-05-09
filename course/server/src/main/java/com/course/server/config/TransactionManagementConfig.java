package com.course.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
/**
 * 事务封装，在需要事务的方法上增加注解@Transactional,
 * 如果不封装，在该类上增加@EnableTransactionManagement
 */
public class TransactionManagementConfig {

}
