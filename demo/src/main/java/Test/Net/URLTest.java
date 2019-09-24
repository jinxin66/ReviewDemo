package Test.Net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String [] args) throws IOException {
//        test1();
//        test2();
        test3();
    }

    private static void test3() throws IOException {
        URL url = new URL("https://www.dianping.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent"," Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Mobile Safari/537.36");

        InputStream input = httpURLConnection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));

        String msg;
        while ((msg = reader.readLine()) != null)
            System.out.println(msg);

        reader.close();
        input.close();
    }

    private static void test2() throws IOException {
        URL url = new URL("https://www.jd.com");
        InputStream input = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));

        String msg;
        while ((msg = reader.readLine()) != null)
            System.out.println(msg);

        reader.close();
        input.close();
    }

    private static void test1() throws MalformedURLException {
        URL url = new URL("https://www.baidu.com:80/index.html?ie=utf-8#2");
        System.out.println("协议" + url.getProtocol());
        System.out.println("ip" + url.getHost());
        System.out.println("端口" + url.getPort());
        System.out.println("资源" + url.getFile());
        System.out.println("参数" + url.getQuery());
        System.out.println("锚点" + url.getRef());
    }
}
