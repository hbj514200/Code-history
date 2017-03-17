package com.example;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class ReadFile {
    public static void main(String args[]) {
        new NetWin();
    }
}

class NetWin extends JFrame implements ActionListener, Runnable {
    private JButton button;
    private URL url;
    private JTextField inputURLText; //输入 URL
    private JTextArea area;
    private byte b[] = new byte[118];
    private Thread thread;

    NetWin() {
        inputURLText = new JTextField(20);
        area = new JTextArea(12, 12);
        button = new JButton("确定");
        button.addActionListener(this);
        thread = new Thread(this);
        JPanel p = new JPanel();
        p.add(new JLabel("输入网址:"));
        p.add(inputURLText);
        p.add(button);
        add(area, BorderLayout.CENTER);
        add(p, BorderLayout.NORTH);
        setBounds(60, 60, 560, 300);
        setVisible(true);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (!(thread.isAlive())) thread = new Thread(this);
            thread.start();
    }

    public void run() {
        try {
            int n = -1;
            area.setText(null);
            String name = inputURLText.getText().trim();
            url = new URL(name);
            String hostName = url.getHost();
            int urlPortNumber = url.getPort();
            String fileName = url.getFile();
            InputStream in =url.openStream();
            area.append("\n 主机:" + hostName + "端口:" + urlPortNumber + "包含的文件名字:" + fileName);
            area.append("\n 文件的内容如下:");
            while ((n = in.read(b)) != -1) {
                String s = new String(b, 0, n);
                area.append(s);
            }
        } catch (Exception e1) {
            inputURLText.setText("" + e1);
            inputURLText.setText("正在读取……" + url);
        }
    }
}
