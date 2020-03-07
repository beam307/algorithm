import java.util.*;

public class BP03 {
    public static int solution(int[][] baseball) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer[]> list = new ArrayList<>();
        permutation(new int[]{1,2,3,4,5,6,7,8,9}, 0, 3, list);
        int answer = 0;
        for (int i = 0; i < baseball.length; i++) {
            int number = baseball[i][0];
            int strike = baseball[i][1];
            int ball = baseball[i][2];
            cases(number, strike, ball, list, map);
            for (Map.Entry<Integer, Integer> value : map.entrySet()) {
                if (value.getValue() == baseball.length) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void cases(int number, int strCheck, int ballCheck, List<Integer[]> list, Map<Integer, Integer> map) {
        int hundreds = number / 100;
        int tens = number % 100 / 10;
        int units = number % 10;

        for (Integer[] values : list) {
            int strike = 0;
            int ball = 0;
            if (hundreds == values[0]) {
                strike++;
            } else if (hundreds == values[1] || hundreds == values[2]) {
                ball++;
            }
            if (tens == values[1]) {
                strike++;
            } else if (tens == values[0] || tens == values[2]) {
                ball++;
            }
            if (units == values[2]) {
                strike++;
            } else if (units == values[1] || units == values[0]) {
                ball++;
            }

            if (strike == strCheck && ball == ballCheck) {
                int value = values[0] * 100 + values[1] * 10 + values[2];
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }
    }

    public static void permutation(int[] arr, int depth, int r, List list) {
        if (depth == r) {
            Integer[] intArr = new Integer[3];
            intArr[0] = arr[0];
            intArr[1] = arr[1];
            intArr[2] = arr[2];
            list.add(intArr);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, depth, i);
                permutation(arr, depth + 1, r, list);
                swap(arr, depth, i);
            }
        }
    }

    public static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1}
        }));
    }

}
