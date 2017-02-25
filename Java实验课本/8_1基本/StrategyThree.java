package com.example;

public class StrategyThree implements Group {
    public void group(int n) {
        System.out.printf("\n 将 1-%d 按个位是否是 3,4,5,7 分成两组:", n);
        System.out.printf("\n 个位是 3,4,5 或 7 的组:\n");
        for (int i = 1; i <= n; i++) {
            if (i % 10 == 3 || i % 10 == 4 || i % 10 == 5 || i % 10 == 7)
                System.out.printf("%3d", i);
        }
        System.out.printf("\n 个位不是 3,4,5,7 的组:\n");
        for (int i = 1; i <= n; i++) {
            if (!(i % 10 == 3 || i % 10 == 4 || i % 10 == 5 || i % 10 == 7))
                System.out.printf("%3d", i);
        }
    }
}