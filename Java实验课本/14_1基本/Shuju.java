package com.example;

import java.sql.*;
import java.util.*;

public class Shuju {
    public static void main(String args[]) {
        int wantRecordAmount = 10;  //随机抽取的记录数目
        Random random = new Random();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con;
        Statement sql;
        ResultSet rs;
        try {
            String uri = "jdbc:mysql://localhost:3306/shop";
            String id = "root";
            String password = "root";
            con = DriverManager.getConnection(uri, id, password);
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM goods");
            rs.last();                                       //将 rs 的游标移到 rs 的最后一行
            int count = rs.getRow();
            Vector<Integer> vector = new Vector<>();
            for (int i = 1; i <= count; i++)    vector.add(i);
            int itemAmount = Math.min(wantRecordAmount, count);
            System.out.println("随机抽取" + itemAmount + "条记录.");
            double sum = 0, n = itemAmount;
            while (itemAmount > 0) {
                int randomIndex = random.nextInt(vector.size());
                int index = vector.elementAt(randomIndex);
                rs.absolute(index);
                String number = rs.getString(1);
                String name = rs.getString(2);
                java.util.Date date = rs.getDate(3);
                double price = rs.getDouble(4);
                sum = sum + price;
                itemAmount--;
                vector.removeElementAt(randomIndex);
            } con.close();
            double aver = sum / n;
            System.out.println("均价:" + aver + "元");
        } catch (SQLException e) {
            System.out.println("" + e);
        }
    }
}

/**
 CREATE DATABASE shop;
 use shop;
 CREATE TABLE goods(
 number varchar(13) NOT NULL PRIMARY KEY,
 name varchar(8) NOT NULL,
 madeTime datetime NOT NULL,
 price decimal(8,2) NOT NULL
 );
 INSERT INTO goods VALUES('20150150101','洗发水','2015-1-1',1);
 INSERT INTO goods VALUES('20150150102','沐浴露','2015-2-1',2);
 INSERT INTO goods VALUES('20150150103','好牙膏','2015-3-1',3);
 INSERT INTO goods VALUES('20150150104','大肥皂','2015-4-1',4);
 INSERT INTO goods VALUES('20150150105','黑芝麻','2015-5-1',5);
 INSERT INTO goods VALUES('20150150106','按摩器','2015-6-1',6);
 INSERT INTO goods VALUES('20150150107','小火柴','2015-7-1',7);
 INSERT INTO goods VALUES('20150150108','面巾纸','2015-8-1',8);
 INSERT INTO goods VALUES('20150150109','马克杯','2015-9-1',9);
 INSERT INTO goods VALUES('2015015010a','众生丸','2015-10-1',10);
 INSERT INTO goods VALUES('2015015010b','护发素','2015-11-1',11);
 INSERT INTO goods VALUES('2015015010c','洗衣粉','2015-12-1',12);
 **/