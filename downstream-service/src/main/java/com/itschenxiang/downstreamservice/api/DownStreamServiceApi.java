package com.itschenxiang.downstreamservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "downstream-service"
)
public interface DownStreamServiceApi {

    @PostMapping("/serviceName")
    public String getServiceName();

}
