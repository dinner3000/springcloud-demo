package com.dinner3000.demo.comboservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service1")
public interface FeignService1 {
    @RequestMapping("/service")
    String service();
}
