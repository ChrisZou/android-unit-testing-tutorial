package com.chriszou.auttutorial.junit;

/**
 * Created by xiaochuang on 4/12/16.
 */
public class Calculator {
    public int add(int one, int another) {
        return one + another;
    }

    public int multiply(int one, int another) {
        // 为了简单起见，暂不考虑溢出等情况。
        return one * another;
    }

    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");
        return divident / dividor;
    }
}
