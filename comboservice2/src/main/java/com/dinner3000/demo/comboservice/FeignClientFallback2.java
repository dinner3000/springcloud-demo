package com.dinner3000.demo.comboservice;

import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback2 implements FeignClient2 {
    @Override
    public String service() {
        return "Error calling FeignClient2";
    }
}
