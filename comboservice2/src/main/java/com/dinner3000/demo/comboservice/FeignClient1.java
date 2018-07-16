package com.dinner3000.demo.comboservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service1", fallback = FeignClientFallback1.class)
public interface FeignClient1 {
    @RequestMapping("/service")
    String service();
}
