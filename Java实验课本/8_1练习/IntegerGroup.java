package com.example;

public class IntegerGroup {
    Group strategy;

    public void setStrategy(Group strategy) {
        this.strategy = strategy;
    }

    public void integerDivide(int n) {
        if (strategy != null) strategy.group(n);
        else System.out.println("没有分组策略可用");
    }
}