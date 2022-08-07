package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1934 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int origin_a = a;
            int origin_b = b;

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

            System.out.println(origin_a * origin_b / b);
        }
    }
}
