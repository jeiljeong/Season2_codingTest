package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9663 {
    private static int[] map;
    private static int n;
    private static int count = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n];
        
        // 2. Biz logic
        nQueen(0);
        
        // 3. End
        System.out.println(count);
    }

    /**
     * @param depth (means the number of Queens in map)
     */
    private static void nQueen(int depth) {
        // Every Queens is laid down on the map, then increase the count and terminate.
        if (depth == n) {
            count++;
            return ;
        }

        // If x, y coordinate is possible to lay down, then sustain map[depth] allocation and deep into down for the next queen's position
        for (int i = 0; i < n; i++) {
            map[depth] = i;
            if (isPossible(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    /**
     * 
     * 
     * @param col (col means both depth level of nQueens and column level from left to right on the map)
     * @return boolean
     */
    private static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            /**
             * map[i] means
             * x = column & sequencial number of nQueens,
             * y = row that Queen's coordinate on the map has been sited
             */
            // Thus, check row possiblity by using iteration
            if (map[col] == map[i]) {
                return false;
            }
            // then, check cross line by using abs(x1 - x2) == abs(y1 - y2)
            else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
                return false;
            }
        }
        
        return true;
    }
}
