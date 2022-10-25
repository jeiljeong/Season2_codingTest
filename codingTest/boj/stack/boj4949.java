import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack stack = null;

        while (true) {
            char[] arr = br.readLine().toCharArray();

            if (arr.length == 1 && arr[0] == '.') {
                break;
            }

            stack = new Stack<Character>();

            boolean isBalanced = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '(' || arr[i] == '[') {
                    stack.push(arr[i]);
                }
                else if (arr[i] == ')' || arr[i] == ']') {
                    try {
                        char c = (char) stack.pop() == '(' ? ')' : ']';
                        if (c != arr[i]) {
                            isBalanced = false;
                            break;
                        }
                    } catch (Exception e) {
                        isBalanced = false;
                        break;
                    }
                }
            }
            
            if (!stack.isEmpty() || !isBalanced) {
                sb.append("no\n");
            } else {
                sb.append("yes\n");
            }
        }

        System.out.println(sb);
    }
}
