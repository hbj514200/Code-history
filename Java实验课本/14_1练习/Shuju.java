package com.example;

import java.sql.*;
import java.util.*;

public class Shuju {
    public static void main(String args[]) {
        int wantRecordAmount = 20;  //随机抽取的记录数目
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
            String uri = "jdbc:mysql://localhost:3306/school";
            String id = "root";
            String password = "root";
            con = DriverManager.getConnection(uri, id, password);
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery("SELECT * FROM student");
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
                double price = rs.getDouble(3);
                sum = sum + price;
                itemAmount--;
                vector.removeElementAt(randomIndex);
            } con.close();
            double aver = sum / n;
            System.out.println("平均分:" + aver + "分");
        } catch (SQLException e) {
            System.out.println("" + e);
        }
    }
}


/**
 CREATE DATABASE school;
 use school;
 CREATE TABLE student(
 number varchar(13) NOT NULL PRIMARY KEY,
 name varchar(8) NOT NULL,
 fen int NOT NULL
 );
 INSERT INTO student VALUES('20150150101','洗发水',1);
 INSERT INTO student VALUES('20150150102','沐浴露',2);
 INSERT INTO student VALUES('20150150103','好牙膏',3);
 INSERT INTO student VALUES('20150150104','大肥皂',4);
 INSERT INTO student VALUES('20150150105','黑芝麻',5);
 INSERT INTO student VALUES('20150150106','按摩器',6);
 INSERT INTO student VALUES('20150150107','小火柴',7);
 INSERT INTO student VALUES('20150150108','面巾纸',8);
 INSERT INTO student VALUES('20150150109','马克杯',9);
 INSERT INTO student VALUES('2015015010a','众生丸',10);
 INSERT INTO student VALUES('2015015010b','护发素',11);
 INSERT INTO student VALUES('2015015010c','洗衣粉',12);
 INSERT INTO student VALUES('2015015010d','洗发水',1);
 INSERT INTO student VALUES('2015015010e','沐浴露',2);
 INSERT INTO student VALUES('2015015010f','好牙膏',3);
 INSERT INTO student VALUES('2015015010g','大肥皂',4);
 INSERT INTO student VALUES('2015015010h','黑芝麻',5);
 INSERT INTO student VALUES('2015015010i','按摩器',6);
 INSERT INTO student VALUES('2015015010j','小火柴',7);
 INSERT INTO student VALUES('2015015010k','面巾纸',8);
 INSERT INTO student VALUES('2015015010l','马克杯',9);
 INSERT INTO student VALUES('2015015010m','众生丸',10);
 INSERT INTO student VALUES('2015015010n','护发素',11);
 INSERT INTO student VALUES('2015015010o','洗衣粉',12);
 **/