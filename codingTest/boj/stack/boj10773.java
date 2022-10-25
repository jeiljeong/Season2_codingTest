import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj10773 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack stack = new Stack<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int k = 0;
        for (int i = 0; i < n; i++) {
            k = Integer.parseInt(br.readLine());
            if (k == 0) {
                stack.pop();
            } else {
                stack.push(k);
            }
        }
        int size = stack.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (int) stack.pop();
        }

        System.out.println(sum);
    }
}
