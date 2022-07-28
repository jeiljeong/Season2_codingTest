package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class boj11478 {
    public static void main(String[] args) throws IOException {
        // 1. 입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        // 2. 비즈니스 로직
        Set<String> resultSet = new HashSet<>();

        // 1) 길이 확장용 loop - ex. 1글자, 2글자, 3글자씩
        for (int letter = 1; letter <= arr.length; letter++) {
            // 2) 상위 Loop 글자 수에 따라 반복할 최대 횟수
            // 예를 들어, 5자의 input에 대해 4글자씩 진행할 때, j = 1일 때, input[1] ~ input[4]까지 Set에 삽입
            int stopIdx = arr.length - letter;
            for (int startIdx = 0; startIdx <= stopIdx; startIdx++) {
                StringBuilder sb = new StringBuilder();
                for (int searchIndex = startIdx; searchIndex < startIdx + letter; searchIndex++) {
                    sb.append(arr[searchIndex]);
                }
                resultSet.add(sb.toString());
            }
        }

        // 3. 종료
        System.out.println(resultSet.size());
    }
}
