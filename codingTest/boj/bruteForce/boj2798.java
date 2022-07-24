package codingTest.boj.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                        new BufferedReader(new InputStreamReader(System.in));

        // 1. INPUT - 1st line
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        // 2. INPUT - 2nd line
        st = new StringTokenizer(br.readLine());
        List<Integer> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        // 3. Biz Logic
        long result = 0;
        long compare = 0;

        // 3중 for문으로 해결
        for (int i = 0; i < cards.size() - 2; i++) {
            for (int j = i + 1; j < cards.size() - 1; j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    compare = cards.get(i) + cards.get(j) + cards.get(k);
                    
                    if (compare <= max && compare > result) {
                        result = compare;
                    }
                }
            } 
        }

        // 4. OUTPUT
        System.out.println(result);
    }
}
