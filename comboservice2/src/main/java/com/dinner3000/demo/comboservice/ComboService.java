package com.dinner3000.demo.comboservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComboService {

    @Autowired
    private FeignClient1 service1;

    @Autowired
    private FeignClient2 service2;

//    @HystrixCommand(fallbackMethod = "fallback")
    public Object doubleCall(){
        List<String> resultList = new ArrayList<>();
        resultList.add("Feign based: ");
        resultList.add(service1.service());
        resultList.add(service2.service());
        return org.apache.commons.lang.StringUtils.join(resultList, " | ");
    }

//    protected Object fallback(Throwable e) {
//
//        return e.getMessage();
//    }
}
