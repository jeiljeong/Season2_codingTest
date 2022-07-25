package codingTest.boj.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj1620_v2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, String> dic = new HashMap<>();
        Map<String, Integer> reverseDic = new HashMap<>();

        String str = null;
        int num = 0;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            num = i + 1;
            dic.put(num, str);
            reverseDic.put(str, num);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            if (_isNum(quiz)) {
                // number
                sb.append(dic.get(Integer.parseInt(quiz))).append("\n");
            } else {
                // string
                sb.append(reverseDic.get(quiz)).append("\n");
            }
        }

        // 3. end
        System.out.println(sb);
    }

    private static boolean _isNum(String str) {
        char[] charStr = str.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (!Character.isDigit(charStr[i])) {
                // not number
                return false;
            }
        }
        return true;
    }
}
