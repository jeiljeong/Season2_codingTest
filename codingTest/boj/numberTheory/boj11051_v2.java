package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * ArrayList version
 * 
 * result : Index out of bound Exception
 */

public class boj11051_v2 {
    private static ArrayList<ArrayList<Long>> dp;

    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Long n = Long.valueOf(st.nextToken());
        Long k = Long.valueOf(st.nextToken());

        dp = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            ArrayList<Long> kList = new ArrayList<Long>();
            for (int j = 0; j < k + 1; j++) {
                kList.add(0L);
            }
            dp.add(kList);
        }
        
        // 2. Biz logic

        // 3. End
        System.out.println(binomialCoeffcient(n, k) % 100_007);
    }

    private static Long binomialCoeffcient(Long n, Long k) {
        // 1. Is it already solved problem?
        if (dp.get(n.intValue()).get(k.intValue()) > 0) {
            return dp.get(n.intValue()).get(k.intValue());
        }

        // 2. Properties of Binomial Coefficient & Stop index of recursion
        if (k == 0 || n == k) {
            dp.get(n.intValue()).set(k.intValue(), 1L);
            return 1L;
        }

        // 3. Pascal's triangle by usage of recursion
        dp.get(n.intValue()).set(k.intValue(), binomialCoeffcient(n - 1, k - 1)
        + binomialCoeffcient(n - 1, k));
        
        return dp.get(n.intValue()).get(k.intValue());
    }
}
