package com.nmm.study.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "sleuthService",url = "http://localhost:8888")
public interface SleuthService {
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable(name="name")String name);
}
