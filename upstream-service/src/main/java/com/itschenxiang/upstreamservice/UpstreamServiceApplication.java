package com.itschenxiang.upstreamservice;

import com.itschenxiang.downstreamservice.api.DownStreamServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.itschenxiang.downstreamservice.api")
@Slf4j
public class UpstreamServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpstreamServiceApplication.class, args);
    }

    @Autowired
    private DownStreamServiceApi downStreamServiceApi;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Executors.newSingleThreadScheduledExecutor()
                        .scheduleAtFixedRate(() -> {
                            log.info(downStreamServiceApi.getServiceName());
                        },5 ,5, TimeUnit.SECONDS);
            }
        };
    }

}
