package Test.File;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FileTest {
    public static void main(String [] args){
        File file = new File("C:\\Users\\Y\\Desktop\\123.txt");
        System.out.println(file.getName());
        System.out.println(file.getParentFile());
        System.out.println(file.getAbsoluteFile());

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Y\\Desktop\\123.txt");
            fileWriter.write("我爱中国");
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Users\\Y\\Desktop\\123.txt");
            System.out.println(fileReader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\Y\\Desktop\\123.txt",true);
            fileOutputStream.write("!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Y\\Desktop\\123.txt");
            System.out.println(fileInputStream.read());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\Y\\Desktop\\123.txt",false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream );
            objectOutputStream.writeObject(new Integer(1));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\Y\\Desktop\\123.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Users\\Y\\Desktop\\123.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write("I Love U");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("C:\\Users\\Y\\Desktop\\123.txt");
            bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null){
                System.out.println(bufferedReader.readLine());
                System.out.println(bufferedReader.lines());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(),"UTF-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\Y\\Desktop\\123.html",false),"UTF-8"));
            String msg;
            while ((msg = bufferedReader.readLine()) != null)
                bufferedWriter.write(msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (MalformedURLException me) {
            me.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile1 = new RandomAccessFile(new File("C:\\Users\\Y\\Desktop\\123.txt"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("C:\\Users\\Y\\Desktop\\1234.txt"),"rw");
            randomAccessFile1.seek(2);

            String msg;
            while((msg=randomAccessFile1.readLine()) != null)
                randomAccessFile2.write(msg.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        try {
            randomAccessFile1 = new RandomAccessFile(new File("C:\\Users\\Y\\Desktop\\123.html"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("C:\\Users\\Y\\Desktop\\1234.html"),"rw");

            long fileSize = file.length();
            int blockSize = 3;
            int blockNum = (int) (fileSize / blockSize + (fileSize % blockSize > 0 ? 1:0));

            int beginNum = 0;
            int relSize = fileSize>blockSize ? blockSize : (int) fileSize;

            for (int i=0; i<blockNum; i++){
                //开线程下载
                if (i==blockNum-1){
                    beginNum = (int) fileSize;
                }else {
                    beginNum = i*blockSize;
                    fileSize -= relSize;
                }

                randomAccessFile1.seek(beginNum);
//                String msg;
//                while((msg=randomAccessFile1.readLine()) != null)
                    randomAccessFile2.write(randomAccessFile1.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

    }
}
