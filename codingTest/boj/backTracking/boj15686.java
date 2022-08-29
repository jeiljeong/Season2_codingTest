package codingTest.boj.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj15686 {
    private static int resultMin = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static int[][] map;
    private static HashMap<Integer, ChickenShop> chickenMap = new HashMap<>();
    private static HashMap<Integer, House> houseMap = new HashMap<>();
    private static ArrayList<Integer> selectedList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        // 1. Check input validation & initialization
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        int val = 0;
        int chickenIndex = 0;
        int houseIndex = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                val = Integer.parseInt(st.nextToken());
                if (val == 2) {
                    chickenMap.put(chickenIndex++, new ChickenShop(i, j));
                } else if (val == 1) {
                    houseMap.put(houseIndex++, new House(i, j));
                }
                map[i][j] = val;
            }
        }

        // 2. Biz logic
        selection(0, 0);
        
        // 3. End
        System.out.println(resultMin);
    }

    private static void selection(int idx, int depth) {
        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < houseMap.size(); i++) {
                sum += minimumDistance(houseMap.get(i));
            }
            resultMin = Math.min(resultMin, sum);

            return ;
        }

        for (int i = idx; i < chickenMap.size(); i++) {
            selectedList.add(i);
            selection(i + 1, depth + 1);
            selectedList.remove(selectedList.indexOf(i));
        }
    }

    private static int minimumDistance(House house) {
        int min = Integer.MAX_VALUE;
        for (Integer key : selectedList) {
            min = Math.min(min, getDistance(chickenMap.get(key), house));
        }
        return min;
    }

    private static int getDistance(ChickenShop chickenShop, House house) {
        return Math.abs(chickenShop.getX() - house.getX()) + Math.abs(chickenShop.getY() - house.getY());
    }
}

class ChickenShop {
    private int x;
    private int y;

    public ChickenShop(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class House {
    private int x;
    private int y;

    public House(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
