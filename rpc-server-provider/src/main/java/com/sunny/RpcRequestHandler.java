package com.sunny;

import com.sunny.common.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 16:09
 * @ModifyDate 2019-09-19 16:09
 */
public class RpcRequestHandler implements Runnable {

    private Socket socket;

    private Object service;

    public RpcRequestHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            Object o = objectInputStream.readObject();
            if(o instanceof RpcRequest) {
                RpcRequest rpcRequest = (RpcRequest)o;
                Object result = invoke(rpcRequest);
                objectOutputStream.writeObject(result);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = Class.forName(rpcRequest.getClassName());
        Object[] params = rpcRequest.getParams();
        Class[] classes = new Class[params.length];
        for(int i = 0; i < params.length; i++) {
            classes[i] = params[i].getClass();
        }

        Method method = clazz.getMethod(rpcRequest.getMethodName(), classes);
        Object result = method.invoke(service, params);
        return result;
    }
}
