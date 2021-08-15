package lavel1;

public class Lotto {

    public static void main(String[] args) {
        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        solution(new int[]{6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6});
        solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{11, 12, 13, 14, 15, 16});
        solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});
    }

    public static int[] solution(int[] lottos, int[] win_nums) {

        int matched = 0;
        int zeroCount = 0;
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
            }
            for (int win_num : win_nums) {
                if (lottos[i] == win_num) {
                    matched++;
                }
            }
        }

        int max = Math.min((7 - (matched + zeroCount)), 6);
        int min = matched == 0 ? 6 : 7 - matched;

        System.err.println(max + " : " + min);

        return new int[]{max, min};
    }
}
