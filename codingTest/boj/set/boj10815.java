package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj10815 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1차 입력
        int n = Integer.parseInt(br.readLine());
        if (n < 1 || n > 500000) {
            throw new Exception("n is not valid");
        }

        String nums = br.readLine();
        StringTokenizer st = new StringTokenizer(nums);
        Set<Integer> cards = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        // 2차 입력
        int m = Integer.parseInt(br.readLine());
        if (m < 1 || m > 500000) {
            throw new Exception("m is not valid");
        }

        String compNums = br.readLine();
        StringTokenizer st2 = new StringTokenizer(compNums);
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // Biz 로직
        for (int i = 0; i < m; i++) {
            if (cards.contains(arr[i])) {
                sb.append("1").append(" ");
            } else {
                sb.append("0").append(" ");
            }
        }

        // 종료
        System.out.println(sb);
    }
}
