package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Socket mysocket = null;
        ObjectInputStream inObject = null;
        ObjectOutputStream outObject = null;
        Thread thread;
        ReadWindow readWindow = null;
        try {
            mysocket = new Socket();
            readWindow = new ReadWindow();
            thread = new Thread(readWindow);        //负责读取信息的线程
            System.out.print("输入服务器的 IP:");
            String IP = scanner.nextLine();
            System.out.print("输入端口号:");
            int port = scanner.nextInt();
            if (!mysocket.isConnected()){
                InetAddress address = InetAddress.getByName(IP);
                InetSocketAddress socketAddress = new InetSocketAddress(address, port);
                mysocket.connect(socketAddress);
                InputStream in = mysocket.getInputStream();
                OutputStream out = mysocket.getOutputStream();

                inObject = new ObjectInputStream(in);
                //outObject = new ObjectOutputStream(out);
                readWindow.setObjectInputStream(inObject);
                thread.start();  //启动负责读取窗口的线程
            }
        } catch (Exception e) {
            System.out.println("服务器已断开" + e);
        }
    }
}

class ReadWindow implements Runnable {
    private ObjectInputStream in;

    public void setObjectInputStream(ObjectInputStream in) {
        this.in = in;
    }

    public void run() {
        while (true) {
            try {
                for(int i=1; i<=2; i++){
                    javax.swing.JFrame window = (javax.swing.JFrame) in.readObject();
                    window.setTitle("这是从服务器上读入的窗口");
                    window.setVisible(true);
                    window.requestFocusInWindow();
                    window.setSize(600, 800);
                }
            } catch (Exception e) {
                System.out.println("与服务器已断开" + e);
                break;
            }
        }
    }
}