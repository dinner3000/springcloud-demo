package com.dinner3000.demo.comboservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComboService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public Object doubleCall() throws Exception {
        List<String> resultList = new ArrayList<>();
//        throw new Exception("Expecting error");
        resultList.add("RestTemplate based: ");
        resultList.add(restTemplate.getForObject("http://service1/service", String.class));
        resultList.add(restTemplate.getForObject("http://service2/service", String.class));
        return org.apache.commons.lang.StringUtils.join(resultList, " | ");
    }

    protected Object fallback(Throwable e) {

        return e.getMessage();
    }
}
