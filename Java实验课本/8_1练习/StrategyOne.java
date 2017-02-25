package com.example;

public class StrategyOne implements Group {
    public void group(int n) {
        System.out.printf("\n 将 1-%d 按奇偶数分成两组:", n);
        System.out.printf("\n 偶数组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) System.out.printf("%4d", i);
        }
        System.out.printf("\n 奇数组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) System.out.printf("%4d", i);
        }
    }
}