package lavel1;

import java.util.HashMap;
import java.util.Map;

public class Weekly2 {
    public static void main(String[] args) {

        System.err.println(solution(new int[][]{
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        }));
        System.err.println(solution(new int[][]{
                {50, 90},
                {50, 87}
        }));
        System.err.println(solution(new int[][]{
                {70, 49, 90},
                {68, 50, 38},
                {73, 31, 100}
        }));

        System.err.println(solution(new int[][]{
                {100, 100},
                {0, 0}
        }));
    }

    public static String solution(int[][] scores) {
        String answer = "";



        for (int i = 0; i < scores.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int max = -1;
            int min = 101;
            boolean unique = false;
            for (int j = 0; j < scores[i].length; j++) {
                int score = scores[j][i];
                if (max < score) {
                    max = score;
                }

                if (min > score) {
                    min = score;
                }
                map.put(score, map.getOrDefault(score, 0) + 1);
            }

            for (int j = 0; j < scores[i].length; j++) {
                int score = scores[j][i];
                sum += score;
                if (i == j && (max == score || min == score) && map.get(score) == 1) {
                    sum -= score;
                    unique = true;
                }
            }

            double avg = sum / (unique ? scores.length - 1 : scores.length);

            if (avg >= 90) {
                answer += "A";
            } else if (avg >= 80) {
                answer += "B";
            } else if (avg >= 70) {
                answer += "C";
            } else if (avg >= 50) {
                answer += "D";
            } else {
                answer += "F";
            }

        }

        return answer;
    }
}
