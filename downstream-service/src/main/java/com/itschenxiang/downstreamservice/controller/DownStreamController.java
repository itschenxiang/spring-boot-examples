package com.itschenxiang.downstreamservice.controller;

import com.itschenxiang.downstreamservice.api.DownStreamServiceApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DownStreamController implements DownStreamServiceApi {

    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${server.port}")
    private String portStr;

    @PostMapping("/serviceName")
    @Override
    public String getServiceName() {
        return String.format("%s:%s", serviceName, portStr);
    }
}
