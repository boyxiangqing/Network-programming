package com.carl.upload;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Carl
 * @version 1.0
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws IOException {
        //客户端连接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath = "e:/qie.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        
    }
}
