package com.api.amqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kaze 2017/10/29
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudApiAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiAmqpApplication.class, args);
	}

}
