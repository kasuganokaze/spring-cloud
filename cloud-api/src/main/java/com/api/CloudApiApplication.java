package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author kaze 2017/10/29
 */
@SpringCloudApplication
@EnableFeignClients
@ServletComponentScan
public class CloudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiApplication.class, args);
	}

}
