package com.cxc.rpc.rpcclient.controller;

import com.csc.rpc.rpcinterface.service.HelloService;
import com.cxc.rpc.rpcclient.rpc.RpcClientProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Link.Chen
 * @Date2020/4/2 13:34
 **/
@RequestMapping("/test")
@RestController
public class RomoteCallController {

    @GetMapping("/romotecall")
    public String testRomoteCall(){
        RpcClientProxy proxy = new RpcClientProxy();
        HelloService helloService = proxy.clientProxy(HelloService.class, "localhost", 8082);
        return helloService.sayHello("rpc");
    }
}
