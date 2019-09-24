package Test.Net;

import java.io.*;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TCPTest {
    public static void main(String [] args) {
        new Thread(()->{
            try {
                TCPService.receive();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class TCPTest3 {
    public static void main(String [] args) {
        new Thread(()->{
            try {
                TCPClicnt.send();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class TCPService {
    private static CopyOnWriteArrayList<Clicnt> list = new CopyOnWriteArrayList<Clicnt>();

    public static void receive() throws IOException {
        System.out.println("服务端接收接口启动");
        // ServerSocket 创建 接收端口
        ServerSocket server = new ServerSocket(8000);

        while (true){
            Socket socket = server.accept();
            System.out.println("一个用户连接");

            Clicnt clicnt = new Clicnt(socket);
            list.add(clicnt);
            new Thread(clicnt).start();
        }
    }

    static class Clicnt implements Runnable{
        Socket socket;
        DataOutputStream outputStream;
        DataInputStream inputStream;

        public Clicnt(Socket socket) throws IOException {
            this.socket = socket;
            // 创建接收内容发送返回值
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            this.inputStream = new DataInputStream(socket.getInputStream());
        }

        @Override
        public void run() {
            try {
                while (true){
                    String msg = this.inputStream.readUTF();
                    System.out.println(msg);
                    //自己也在listzhong
                    for (Clicnt other : list){
                        if (other != this){
                            other.outputStream.writeUTF(msg);
                            other.outputStream.flush();
                        }
                    }
                    this.outputStream.writeUTF("成功");
                    this.outputStream.flush();

                    if (msg.equals("关闭"))
                        break;
                }
                this.inputStream.close();
                this.outputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class TCPClicnt{
    public static void send() throws IOException {
        System.out.println("发送方启动");
        // ServerSocket 创建 发送端口
        Socket socket = new Socket("localhost",8000);

        // 创建发送内容接收返回值
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        while (true){
            String data = reader.readLine();

            outputStream.writeUTF(data);
            outputStream.flush();

            String msg = inputStream.readUTF();
            System.out.println(msg);

            if (data.equals("bye"))
                break;
        }
        inputStream.close();
        outputStream.close();
        reader.close();
        socket.close();
    }
}