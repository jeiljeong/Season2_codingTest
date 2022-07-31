package codingTest.boj.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getX() {
        return point.x;
    }
    public int getY() {
        return point.y;
    }
    public int getRadius() {
        return radius;
    }
}

class Rectangle {
    Point leftTop;
    Point rightTop;
    Point leftBottom;
    Point rightBottom;

    public Rectangle(Point leftTop, Point rightTop, Point leftBottom, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightTop = rightTop;
        this.leftBottom = leftBottom;
        this.rightBottom = rightBottom;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj1358 {
    public static void main(String[] args) throws IOException {
        // 1. 입력값 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int radius = h / 2;
        
        Circle leftCircle = new Circle(new Point(x, y + radius), radius);
        Circle rightCircle = new Circle(new Point(x + w, y + radius), radius);
        Rectangle rec = new Rectangle(new Point(x, y + h)
                                    , new Point(x + w, y + h)
                                    , new Point(x, y)
                                    , new Point(x + w, y));

        // 2. 비즈니스 로직
        int answer =  0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int playerX = Integer.parseInt(st.nextToken());
            int playerY = Integer.parseInt(st.nextToken());

            boolean isIncludedLeftCircle = false;
            boolean isIncludedRightCircle = false;
            boolean isIncludedRectangle = false;

            // check - left circle
            if (Math.pow(leftCircle.getX() - playerX, 2)
                + Math.pow(leftCircle.getY() - playerY, 2)
                <= Math.pow(leftCircle.getRadius(), 2)) {
                isIncludedLeftCircle = true;
            }
            // check - right circle
            if (Math.pow(rightCircle.getX() - playerX, 2)
                + Math.pow(rightCircle.getY() - playerY, 2)
                <= Math.pow(rightCircle.getRadius(), 2)) {
                isIncludedRightCircle = true;
            }
            // check - rectangle
            if ((playerX >= rec.leftBottom.x && playerX <= rec.rightBottom.x)
            && (playerY >= rec.leftBottom.y && playerY <= rec.leftTop.y)) {
                isIncludedRectangle = true;
            }

            if (isIncludedLeftCircle || isIncludedRightCircle || isIncludedRectangle) {
                answer++;
            }
        }
        // 3. 종료
        System.out.println(answer);
    }

}
