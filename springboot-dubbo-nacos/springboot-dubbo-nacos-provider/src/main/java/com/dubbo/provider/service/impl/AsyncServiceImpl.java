package com.dubbo.provider.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import com.dubbo.api.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public String sayHello(String name) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            asyncContext.write("Hello " + name + ", response from provider.");
        }).start();
        return null;
    }
}
