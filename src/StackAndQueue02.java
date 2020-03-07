import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue02 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        int length = truck_weights.length;
        int[] truck_distance = new int[length];
        int answer = 1;
        int start = 0;
        int index = 0;

        while (truck_distance[length - 1] != bridge_length) {
            int total_weight = bridge.stream().reduce(0, (a1, a2) -> a1 + a2);

            if (index <= length - 1 && total_weight + truck_weights[index] <= weight) {
                bridge.offer(truck_weights[index++]);
            }

            for (int i = start; i < index; i++) {
                if (++truck_distance[i] >= bridge_length) {
                    bridge.poll();
                    start++;
                }
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.err.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.err.println(solution(100, 100, new int[]{10}));
        System.err.println(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

}
