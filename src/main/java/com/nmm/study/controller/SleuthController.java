package com.nmm.study.controller;

import com.nmm.study.feign.SleuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SleuthController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SleuthService sleuthService;

    @ResponseBody
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name) {
        return "hello " + name;
    }
    @ResponseBody
    @RequestMapping("/restHello/{name}")
    public String restHello(@PathVariable String name){
        return restTemplate.getForObject("http://localhost:8888/sayHello/" + name,String.class );
    }
    @ResponseBody
    @RequestMapping("/feignHello/{name}")
    public String feignHello(@PathVariable String name){
        return sleuthService.sayHello(name);
    }
}
