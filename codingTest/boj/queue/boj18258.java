import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj18258 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        Integer tmp = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    tmp = queue.poll();
                    if (tmp == null) {
                        sb.append("-1\n");
                    } else {
                        sb.append(tmp).append('\n');
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    tmp = queue.peekFirst();
                    if (tmp == null) {
                        sb.append("-1\n");
                    } else {
                        sb.append(tmp).append('\n');
                    }
                    break;
                case "back":
                    tmp = queue.peekLast();
                    if (tmp == null) {
                        sb.append("-1\n");
                    } else {
                        sb.append(tmp).append('\n');
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
