import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class boj1927 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();        
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        
        // 2. Biz logic
        Integer input = null;
        Integer output = null;
        for (int i = 0; i < n; i++) {
            input = Integer.valueOf(br.readLine());

            if (input == 0) {
                output = pq.poll();

                if (output == null) {
                    sb.append("0\n");
                } else {
                    sb.append(output).append("\n");
                }
            }
            else {
                pq.offer(input);
            }
        }
        
        // 3. End
        System.out.println(sb);
    }
}
