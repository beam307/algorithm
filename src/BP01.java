import java.util.ArrayList;
import java.util.List;

public class BP01 {
    public static int[] solution(int[] answers) {

        int mathGiveUp1 = 0;
        int mathGiveUp2 = 0;
        int mathGiveUp3 = 0;

        int[] giveUp2Check = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3Check = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            if ((i % 5 + 1) == answers[i]) {
                mathGiveUp1++;
            }
            if (giveUp2Check[i % 8] == answers[i]) {
                mathGiveUp2++;
            }
            if (giveUp3Check[i % 10] == answers[i]) {
                mathGiveUp3++;
            }
        }
        int max = Math.max(mathGiveUp1, Math.max(mathGiveUp2, mathGiveUp3));
        List<Integer> list = new ArrayList<>();
        if (max == mathGiveUp1) {
            list.add(1);
        }
        if (max == mathGiveUp2) {
            list.add(2);
        }
        if (max == mathGiveUp3) {
            list.add(3);
        }

        return list.stream().mapToInt(i -> i).toArray();

    }

    public static void main(String[] args) {
        System.err.println(solution(new int[]{1, 2, 3, 4, 5}));
        System.err.println(solution(new int[]{1, 3, 2, 4, 2}));
    }

}
