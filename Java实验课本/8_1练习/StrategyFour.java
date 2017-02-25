package com.example;

public class StrategyFour implements Group {
    public void group(int n) {
        System.out.printf("\n 将 1-%d 用 质数 分成两组:", n);

        System.out.printf("\n 是质数的组:\n");
        for (int i = 1; i <= n; i++)
            if (zhishu(i))      System.out.printf("%4d", i);

        System.out.printf("\n 不是质数的组:\n");
        for (int i = 1; i <= n; i++)
            if (!zhishu(i))     System.out.printf("%4d", i);

    }

    private boolean zhishu(int n){
        for(int i=2; i<n; i++)  if(n%i==0)  return false;
        return true;
    }

}