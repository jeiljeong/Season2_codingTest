package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * boj1269
 */
public class boj1269 {
    public static void main(String[] args) throws IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<String> aSet = new HashSet<>();
        List<String> bList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aSet.add(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bList.add(st.nextToken());
        }

        // 2. 비즈니스 로직
        int commonCount = 0;
        for (String b : bList) {
            if (aSet.contains(b)) {
                commonCount++;
            }
        }

        int result = (aSet.size() - commonCount) + (bList.size() - commonCount);
        
        // 3. 종료
        System.out.println(result);
    }
}