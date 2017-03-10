package com.example;

import java.sql.*;

public class TurnMoney {
    public static void main(String args[]) {
        Connection con = null;
        Statement sql;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            double n = 100;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            con.setAutoCommit(false);
            sql = con.createStatement();
            rs = sql.executeQuery("SELECT * FROM card1 WHERE number='20150150101'");
            rs.next();
            double amountOne = rs.getDouble("amount");
            System.out.println("转账操作之前 20150150101 的钱款数额:" + amountOne);
            rs = sql.executeQuery("SELECT * FROM card2 WHERE number='20150150102'");
            rs.next();
            double amountTwo = rs.getDouble("amount");
            System.out.println("转账操作之前 20150150102 的钱款数额:" + amountTwo);
            amountOne = amountOne - n;
            amountTwo = amountTwo + n;
            sql.executeUpdate("UPDATE card1 SET amount =" + amountOne + " WHERE number ='20150150101'");
            sql.executeUpdate("UPDATE card2 SET amount =" + amountTwo + " WHERE number ='20150150102'");
            con.commit();
            con.setAutoCommit(true);
            rs = sql.executeQuery("SELECT * FROM card1 WHERE number='20150150101'");
            rs.next();
            amountOne = rs.getDouble("amount");
            System.out.println("转账操作之后 20150150101 的钱款数额:" + amountOne);
            rs = sql.executeQuery("SELECT * FROM card2 WHERE number='20150150102'");
            rs.next();
            amountTwo = rs.getDouble("amount");
            System.out.println("转账操作之后 20150150102 的钱款数额:" + amountTwo);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException exp) {
            } System.out.println(e.toString());
        }
    }
}

/**
 CREATE DATABASE bank;
 use bank;
 CREATE TABLE card1(
 number varchar(13) NOT NULL PRIMARY KEY,
 name varchar(8) NOT NULL,
 amount DECIMAL(10,2) NOT NULL
 );
 CREATE TABLE card2(
 number varchar(13) NOT NULL PRIMARY KEY,
 name varchar(8) NOT NULL,
 amount DECIMAL(10,2) NOT NULL
 );
 INSERT INTO card1 VALUES('20150150101','洗发水',1);
 INSERT INTO card1 VALUES('20150150102','沐浴露',2);
 INSERT INTO card1 VALUES('20150150103','好牙膏',3);
 INSERT INTO card1 VALUES('20150150104','大肥皂',4);
 INSERT INTO card1 VALUES('20150150105','黑芝麻',5);
 INSERT INTO card1 VALUES('20150150106','按摩器',6);
 INSERT INTO card1 VALUES('20150150107','小火柴',7);
 INSERT INTO card1 VALUES('20150150108','面巾纸',8);
 INSERT INTO card1 VALUES('20150150109','马克杯',9);
 INSERT INTO card1 VALUES('2015015010a','众生丸',10);
 INSERT INTO card1 VALUES('2015015010b','护发素',11);
 INSERT INTO card1 VALUES('2015015010c','洗衣粉',12);
 INSERT INTO card1 VALUES('2015015010d','洗发水',1);
 INSERT INTO card1 VALUES('2015015010e','沐浴露',2);
 INSERT INTO card1 VALUES('2015015010f','好牙膏',3);
 INSERT INTO card1 VALUES('2015015010g','大肥皂',4);
 INSERT INTO card1 VALUES('2015015010h','黑芝麻',5);
 INSERT INTO card1 VALUES('2015015010i','按摩器',6);
 INSERT INTO card1 VALUES('2015015010j','小火柴',7);
 INSERT INTO card1 VALUES('2015015010k','面巾纸',8);
 INSERT INTO card1 VALUES('2015015010l','马克杯',9);
 INSERT INTO card1 VALUES('2015015010m','众生丸',10);
 INSERT INTO card1 VALUES('2015015010n','护发素',11);
 INSERT INTO card1 VALUES('2015015010o','洗衣粉',12);
 INSERT INTO card2 VALUES('20150150101','洗发水',1);
 INSERT INTO card2 VALUES('20150150102','沐浴露',2);
 INSERT INTO card2 VALUES('20150150103','好牙膏',3);
 INSERT INTO card2 VALUES('20150150104','大肥皂',4);
 INSERT INTO card2 VALUES('20150150105','黑芝麻',5);
 INSERT INTO card2 VALUES('20150150106','按摩器',6);
 INSERT INTO card2 VALUES('20150150107','小火柴',7);
 INSERT INTO card2 VALUES('20150150108','面巾纸',8);
 INSERT INTO card2 VALUES('20150150109','马克杯',9);
 INSERT INTO card2 VALUES('2015015010a','众生丸',10);
 INSERT INTO card2 VALUES('2015015010b','护发素',11);
 INSERT INTO card2 VALUES('2015015010c','洗衣粉',12);
 INSERT INTO card2 VALUES('2015015010d','洗发水',1);
 INSERT INTO card2 VALUES('2015015010e','沐浴露',2);
 INSERT INTO card2 VALUES('2015015010f','好牙膏',3);
 INSERT INTO card2 VALUES('2015015010g','大肥皂',4);
 INSERT INTO card2 VALUES('2015015010h','黑芝麻',5);
 INSERT INTO card2 VALUES('2015015010i','按摩器',6);
 INSERT INTO card2 VALUES('2015015010j','小火柴',7);
 INSERT INTO card2 VALUES('2015015010k','面巾纸',8);
 INSERT INTO card2 VALUES('2015015010l','马克杯',9);
 INSERT INTO card2 VALUES('2015015010m','众生丸',10);
 INSERT INTO card2 VALUES('2015015010n','护发素',11);
 INSERT INTO card2 VALUES('2015015010o','洗衣粉',12);
 **/