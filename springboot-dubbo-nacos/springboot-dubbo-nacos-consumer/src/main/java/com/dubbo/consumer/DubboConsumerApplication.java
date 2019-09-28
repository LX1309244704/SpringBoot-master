package com.dubbo.consumer;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dubbo.api.AsyncService;
import com.dubbo.api.DemoService;

@SpringBootApplication
public class DubboConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference
    private DemoService demoService;

    @Reference
    private AsyncService asyncService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(demoService.sayHello("Not Sure"));
            logger.info(asyncService.sayHello("Not Sure"));
        };
    }

}
