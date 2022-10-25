import java.util.Scanner;

public class boj12865_v2 {
    public static void main(String[] args) {
        // 1. Check input validation & initialization
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // 2. Biz logic
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
        
        // 3. End
        System.out.println(max);
    }
}
