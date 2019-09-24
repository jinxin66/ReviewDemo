package Test.Net;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPTest {
    public static void main(String [] args) {
        new Thread(()->{
            try {
                UDPService.send();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                UDPService.receive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class UDPTest2 {
    public static void main(String [] args) {
        new Thread(()->{
            try {
                UDPClicnt.send();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                UDPClicnt.receive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class UDPService {
    public static void send() throws IOException {
        System.out.println("服务端发送端口启动");
        // 使用DatagramSocket 创建 发送端口
        DatagramSocket socket = new DatagramSocket(8101);

        // 创建发送内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String data = reader.readLine();
            byte[] bytes = data.getBytes();
            // 封装打包 DatagramPacket 指定接收地址
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,
                    new InetSocketAddress("localhost",9201));

            socket.send(packet);

            if (data.equals("bye"))
                break;
        }
        socket.close();
    }

    public static void receive() throws IOException {
        System.out.println("服务端接收端口启动");
        // 使用DatagramSocket 创建 接收端口
        DatagramSocket socket = new DatagramSocket(8201);
        while (true){
            // 接收发送内容
            byte[] temp = new byte[1024*60];
            // 封装打包 DatagramPacket 指定接收地址
            DatagramPacket packet = new DatagramPacket(temp,0,temp.length);

            socket.receive(packet);

            byte[] data = packet.getData();
            String str = new String(data,0,packet.getLength());
            System.out.println(str);

            if (str.equals("bye"))
                break;
        }
        socket.close();
    }
}

class UDPClicnt{
    public static void send() throws IOException {
        System.out.println("客户端发送端口启动");
        // 使用DatagramSocket 创建 发送端口
        DatagramSocket socket = new DatagramSocket(9101);

        // 创建发送内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String data = reader.readLine();
            byte[] bytes = data.getBytes();
            // 封装打包 DatagramPacket 指定接收地址
            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,
                    new InetSocketAddress("localhost",8201));

            socket.send(packet);

            if (data.equals("bye"))
                break;
        }
        socket.close();
    }

    public static void receive() throws IOException {
        System.out.println("客户端接收端口启动");
        // 使用DatagramSocket 创建 接收端口
        DatagramSocket socket = new DatagramSocket(9201);
        while (true){
            // 接收发送内容
            byte[] temp = new byte[1024*60];
            // 封装打包 DatagramPacket 指定接收地址
            DatagramPacket packet = new DatagramPacket(temp,0,temp.length);

            socket.receive(packet);

            byte[] data = packet.getData();
            String str = new String(data,0,packet.getLength());
            System.out.println(str);

            if (str.equals("bye"))
                break;
        }
        socket.close();
    }

//    public static void send2() throws IOException {
//        System.out.println("发送方启动");
//        // 使用DatagramSocket 创建 发送端口
//        DatagramSocket socket = new DatagramSocket(8888);
//
//        // 创建发送内容
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        DataOutputStream dataOutputStream = new DataOutputStream(
//                new BufferedOutputStream(byteArrayOutputStream));
//
//        //String data = "发送以下内容";
//
//        dataOutputStream.writeUTF("utf");
//        dataOutputStream.writeInt(1);
//        dataOutputStream.writeBoolean(false);
//        dataOutputStream.writeChar('a');
//
//        dataOutputStream.flush();
//
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        // 封装打包 DatagramPacket 指定接收地址
//        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,
//                new InetSocketAddress("localhost",9999));
//
//        socket.send(packet);
//        socket.close();
//    }
}