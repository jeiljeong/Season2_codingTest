import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9184_v2 {
    private static int[][][] matrix = new int[101][101][101];
    private static int BIAS = 50;
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    matrix[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        // 2. Biz logic
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringTokenizer st = null;
        int num[] = new int[3];
        int result;

        while (true) {
            input = br.readLine();
           
            if (input == null)
                break;
            
            st = new StringTokenizer(input);

            for (int i = 0; i < 3; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            if (num[0] == -1 && num[1] == -1 && num[2] == -1)
                break;

            result = w(num[0], num[1], num[2]);

            System.out.println("w(" + num[0] + ", " + num[1] + ", " + num[2] + ") = " + result);
        }
        
        // 3. End
    }

    private static int w(int a, int b, int c) {
        if (matrix[index(a)][index(b)][index(c)] != Integer.MIN_VALUE)
            return matrix[index(a)][index(b)][index(c)];

        if (a <= 0 || b <= 0 || c <= 0) {
            return matrix[index(a)][index(b)][index(c)] = 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return matrix[index(a)][index(b)][index(c)] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            return matrix[index(a)][index(b)][index(c)] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return matrix[index(a)][index(b)][index(c)] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    private static int index(int num) {
        return num + BIAS;
    }
}
