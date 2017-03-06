package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerItem {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(4331);
            } catch (IOException e1) {
                System.out.println("正在监听");
            } try {
                System.out.println("正在等待客户");
                you =server.accept();
                System.out.println("客户的地址:" + you.getInetAddress());
            } catch (IOException e) {
                System.out.println("" + e);
            } if (you != null) {
                new ServerThread(you).start();
            }
        }
    }
}

class ServerThread extends Thread {
    private DataInputStream in = null;
    private DataOutputStream out = null;

    ServerThread(Socket t) {
        try {
            out = new DataOutputStream(t.getOutputStream());
            in = new DataInputStream(t.getInputStream());
        } catch (IOException ignored) {}
    }

    public void run() {
        try {
            String item = in.readUTF();
            Scanner scanner = new Scanner(item);
            scanner.useDelimiter("[^0123456789.]+");
            if (item.startsWith("账单")) {
                double sum = 0;
                while (scanner.hasNext()) {
                    try {
                        double price = scanner.nextDouble();
                        sum = sum + price;
                        System.out.println(price);
                    } catch (InputMismatchException ignored) {}
                }
                out.writeUTF("您的账单:");
                out.writeUTF(item);
                out.writeUTF("总额:" + sum + "元");
            }
        } catch (Exception ignored) {
        }
    }
}