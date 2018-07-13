package com.dinner3000.demo.comboservice;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class ComboserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComboserviceApplication.class, args);
	}

	@Autowired
	FeignService1 service1;

	@Autowired
	FeignService2 service2;

	@RequestMapping("/service")
	public Object comboService1(){
		List<String> resultList = new ArrayList<>();
		resultList.add(service1.service());
		resultList.add(service2.service());
		return org.apache.commons.lang.StringUtils.join(resultList, " | ");
	}
}
