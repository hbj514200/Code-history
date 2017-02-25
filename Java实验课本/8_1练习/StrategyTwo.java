package com.example;

public class StrategyTwo implements Group {
    public void group(int n) {
        System.out.printf("\n 将 1-%d 用 3 求余分成三组:", n);
        System.out.printf("\n 被 3 除尽的组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) System.out.printf("%4d", i);
        }
        System.out.printf("\n 被 3 除余 1 的组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 1)
                 System.out.printf("%4d", i);
        } System.out.printf("\n 被 3 除余 2 的组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 2) System.out.printf("%4d", i);
        }
    }
}