package com.course.file.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.course")
@MapperScan("com.course.server.dao")
public class FileApplication {

	private static final Logger LOG = LoggerFactory.getLogger(FileApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FileApplication.class);
		Environment env = app. run(args).getEnvironment();
		LOG.info("启动成功！！");
		LOG.info("System地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
