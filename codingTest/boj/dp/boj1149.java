package codingTest.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * cf.
 */
public class boj1149 {
    private static int n;
    private static int[] dp;
    private static int[][] rgb;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        dp = new int[n];
        rgb = new int[n][3];
        
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. Biz logic
        rgbSelect(0,0, 0);
        
        
        // 3. End
        
    }

    private static void rgbSelect(int avoidRgb, int depth, int sum) {
        
        for (int i = 0; i < 3; i++) {
            if (i == avoidRgb)
                continue;
            sum += rgb[depth][i];
            min = Math.min(sum, min);
            rgbSelect(i, depth + 1, sum);
            sum -= rgb[depth][i];
        }
    }
}
