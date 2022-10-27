import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1);
                int abs2 = Math.abs(o2);

                if (abs1 == abs2) return o1 > o2 ? 1 : -1;
                return abs1 - abs2;
            }
            
        });

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
