package Test.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameTest extends JFrame {
    // 初始化
    public void lanuchFrame(){
        this.setTitle("我的标题");
        this.setVisible(true);
        //this.setLocation(100，100);
        this.setSize(800,600);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //定义一个按钮
        JButton bt = new JButton("关闭按钮");
        this.setLayout(new FlowLayout());
        this.add(bt);
        bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrameTest.this.dispose();
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    java.awt.Image img = Toolkit.getDefaultToolkit().getImage("");
    @Override
    public void paint(Graphics g){
        // g.setColor(Color.yellow);
        // g.draw3DRect(100,100,100,100,true); // 矩形
        g.drawImage(img, 100, 100, 50, 50, null);
    }

    public static void main(String[] args)throws Exception{
        JFrameTest test = new JFrameTest();
        test.lanuchFrame();

    }
}