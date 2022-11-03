// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;

// public class boj2667 {
//     private static ArrayList<Integer> vertex[];
//     private static int[] visit;
//     private static int n;
//     private static int len;
//     private static int[][] map;
//     private static int[] dx = {0, 0, -1, 1};   // 상하좌우
//     private static int[] dy = {-1, 1, 0, 0};   // 상하좌우
//     public static void main(String[] args) throws NumberFormatException, IOException {
//         // 1. Check input validation & initialization
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         len = Integer.parseInt(br.readLine());
//         n = len * 2;

//         // 정점 초기화
//         vertex = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             vertex[i] = new ArrayList<>();
//         }
        
//         // 방문 체크 초기화
//         visit = new int[n];
        
//         // map 생성
//         map = new int[n][n];
//         for (int i = 0; i < len; i++) {
//             char[] str = br.readLine().toCharArray();
//             for (int j = 0; j < len; j++) {
//                 map[i][j] = str[j];
//             }
//         }
        
//         // 간선 정보 입력
//         for (int i = 0; i < len; i++) {
//             for (int j = 0; j < len; j++) {

//                 if (map[i][j] == 1) {
//                     for (int k = 0; k < 4; k++) {
//                         int x = j + dx[k];
//                         int y = i + dy[k];
//                         if (isValidRange(x, y)) {
//                             if (map[x][y] == 1) {
//                                 // vertex[]
//                             }
//                         }
//                     }
//                 }

//             }
//         }

//         // 2. Biz logic
        
        
        
//         // 3. End
        
//     }
//     private static boolean isValidRange(int x, int y) {
//         if (x < 0 || y < 0 || x >= len || y >= len) {
//             return false;
//         }
//         return true;
//     }
// }
