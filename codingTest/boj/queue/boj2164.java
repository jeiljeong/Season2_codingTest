import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class boj2164 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // 2. Biz logic
        Integer tmp = null;
        while (queue.size() > 1) {
            queue.pollFirst();
            tmp = queue.pollFirst();
            queue.offer(tmp);
        }
        
        // 3. End
        System.out.println(queue.poll());
    }
}
