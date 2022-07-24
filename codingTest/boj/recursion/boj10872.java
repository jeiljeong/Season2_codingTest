package codingTest.boj.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * boj10872
 */
public class boj10872 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        // 1. check input validation
        if (n  < 0 || n > 12) {
            throw new Exception("input is not valid");
        }

        // 2. call _calFactorial
        long out = _calFactorial(n);

        System.out.println(out);
    }

    private static long _calFactorial(int in) {
        // 0! = 1이기에, 0!인 경우를 넣어줘야 함
        if (in == 0) {
            return 1;
        }
        return in * _calFactorial(in - 1);
    }
}