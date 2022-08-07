package codingTest.boj.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1037 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine());
    
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tmpVal = Integer.parseInt(st.nextToken());
        int min = tmpVal;
        int max = tmpVal;
        while (st.hasMoreTokens()) {
            // 2. 비즈니스 로직
            tmpVal = Integer.parseInt(st.nextToken());
            if (min > tmpVal)
                min = tmpVal;
            if (max < tmpVal)
                max = tmpVal;
        }
        // 3. 종료
        System.out.println(min * max);
    }
}
