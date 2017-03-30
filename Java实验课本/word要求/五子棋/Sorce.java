package com.example;

public class Sorce {

    public static int getFen(int num, int si){
        int[] sorce = {0, 10, 100, 1000, 10000, 100000,100000,100000,100000,100000,100000};
        if(num-si<0)    return 0;
        return sorce[num-si];
    }

}
