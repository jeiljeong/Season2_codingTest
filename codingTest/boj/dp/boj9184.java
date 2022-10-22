import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Caution : StringTokenizer should be split by " " explicitly, if not, then compiler can make Number Format Runtime Error.
 * cf. https://st-lab.tistory.com/190
 */
public class boj9184 {
    private static int[][][] store = new int[21][21][21];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 2. Biz logic
            if (!isValid(a, b, c))
                break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(make(a, b, c)).append("\n");
        }
        // 3. End
        System.out.println(sb);
    }

    private static int make(int a, int b, int c) {
        if (inRange(a, b, c) && store[a][b][c] != 0) {
            return store[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return store[20][20][20] = make(20, 20, 20);
        }

        if (a < b && b < c) {
            return store[a][b][c] = make(a, b, c - 1) + make(a, b - 1, c - 1) - make(a, b - 1, c);
        }

        return store[a][b][c] = make(a - 1, b, c) + make(a - 1, b - 1, c) + make(a - 1, b, c - 1) - make(a - 1, b - 1, c - 1);
    }

    private static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }

    private static boolean isValid(int a, int b, int c) {
        if (a == -1 && b == - 1 && c == -1)
            return false;
        return true;
    }
}
