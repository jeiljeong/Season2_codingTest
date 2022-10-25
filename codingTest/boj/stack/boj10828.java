import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    try {
                        sb.append(stack.pop()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");     
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.isEmpty() == true ? 1 : 0).append("\n");
                    break;
                case "top":
                    try {
                        sb.append(stack.peek()).append("\n");
                    } catch (Exception e) {
                        sb.append(-1).append("\n");
                    }
                    break;
                default :
                    break;
            }
        }
        System.out.println(sb);
    }
}
