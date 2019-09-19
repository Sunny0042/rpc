package com.sunny;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Version 1.0
 * @Author ChenKun
 * @Date 2019-09-19 16:05
 * @ModifyDate 2019-09-19 16:05
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publish(int port, Object service) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket accept = serverSocket.accept();
                executorService.execute(new RpcRequestHandler(accept, service));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
