package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * There is some of points about backTracking
 * 1) combination is related with backTracking algorithms.
 *    - Basically combination is about finding n arguments lists in given set
 *    - Thus actually we can see the commons in the n & m problem, which has the slight differences, like duplicated visit or descending
 * 2) This problem also can be solved by using combination, and the man is like element of set
 *    - as you can see below, the solving way is shown like no double visit and no descending
 * 3) So, how can we find the proper method include a decision related to which parameter is useful and necessary
 *    - In the Deep into Down, you shoud decide the depth parameter
 * 
 * Points
 * 1) In the Combination, depth parameter is related with visit. And then you should decide some conditions like descending, duplcate visits
 * 2) In the NQueens or Sudoku, depth parameter is related with x, y coordinate that is target of given conditions check
 * 3) Finally, there are several conditions such as finding Max, Min, Summation, and so on
 *    - The only thing you finally have to do is making clarify and split the problem's condition. And choose the proper parameters and make the split method
 */
public class boj14889 {
    private static int n;
    private static int[][] matrix;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        visit = new boolean[n];

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 2. Biz logic
        combination(0, 0);
        
        // 3. End
        System.out.println(min);
    }

    private static void combination(int idx, int depth) {
        if (depth == n / 2) {
            diff();
            return ;
        }

        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static void diff() {
        int team_start = 0;
        int team_link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    team_start += matrix[i][j] + matrix[j][i];
                }
                else if (!visit[i] && !visit[j]) {
                    team_link += matrix[i][j] + matrix[j][i];
                }
            }
        }

        int val = Math.abs(team_start - team_link);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(min, val);
    }
}
