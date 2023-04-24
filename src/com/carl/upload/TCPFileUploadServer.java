package com.carl.upload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Carl
 * @version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        //服务端监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888开启监听...");
        //2.等待连接
        Socket accept = serverSocket.accept();

        //3.读取客户端发送的数据


    }
}
