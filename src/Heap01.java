import java.util.*;

public class Heap01 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int min = queue.poll();
            if (queue.isEmpty() && min < K) {
                return -1;
            }
            if (min < K) {
                int min2 = queue.poll();
                int val = min + (min2 * 2);
                queue.offer(val);
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.err.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.err.println(solution(new int[]{0, 0, 0, 5}, 5));
    }

}
