package com.dinner3000.demo.comboservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@RestController
public class ComboserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComboserviceApplication.class, args);
	}

	@Autowired
    private ComboService comboService;

    @RequestMapping("/service")
    public Object service(){
        return comboService.doubleCall();
    }
}
