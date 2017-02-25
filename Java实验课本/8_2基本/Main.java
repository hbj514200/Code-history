package com.example;

/**
 * 在这例子中，中介者很形象，但是并没有展示出它的用途以及适用场合。 但是有点意思是：这里有一个 观察者模式 味道
 */

public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        RentHouse rentHouse[] = new RentHouse[2];
        rentHouse[0] = new RentHouse(mediator);
        rentHouse[1] = new RentHouse(mediator);
        rentHouse[0].setName("张三");
        rentHouse[1].setName("李四");

        BegRentHouse begRentHouse[] = new BegRentHouse[1];
        begRentHouse[0] = new BegRentHouse(mediator);
        begRentHouse[0].setName("朱方");
        mediator.registerRentHouse(rentHouse);
        mediator.registerBegRentHouse(begRentHouse);
        rentHouse[0].giveMess("房屋出租：租金是 800 元/月");
        rentHouse[1].giveMess("房屋出租：租金是 900 元/月");
        begRentHouse[0].giveMess("求租房屋：租金不高于 800 元/月");
    }
}
