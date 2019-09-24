package Test.Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String [] args) throws UnknownHostException {
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println(address1.getHostAddress() + " " + address1.getHostName());

        InetAddress address2 = InetAddress.getByName("www.baidu.com");
        System.out.println(address2.getHostAddress() + " " + address2.getHostName());

        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",8080);
        InetSocketAddress socketAddress2 = new InetSocketAddress("127.0.0.1",9090);
        System.out.println(socketAddress1.getHostName() + " " + socketAddress2.getAddress());
    }
}
