package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int origin_a = a;
        int origin_b = b;

        // SWAP
        if (a < b) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        
        // 최대공약수 : 유클리드 호제법, a = bq + r -> mk = nkq + r
        // 증명 : 귀류법을 이용한 r = (m - nq)k의 서로소
        int remain = a % b;
        while (remain != 0) {
            a = b;
            b = remain;
            remain = a % b;
        }
        
        // 최대공약수
        System.out.println(b);
        // 최소공배수 = 두 수 a, b의 최대공약수(공통인수) * 최소의 배수(a, b의 Exclusive factor)
        System.out.println(origin_a * origin_b / b);
    }
}
