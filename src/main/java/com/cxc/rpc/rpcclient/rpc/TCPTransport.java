package com.cxc.rpc.rpcclient.rpc;

import com.alibaba.fastjson.JSON;
import com.csc.rpc.rpcframe.bean.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

/**
 * @Description
 * @Author Link.Chen
 * @Date2020/4/2 14:56
 **/
public class TCPTransport {

    private String host;

    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest request){
        Socket socket = null;
        try {
            socket  = newSocket();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println(JSON.toJSONString(request));
            outputStream.writeObject(JSON.toJSONString(request));
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();
            inputStream.close();
            outputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("远程调用失败", e);
        }  finally {
            if (!Objects.isNull(socket)){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private Socket newSocket(){
        System.out.println("创建一个新连接");
        try {
            return new Socket(host, port);
        } catch (Exception e) {
            throw  new RuntimeException("连接创建失败", e);
        }

    }
}
