package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerNumber {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket you = null;
        while (true) {
            try {
                server = new ServerSocket(4331);
            } catch (IOException e1) {
                System.out.println("正在监听");
            } try {
                you = server.accept();
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
    private DataInputStream in = null;
    private DataOutputStream out = null;

    ServerThread(Socket socket) {
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException ignored) {}
    }

    public void run() {
        try {
            while (true) {
                String str = in.readUTF();
                boolean boo = str.startsWith("Y") || str.startsWith("y");
                if (boo) {
                    out.writeUTF("服务端：给你一个 1 至 100 之间的随机数,请猜它是多少呀!");
                    Random random = new Random();
                    int realNumber = random.nextInt(100) + 1;
                    handleClientGuess(realNumber);
                    out.writeUTF("询问:想继续玩输入 Y，否则输入 N:");
                } else {
                    return;
                }
            }
        } catch (Exception ignored) { }
    }

    private void handleClientGuess(int realNumber) {
        while (true) {
            try {
                int clientGuess = in.readInt();
                System.out.println(clientGuess);
                if (clientGuess > realNumber) out.writeUTF("猜大了");
                else if (clientGuess < realNumber) out.writeUTF("猜小了");
                else if (clientGuess == realNumber) {
                    out.writeUTF("猜对了！");
                    break;
                }
            } catch (IOException e) {
                System.out.println("客户离开");
                return;
            }
        }
    }
}