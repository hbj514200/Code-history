package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQL {
    private static MySQL sqlClass = new MySQL();
    private Statement stat;

    public static MySQL getInstance(){
        return sqlClass;
    }

    private MySQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jiudian", "root", "root");
            stat = con.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet cha(String url){
        try {
            return stat.executeQuery(url);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void cao(String url){
        try {
            stat.executeUpdate(url);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
