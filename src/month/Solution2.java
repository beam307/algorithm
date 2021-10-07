package month;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.err.println(Arrays.toString(solution(3, 2, 5)));
        System.err.println(Arrays.toString(solution(4, 7, 14)));
        System.err.println(Arrays.toString(solution(10000000, 1000000, 20000000)));
    }

    public static int[] solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();
        long index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (left <= index) {
                    if (index <= right) {
                        list.add((long) Math.max(i, j));
                    } else {
                        break;
                    }
                }
                index++;
            }
        }
        return list.stream().mapToInt(Math::toIntExact).toArray();
    }
}
