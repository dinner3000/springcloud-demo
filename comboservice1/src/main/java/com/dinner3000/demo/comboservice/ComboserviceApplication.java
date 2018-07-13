package com.dinner3000.demo.comboservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ComboserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComboserviceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/service")
	public Object comboService1(){
		List<String> resultList = new ArrayList<>();
		resultList.add(restTemplate.getForObject("http://service1/service", String.class));
		resultList.add(restTemplate.getForObject("http://service2/service", String.class));
		return org.apache.commons.lang.StringUtils.join(resultList, " | ");
	}
}
