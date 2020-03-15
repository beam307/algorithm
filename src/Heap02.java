import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap02 {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index = 0;
        Queue<Integer> pq = new PriorityQueue<>((a1, a2) -> a2 - a1);

        for (int day = 0; day < k; day++) {
            if (index < dates.length && day == dates[index]) {
                pq.offer(supplies[index]);
                index++;
            }
            if (stock == 0) {
                stock += pq.poll();
                answer++;
            }
            stock--;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.err.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30)); // 2
        System.err.println(solution(4, new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 1}, 6)); // 2
        System.err.println(solution(2, new int[]{1, 10, 16, 26}, new int[]{10, 7, 8, 10}, 30)); // 4
        System.err.println(solution(2, new int[]{2, 3}, new int[]{1, 1}, 4)); // 2
    }

}
