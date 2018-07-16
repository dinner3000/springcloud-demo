package com.dinner3000.demo.comboservice;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback1 implements FeignClient1 {
    @Override
    public String service() {
        return "Error calling FeignClient1";
    }
}
