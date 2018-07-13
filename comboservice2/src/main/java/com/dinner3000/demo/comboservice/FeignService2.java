package com.dinner3000.demo.comboservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service2")
public interface FeignService2 {
    @RequestMapping("/service")
    String service();
}
