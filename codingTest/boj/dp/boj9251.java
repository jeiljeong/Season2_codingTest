import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Logest common Subsequenc Algorithm
 * > 위의 알고리즘을 알아야 풀 수 있다. 유사도를 볼 때 사용하며, 유전이나 음성인식 등의 분야에서 사용된다.
 * 
 * cf. https://st-lab.tistory.com/139
 */
public class boj9251 {
    private static char[] str1;
    private static char[] str2;
    private static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new Integer[str1.length][str2.length];

        // 2. Biz logic
        lcs(str1.length - 1, str2.length - 1);
        
        // 3. End
        
    }
    
    private static int lcs(int x, int y) {

        if (x == -1 || y == - 1)  {
            return 0;
        }

        if (dp[x][y] == null) {
            dp[x][y] = 0;

            if (str1[x] == str2[y]) {
                dp[x][y] = lcs(x - 1, y - 1) + 1;
            }
            else {
                dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
            }
        }

        return dp[x][y];
    }
}
