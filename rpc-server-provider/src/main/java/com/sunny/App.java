package com.sunny;

import com.sunny.impl.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publish(8080, new UserServiceImpl());
    }
}
