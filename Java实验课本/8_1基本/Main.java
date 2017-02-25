package com.example;

public class Main {
    public static void main(String[] args) {
        IntegerGroup makeGroup = new IntegerGroup();  //上下文对象
        makeGroup.setStrategy(new StrategyOne());
        makeGroup.integerDivide(20);
        makeGroup.setStrategy(new StrategyTwo());
        makeGroup.integerDivide(20);
        makeGroup.setStrategy(new StrategyThree());
        makeGroup.integerDivide(20);
    }
}
