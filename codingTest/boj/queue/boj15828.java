import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class boj15828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedBlockingQueue<>(n);        
        
        // 2. Biz logic
        while (true) {
            Integer input = Integer.valueOf(br.readLine());

            if (input == -1) {
                break;
            }
            else if (input > 0) {
                queue.offer(input);
            }
            else if (input == 0) {
                queue.poll();
            }
        }

        // 3. End
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            sb.append(queue.poll()).append(' ');
        }
        sb.append('\n');

        System.out.println(sb);
    }
}
