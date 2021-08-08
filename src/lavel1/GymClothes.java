package lavel1;

import java.util.*;

public class GymClothes {
    public static void main(String[] args) {
        System.err.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.err.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.err.println(solution(3, new int[]{3}, new int[]{1}));
        System.err.println(solution(5, new int[]{2, 3, 4}, new int[]{1, 2, 3}));
        System.err.println(solution(5, new int[]{1, 2, 3}, new int[]{2, 3, 4}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        Set<Integer> sets = new HashSet<>();
        for (int res : reserve) {
            sets.add(res);
        }

        for (int i = 0; i < lost.length; i++) {
            if (sets.contains(lost[i])) {
                answer++;
                sets.remove(lost[i]);
                lost[i] = -1;
            }
        }

        for (int j : lost) {
            if (sets.contains(j - 1)) {
                sets.remove(j - 1);
                answer++;
            } else if (sets.contains(j + 1)) {
                sets.remove(j + 1);
                answer++;

            }
        }


        return answer;
    }
}
