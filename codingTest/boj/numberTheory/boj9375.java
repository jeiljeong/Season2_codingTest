package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Fashion King Shinhaebin, solved by using combination
 * cf. https://st-lab.tistory.com/164
 */
public class boj9375 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        
        
        StringTokenizer st = null;
        for (int i = 0; i < testCase; i++) {
            HashMap<String, Integer> clothes = new HashMap<>();
            int lines = Integer.parseInt(br.readLine());
            for (int j = 0; j < lines; j++) {
                st = new StringTokenizer(br.readLine());
                
                // 2. Biz logic
                
                // Discards clothes name
                st.nextToken();
                
                String kind = st.nextToken();
                
                if (clothes.containsKey(kind)) {
                    clothes.put(kind, clothes.get(kind) + 1);
                } else {
                    clothes.put(kind, 1);
                }
            }

            int result = 1;

            for (int val : clothes.values()) {
                result *= (val + 1);
            }
            
            // add (-1), because that means naked
            sb.append(result - 1).append('\n');
        }

        // 3. End
        System.out.println(sb);
    }
}
