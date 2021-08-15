package lavel1;

import java.util.*;
import java.util.stream.Collectors;

public class Fail {
    public static void main(String[] args) {

        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(4, new int[]{4, 4, 4, 4, 4});
        solution(5, new int[]{4, 4, 4, 4, 4});

    }

    public static int[] solution(int N, int[] stages) {

        Map<Integer, Double> answer = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int count = 0;
            double success = 0;
            for (int stage : stages) {
                if (stage >= i) {
                    count++;
                    if (stage > i) {
                        success++;
                    }
                }
            }
            System.out.println(i + " : " + (count - success) + " / " + count + " = " + ((count - success) / count));
            answer.put(i, count == 0 ? 0 : (count - success) / count);

        }

//        answer.entrySet().forEach(System.err::println);

        List<Integer> result = answer.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).collect(Collectors.toList());
        System.err.println(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
