package lavel1;

import java.util.*;
import java.util.stream.Collectors;

public class Pocketmon {

    public static void main(String[] args) {
        System.err.println(solution(new int[]{3, 1, 2, 3}));
        System.err.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.err.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }

    public static int solution(int[] nums) {
        Set<Integer> sets = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(nums.length / 2, sets.size());
    }

}
