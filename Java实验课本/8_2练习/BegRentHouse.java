package com.example;

public class BegRentHouse implements Colleague {    // 中介者模式中的具体同事（求租者）
    ConcreteMediator mediator;                   //中介者
    String name;

    BegRentHouse(ConcreteMediator mediator) {
        this.mediator = mediator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void giveMess(String mess) {
        mediator.deliverMess(this, mess);
    }

    public void receiverMess(String mess) {
        System.out.println(name + "收到的信息:");
        System.out.println("\t" + mess);
    }
}