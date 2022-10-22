import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * v1에서는 combination(이향계수의 파스칼의 삼각형)을 이용해 2차원 배열에 저장 - 메모리 초과 오류
 * v2에서는 fibonachi 수열을 이용해 2차원 배열에 저장
 * cf. https://st-lab.tistory.com/125
 */
public class boj1904_v3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        // 2. Biz logic
        /**
         * 1) 피보나치 수열의 경우 기하급수적으로 결과값이 커질 수 있으며, int의 범위를 넘어갈 수 있음
         * 2) input의 제한값은 1백만으로, int overflow를 방지하기 위해 modulo 분배법칙을 활용
         *    - (A + B) % C = ((A % C) + (B % C)) % C
         * 3) 반복문 활용 - 별도의 memorization 필요 없음
         */
        
        // 3. End
        System.out.println(tile(n));
    }

    private static int tile(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int val1 = 1;
        int val2 = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = (val2 + val1) % 15746;
            val1 = val2;
            val2 = sum;
        }

        return sum;
    }
}
