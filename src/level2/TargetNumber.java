package level2;

import java.util.*;

public class TargetNumber {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 1, 1, 1}, 3);
    }

    public static int solution(int[] numbers, int target) {
        int answer = add(numbers, target, 0, 0);
        System.err.println(answer);
        return answer;
    }

    public static int add(int[] numbers, int target, int sum, int index) {

        if (numbers.length == index) {
            return target == sum ? 1 : 0;
        }

        return add(numbers, target, sum + numbers[index], index + 1) + add(numbers, target, sum - numbers[index], index + 1);
    }


}
