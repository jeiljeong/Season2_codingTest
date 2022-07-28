package codingTest.boj.geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2477 {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int SOUTH = 3;
    private static final int NORTH = 4;

    private static final int rShape = 1;
    private static final int rShapeReverse = 2;
    private static final int LShape = 3;
    private static final int LShapeReverse = 4;
    public static void main(String[] args) throws Exception {
        // 1. 입력값 검증
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int chamwae = Integer.parseInt(br.readLine());
        List<Integer> direction = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            direction.add(Integer.valueOf(st.nextToken()));
            distance.add(Integer.valueOf(st.nextToken()));
        }

        // 2. 비즈니스 로직
        int shape = _shapeOf(direction);
        if (shape == 0) {
            throw new Exception("shape == 0, not a normal return value");
        }

        if (shape == rShape) {
            chamwae *= (
                (distance.get(0) * distance.get(1))
            +   (distance.get(3) * distance.get(4))
            );
        } else if (shape == rShapeReverse) {
            chamwae *= (
                (distance.get(0) * distance.get(1))
            +   (distance.get(3) * distance.get(4))
            );
        } else if (shape == LShape) {
            chamwae *= (
                (distance.get(1) * distance.get(2))
            +   (distance.get(4) * distance.get(5))
            );
        } else if (shape == LShapeReverse) {
            chamwae *= (
                (distance.get(0) * distance.get(1))
            +   (distance.get(3) * distance.get(4))
            );
        }

        // 3. 종료
        System.out.println(chamwae);
    }

    private static int _shapeOf(List<Integer> direction) {
        int shape = 0;
        // 남-동-남
        if (direction.get(2).equals(SOUTH))
            return rShapeReverse;
        // 남-동-북-동
        if (direction.get(3).equals(EAST)) 
            return rShape;
        // 남-동-북-서-북
        if (direction.get(4).equals(NORTH))
            return LShape;
        // 남-동-북-서-남
        if (direction.get(4).equals(SOUTH))
            return LShapeReverse;
        return shape;
    }
}
