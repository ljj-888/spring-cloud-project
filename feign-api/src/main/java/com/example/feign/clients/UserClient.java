package com.example.feign.clients;

import com.example.feign.config.FeignClientConfiguration;
import com.example.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice",configuration = FeignClientConfiguration.class)
@Component
public interface UserClient {

    @GetMapping("/user/{id}")
    User FeignById(@PathVariable("id") Long id);
}
