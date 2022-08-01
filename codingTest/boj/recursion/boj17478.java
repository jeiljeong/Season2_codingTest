package codingTest.boj.recursion;

import java.util.Scanner;

// 출력형식이 잘못 되었습니다.

public class boj17478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int i = 1;
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        System.out.println("\"재귀함수가 뭔가요?\"");
        System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        _recursion(n, i);
        System.out.println("라고 답변하였지.");
    }

    private static void _recursion(int n, int i) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            for (int j = 0; j < i; j++) {
                sb.append("____");
            }
            sb.append("\"재귀함수가 뭔가요?\"").append("\n");
            for (int j = 0; j < i; j++) {
                sb.append("____");
            }
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            for (int j = 0; j < i; j++) {
                sb.append("____");
            }
            sb.append("라고 답변하였지.").append("\n");
            System.out.println(sb);
            return ;
        }
        for (int j = 0; j < i; j++) {
            sb.append("____");
        }
        sb.append("\"재귀함수가 뭔가요?\"").append("\n");
        for (int j = 0; j < i; j++) {
            sb.append("____");
        }
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
        for (int j = 0; j < i; j++) {
            sb.append("____");
        }
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
        for (int j = 0; j < i; j++) {
            sb.append("____");
        }
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
        
        System.out.println(sb);
        _recursion(n - 1, i + 1);
        sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append("____");
        }
        sb.append("라고 답변하였지.").append("\n");
        System.out.println(sb);
        return ;
    }
}
