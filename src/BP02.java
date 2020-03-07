import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BP02 {
    public static int solution(String numbers) {
        String[] strings = numbers.split("");
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= strings.length; i++) {
            permutation(strings, set, 0, i);
        }

        return set.size();
    }


    public static void prime(String[] arr, Set<Integer> set, int r) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < r; i++) {
            s.append(arr[i]);
        }
        int number = Integer.parseInt(String.valueOf(s));
        boolean isPrime = true;
        if (number <= 1) {
            return;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            set.add(number);
        }
    }

    public static void permutation(String[] arr, Set<Integer> set, int depth, int r) {
        if (depth == r) {
            prime(arr, set, r);
            return;
        } else {
            for (int i = depth; i < arr.length; i++) {
                swap(arr, depth, i);
                permutation(arr, set, depth + 1, r);
                swap(arr, depth, i);
            }
        }


    }

    public static void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        System.err.println(solution("17"));
        System.err.println(solution("011"));
    }

}
