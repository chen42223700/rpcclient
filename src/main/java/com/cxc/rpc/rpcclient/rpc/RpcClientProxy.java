package com.cxc.rpc.rpcclient.rpc;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author Link.Chen
 * @Date2020/4/2 14:33
 **/
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[] {interfaceCls},
                new RemoteIncocationHandle(host, port));
    }
}
