package codingTest.boj.geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1004 {
    private static final int X1 = 1;
    private static final int Y1 = 1;
    private static final int X2 = 1;
    private static final int Y2 = 1;
    public static void main(String[] args) throws Exception {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = isValidTestCase(Integer.parseInt(br.readLine()));
       
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> point = new ArrayList<>();
            while (st.hasMoreTokens()) {
                point.add(_isValidXY(Integer.valueOf(st.nextToken())));
            }
            
            int n = Integer.parseInt(br.readLine());
            int[][] planetList = new int[n][3];
            StringTokenizer planetSt = null;
            for (int j = 0; j < n; j++) {
                planetSt = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    planetList[j][k] = _isValidPlanet(Integer.parseInt(planetSt.nextToken()), k);
                }
            }

            // _printTest(testCase, point, n, planetList);
            
            // 2. 비즈니스 로직
            
            // 3. 출력
        }

        // 4. 종료
    }

    private static int _isValidPlanet(int planet, int position) throws Exception {
        if (position == 2) {
            if (!(planet >= 1 && planet <= 1000)) {
                throw new Exception("planet r is not valid");
            }
        } else {
            if (!(planet >= -1000 && planet <= 1000)) {
                throw new Exception("planet c is not valid");
            }
        }
        return planet;
    }

    private static Integer _isValidXY(Integer xy) throws Exception {
        if (!(xy >= -1000 && xy <= 1000)) {
            throw new Exception("XY is not valid");
        }
        return xy;
    }

    private static void _printTest(int testCase, List<Integer> point, int n, int[][] planetList) {
        System.out.println(testCase);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < point.size(); i++) {
            sb.append(point.get(i)).append(" ");
        }
        System.out.println(sb);
        
        System.out.println(n);

        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(planetList[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int isValidTestCase(int n) throws Exception {
        if (!(n >= 1 && n <= 50)) {
            throw new Exception("TestCase is not valid");
        }       
        return n;
    }
}
