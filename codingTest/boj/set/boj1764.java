package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class boj1764 {
    public static void main(String[] args) throws IOException {
        List<String> result = new ArrayList<>();

        // 1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line_1 = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(line_1.nextToken());
        int m = Integer.parseInt(line_1.nextToken());

        Set<String> nonSee = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nonSee.add(br.readLine());
        }
        List<String> nonHear = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            nonHear.add(br.readLine());
        }
        
        // 2. biz logic
        for (String key : nonHear) {
            if (nonSee.contains(key)) {
                result.add(key);
            }
        }

        // 3. end
        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
