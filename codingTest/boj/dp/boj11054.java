import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11054 {
    private static int seq[];
    private static Integer dpSeq[];
    private static Integer dpRev[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];
        dpSeq = new Integer[n + 1];
        dpRev = new Integer[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // 2. Biz logic
        dpSeq[0] = 0;
        dpRev[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dpSeq[i] = 1;

            for (int j = 1; j < i; j++) {
                if (seq[i] > seq[j] && dpSeq[i] < dpSeq[j] + 1) {
                    dpSeq[i] = dpSeq[j] + 1;
                }
            }
        }
        for (int i = n; i >= 1; i--) {
            dpRev[i] = 1;

            for (int j = n; j > i; j--) {
                if (seq[i] > seq[j] && dpRev[i] < dpRev[j] + 1) {
                    dpRev[i] = dpRev[j] + 1;
                }
            }
        } 
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int biSide = dpSeq[i] + dpRev[i] - 1;
            max = Math.max(Math.max(Math.max(dpSeq[i] , dpRev[i]), biSide), max);
        }

        // 3. End
        System.out.println(max);
    }
}
