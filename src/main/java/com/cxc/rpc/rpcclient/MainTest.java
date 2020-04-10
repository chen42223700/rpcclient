package com.cxc.rpc.rpcclient;

import com.csc.rpc.rpcinterface.service.HelloService;
import com.cxc.rpc.rpcclient.rpc.RpcClientProxy;

/**
 * @Description
 * @Author Link.Chen
 * @Date2020/4/3 14:52
 **/
public class MainTest {

    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy();
        HelloService helloService = proxy.clientProxy(HelloService.class, "localhost", 8082);
        System.out.println(helloService.sayHello("rpc"));
//        com.rpcframe.rpc.rpcframe.bean.RpcRequest
//        String s = "{\"className\":\"com.cxc.rpc.rpcclient.remoteservice.HelloService\",\"methodName\":\"sayHello\"}";
//        RpcRequest request = JSON.parseObject(s, RpcRequest.class);
//        System.out.println(request.getClassName());

    }


}
