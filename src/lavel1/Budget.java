package lavel1;

import java.util.Arrays;

public class Budget {

    public static void main(String[] args) {

        System.err.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.err.println(solution(new int[]{2, 2, 3, 3}, 10));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int data : d) {

            budget -=data;
            answer++;
            if (budget < 0) {
                budget += data;
                answer--;
            } else if (budget == 0) {
                break;
            }

        }

        return answer;
    }
}
