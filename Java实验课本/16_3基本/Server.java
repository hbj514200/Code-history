package com.example;

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;

public class Server {
    public static void main(String args[]) {
        ServerSocket server = null;
        ServerThread thread;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(4331);
            } catch (IOException e1) {
                System.out.println("正在监听");
            } try {
                you =server.accept();
                System.out.println("客户的地址:" + you.getInetAddress());
            } catch (IOException e) {
                System.out.println("正在等待客户");
            } if (you != null) {
                new ServerThread(you).start();
            }
        }
    }
}

class ServerThread extends Thread {
    //private ObjectInputStream in = null;
    private ObjectOutputStream out = null;
    private JFrame window;

    ServerThread(Socket socket) {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            //in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) { e.printStackTrace(); }
        window = new JFrame();
        JTextArea text = new JTextArea();
        for (int i = 1; i <= 20; i++) {
            text.append("你好,我是服务器上的文本区组件\n");
        }
        text.setBackground(Color.yellow);
        window.add(text);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        try {
            out.writeObject(window);
        } catch (IOException e) {
            System.out.println("客户离开");
        }
    }
}