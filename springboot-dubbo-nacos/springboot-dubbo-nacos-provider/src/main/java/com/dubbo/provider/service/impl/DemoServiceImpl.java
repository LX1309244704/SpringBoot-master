package com.dubbo.provider.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.dubbo.api.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    private String serviceName;

    @Override
    public String sayHello(String name) {
    	System.out.println("你好！我收到消息了:"+name);
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
