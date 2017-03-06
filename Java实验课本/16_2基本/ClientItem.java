package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientItem {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Socket clientSocket = null;
        DataInputStream inData = null;
        DataOutputStream outData = null;
        Thread thread;
        Read read = null;
        try {
            clientSocket = new Socket();
            read = new Read();
            thread = new Thread(read);   //负责读取信息的线程
            System.out.print("输入服务器的 IP:");
            String IP = scanner.nextLine();
            System.out.print("输入端口号:");
            int port = scanner.nextInt();
            scanner.nextLine(); //消耗回车
            if (!clientSocket.isConnected()) {
                InetAddress address = InetAddress.getByName(IP);
                InetSocketAddress socketAddress = new InetSocketAddress(address, port);
                clientSocket.connect(socketAddress);
                InputStream in =clientSocket.getInputStream();
                OutputStream out =clientSocket.getOutputStream();
                inData = new DataInputStream(in);
                outData = new DataOutputStream(out);
                read.setDataInputStream(inData);
                read.setDataOutputStream(outData);
                thread.start();  //启动负责读信息的线程
            }
        } catch (Exception e) {
            System.out.println("服务器已断开" + e);
        }
    }
}

class Read implements Runnable {
    private Scanner scanner = new Scanner(System.in);
    private DataInputStream in;
    private DataOutputStream out;

    public void setDataInputStream(DataInputStream in) {
        this.in = in;
    }

    public void setDataOutputStream(DataOutputStream out) {
        this.out = out;
    }

    public void run() {
        System.out.println("输入账单:");
        String content = scanner.nextLine();
        try {
            out.writeUTF("账单" + content);
            String str = in.readUTF();
            System.out.println(str);
            str = in.readUTF();
            System.out.println(str);
            str = in.readUTF();
            System.out.println(str);
        } catch (Exception ignored) {}
    }
}
