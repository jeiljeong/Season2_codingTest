package codingTest.boj.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2477_v2 {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int SOUTH = 3;
    private static final int NORTH = 4;

    private static final int R_SHAPE = 1;
    private static final int REVERSE_R_SHAPE = 2;
    private static final int L_SHAPE = 3;
    private static final int REVERSE_L_SHAPE = 4;
    public static void main(String[] args) throws NumberFormatException, IOException {
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

        try {
            chamwae = _numOfchamwae(shape, chamwae, direction, distance);
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            // 3. 종료
            System.out.println(chamwae);
        }

    }

    private static int _shapeOf(List<Integer> direction) {
        int[] directionCount = new int[5];

        // 1. 배열 초기화
        for (int i = 0; i < 5; i++) {
            directionCount[i] = 0;
        }
        for (Integer dir : direction) {
            directionCount[dir] += 1;
        }
        
        // 2. decision of shape
        // 남-동-남-동-북-서 - reverse R Shape
            // 동2 서1 남2 북1
        // 남-동-북-동-북-서 - R Shape
            // 동2 서1 남1 북2
        // 남-동-북-서-북-서 - L Shape
            // 동1 서2 남1 북2
        // 남-동-북-서-남-서 - reverse L Shape
            // 동1 서2 남2 북1
        if (directionCount[EAST] == 2) {
            if (directionCount[SOUTH] == 2) {
                return REVERSE_R_SHAPE;
            }
            return R_SHAPE;
        } else {
            if (directionCount[SOUTH] == 2) {
                return REVERSE_L_SHAPE;
            }
            return L_SHAPE;
        }
    }

    private static int _numOfchamwae(int shape, int chamwae, List<Integer> direction, List<Integer> distance) throws Exception {
        // 1. 입력값 검증
        if (chamwae == 0 || direction.isEmpty() || distance.isEmpty()) {
            throw new Exception("_numOfchamwae input is not valid");
        }

        int result = 0;
        int widthBar = 0;
        int verticalBar = 0;
        int overlapArea = 0;
        int overlapEdge1 = 0;
        int overlapEdge2 = 0;

        // 2. 연산식 : 모든 Shape은 Unique한 두 개의 모서리가 있음 = (가로막대넓이 + 세로막대넓이 - 중복 넓이)
        if (shape == R_SHAPE) {
            for (int i = 0; i < 6; i++) {
                // 세로막대 : (남) * 동
                if (direction.get(i) == SOUTH) {
                    if (i == 5){
                        verticalBar = distance.get(i) * distance.get(0);
                        overlapEdge1 = distance.get(0);
                    } else {
                        verticalBar = distance.get(i) * distance.get(i + 1);
                        overlapEdge1 = distance.get(i + 1);
                    }
                }
                // 가로막대 : 북 * (서)
                else if (direction.get(i) == WEST) {
                    if (i == 0) {
                        widthBar = distance.get(5) * distance.get(i);
                        overlapEdge2 = distance.get(5);
                    } else {
                        widthBar = distance.get(i - 1) * distance.get(i);
                        overlapEdge2 = distance.get(i - 1);
                    }
                }
            }
        } else if (shape == REVERSE_R_SHAPE) {
            for (int i = 0; i < 6; i++) {
                // 세로막대 : 동 * (북)
                if (direction.get(i) == NORTH) {
                    if (i == 0) {
                        verticalBar = distance.get(5) * distance.get(i);
                        overlapEdge1 = distance.get(5);
                    } else {
                        verticalBar = distance.get(i - 1) * distance.get(i);
                        overlapEdge1 = distance.get(i - 1);
                    }
                }
                // 가로막대 : (서) * 남
                else if (direction.get(i) == WEST){
                    if (i == 5) {
                        widthBar = distance.get(i) * distance.get(0);
                        overlapEdge2 = distance.get(0);
                    } else {
                        widthBar = distance.get(i) * distance.get(i + 1);
                        overlapEdge2 = distance.get(i + 1);
                    }
                }
            }
        } else if (shape == L_SHAPE) {
            // 세로막대 : 서 * (남)
            for (int i = 0; i < 6; i++) {
                if (direction.get(i) == SOUTH) {
                    if (i == 0) {
                        verticalBar = distance.get(5) * distance.get(i);
                        overlapEdge1 = distance.get(5);
                    } else {
                        verticalBar = distance.get(i - 1) * distance.get(i);
                        overlapEdge1 = distance.get(i - 1);
                    }
                }
                // 가로막대 : (동) * 북
                else if (direction.get(i) == EAST) {
                    if (i == 5) {
                        widthBar = distance.get(i) * distance.get(0);
                        overlapEdge2 = distance.get(0);
                    } else {
                        widthBar = distance.get(i) * distance.get(i + 1);
                        overlapEdge2 = distance.get(i + 1);
                    }
                }
            }
        } else if (shape == REVERSE_L_SHAPE) {
            for (int i = 0; i < 6; i++) {
                // 세로막대 : (북) * 서
                if (direction.get(i) == NORTH) {
                    if (i == 5) {
                        verticalBar = distance.get(i) * distance.get(0);
                        overlapEdge1 = distance.get(0);
                    } else {
                        verticalBar = distance.get(i) * distance.get(i + 1);
                        overlapEdge1 = distance.get(i + 1);
                    }
                }
                // 가로막대 : 남 * (동)
                else if (direction.get(i) == EAST) {
                    if (i == 0) {
                        widthBar = distance.get(5) * distance.get(i);
                        overlapEdge2 = distance.get(5);
                    } else {
                        widthBar = distance.get(i - 1) * distance.get(i);
                        overlapEdge2 = distance.get(i - 1);
                    }
                }
            }
        }
        overlapArea = overlapEdge1 * overlapEdge2;
        result = chamwae * (widthBar + verticalBar - overlapArea);
        
        return result;
    }
}
