package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Weekly5 {

    public static void main(String[] args) {
        System.err.println(solution("AAAAE"));
        System.err.println(solution("AAAE"));
        System.err.println(solution("I"));
        System.err.println(solution("EIO"));
    }

    static int solution(String word) {

        String[] vowels = {"A", "E", "I", "O", "U"};

        List<String> list = new ArrayList<>();
        LinkedList<String> result = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            perm(vowels, 5, i, result, list);

        }
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    static void perm(String[] arr, int n, int r, LinkedList<String> result, List<String> list) {

        if (result.size() == r) {
            list.add(String.join("", result));
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr[i]);
            perm(arr, n, r, result, list);
            result.removeLast();
        }

    }

}
