import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack stack = null;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            stack = new Stack<Character>();
            
            char[] arr = br.readLine().toCharArray();

            boolean exceptionFlag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == '(') {
                    stack.push(arr[j]);
                } else {
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        exceptionFlag = true;
                    }
                }
            }
            if (!stack.isEmpty() || exceptionFlag) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.println(sb);
    }
}
