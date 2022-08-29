package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * ascending 방식으로 수평적 구조에서 중복 뽑기가 없으니, visit 체크를 하지 않아도 되나
 * 아래 코드에는 구현되어 있다
 */
public class boj1759 {
    private static int l;
    private static int c;
    private static ArrayList<String> str;
    private static boolean[] visit;
    private static final StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        str = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            str.add(st.nextToken());
        }
        Collections.sort(str);
        visit = new boolean[c];

        // 2. Biz logic
        combination(0, 0);
        
        // 3. End
        System.out.println(sb);
    }

    private static void combination(int idx, int depth) {
        if (depth == l) {
            int vowelCnt = 0;
            int consonantCnt = 0;
            for (int i = 0; i < c; i++) {
                if (visit[i]) {
                    if (isVowel(str.get(i).toCharArray()[0])) {
                        vowelCnt += 1;
                    } else {
                        consonantCnt += 1;
                    }
                }
            }

            if (vowelCnt >= 1 && consonantCnt >= 2) {
                for (int i = 0; i < c; i++) {
                    if (visit[i]) {
                        sb.append(str.get(i).toCharArray()[0]);
                    }
                }
                sb.append('\n');
            }

            return ;
        }

        for (int i = idx; i < c; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
