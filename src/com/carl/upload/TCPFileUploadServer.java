package com.carl.upload;

import com.carl.util.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Carl
 * @version 1.0
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        //服务端监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888开启监听...");
        //2.等待连接
        Socket socket = serverSocket.accept();

        //3.读取客户端发送的数据
        // 通过socket得到一个输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //4.将得到bytes数组,写入到指定的路径,就得到一个文件
        String destFilePath = "src/qier2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);


        //向客户端发送"收到图片"
        //通过socket获取到输出流(字符)
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();//把内容刷新到我们的数据
        socket.shutdownOutput();//设置写入结束标记

        //关闭其他资源
        bos.close();
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
