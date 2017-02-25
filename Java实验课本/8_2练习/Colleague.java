package com.example;

public interface Colleague {  // 中介者模式中的同事（Colleague）
    public void giveMess(String mess);

    public void receiverMess(String mess);

    public void setName(String name);

    public String getName();
}

//收发消息，设置获取名字