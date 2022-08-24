package com.series;

public class Series {
    public static int nSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static long factorial(int n) {
        if (n == 0)
            return 1;
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int fibonacci(int n) {
        // recursive approach
        if (n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);

        // straight forward approach
        /*
        if (n == 0) return 0;
        if (n == 1) return 1;
        long nMinus1 = 1;
        long nMinus2 = 0;
        long fib = 0;
        for (int i = 0; i < n; i++) {
            fib = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
        */
    }
}
