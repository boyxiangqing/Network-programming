package com.carl.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author Carl
 * @version 1.0
 * @date 2023/4/24 23:15
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //创建 DatagramSocket对象,准备在9998发送或接收数据
        //
        DatagramSocket socket = new DatagramSocket(9998);

        //2.将需要发送的数据,封装到DataPacket对象
        byte[] data = "hello 明天吃火锅".getBytes();

        //说明: 封装的 DataPacket对象的 data内容字节数组, data.length, 主机(IP), 端口号
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.31.136"), 9999);
        socket.send(packet);


        //3.接收数据

        byte[] buf1 = new byte[64*1024];
        DatagramPacket packet1 = new DatagramPacket(buf1,buf1.length);
        System.out.println("准备接收数据");
        socket.receive(packet1);
        //进行拆包
        int length = packet1.getLength();
        byte[] data1 = packet1.getData();
        String s = new String(data1,0,length);
        System.out.println(s);

        socket.close();

    }
}
