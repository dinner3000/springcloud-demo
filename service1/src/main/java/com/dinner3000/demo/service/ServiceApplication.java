package com.dinner3000.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Value("${spring.application.name}")
    private String appName;

	@Value("${server.port}")
    private String serverPort;

	@RequestMapping("/service")
	public Object service(){
        return String.format("service at %s:%s => name: %s, age: %s, version: %s",
				appName, serverPort, name, age, version);
    }

	@Value("${name}")
	private  String name;

	@Value("${age}")
	private  String age;

	@Value("${version}")
	private  String version;
}
