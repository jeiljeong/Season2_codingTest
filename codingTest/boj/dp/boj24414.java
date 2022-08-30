package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj24414 {
    private static int[] fibStore;
    private static int repeat1 = 1;
    private static int repeat2 = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 2. Biz logic
        fibStore = new int[n + 1];
        fib1(n);
        fib2(n);
        
        // 3. End
        System.out.println(repeat1 + " " + repeat2);
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        repeat1++;
        return fib1(n - 1) + fib1(n - 2);
    }

    private static int fib2(int n) {
        fibStore[1] = 1;
        fibStore[2] = 1;
        for (int i = 3; i <= n; i++) {
            repeat2++;
            fibStore[i] = fibStore[i - 1] + fibStore[i - 2];
        }
        return fibStore[n];
    }
}
