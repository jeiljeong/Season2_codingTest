package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2580 {
    private static final int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. Biz logic
        sudoku(0, 0);
        
        // 3. End
    }

    private static void sudoku(int row, int col) {
        // If index of col reachs maximum index, then move on to the next row
        if (col == 9) {
            sudoku(row + 1, 0);
            return ;
        }

        // if index of row reachs maximum index, then print the map
        if (row == 9) {
            mapPrinter();

            System.exit(0);
        }

        // if satisfy the above two conditions, then check whether the val equals 0
        if (map[row][col] == 0) {
            // this variable i means number (1 ~ 9)
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            /**
             * If every number is not fit on the map,
             * then recover the zero status and back to the previous deep into down step.
             */
            map[row][col] = 0;
            return ;
        }

        // row first search - search the answer while increase the column index
        sudoku(row, col + 1);
    }

    private static boolean isPossible(int row, int col, int val) {
        // row check
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == val) {
                return false;
            }
        }

        // col check
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == val) {
                return false;   
            }
        }

        // 3 * 3 matrix check
        int matrixRow = (row / 3) * 3;
        int matrixCol = (col / 3) * 3;

        for (int i = matrixRow; i < matrixRow + 3; i++) {
            for (int j = matrixCol; j < matrixCol + 3; j++) {
                if (map[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mapPrinter() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
