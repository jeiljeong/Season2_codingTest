package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj10816 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer nStr = new StringTokenizer(br.readLine());
        Set<Integer, Integer> nums = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nStr.nextToken();
        }
    }
}
