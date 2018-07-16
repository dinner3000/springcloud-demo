package com.dinner3000.demo.comboservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service2", fallback = FeignClientFallback2.class)
public interface FeignClient2 {
    @RequestMapping("/service")
    String service();
}
