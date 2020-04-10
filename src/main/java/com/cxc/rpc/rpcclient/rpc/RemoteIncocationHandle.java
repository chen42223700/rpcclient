package com.cxc.rpc.rpcclient.rpc;

import com.csc.rpc.rpcframe.bean.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Link.Chen
 * @Date2020/4/2 14:39
 **/
public class RemoteIncocationHandle implements InvocationHandler {

    private String host;

    private int port;

    public RemoteIncocationHandle(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        TCPTransport transport = new TCPTransport(host, port);
        return transport.send(request);
    }
}
