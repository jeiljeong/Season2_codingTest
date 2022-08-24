package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3036 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = 0;
        int a = Integer.parseInt(st.nextToken());
        int b = 0;
        for (int i = 1; i < n; i++) {
            b = Integer.parseInt(st.nextToken());
            gcd = _getGcd(a, b);
            System.out.println(String.valueOf(a / gcd) + "/" + String.valueOf(b / gcd));
        }
    }

    private static int _getGcd(int a, int b) {
        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }

        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }

        return b;
    }
}
