import java.util.*;

public class StackAndQueue03 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int day = 0;
            while (progress < 100) {
                progress += speed;
                day++;
            }
            queue.offer(day);
        }
        int save = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (save < value) {
                save = value;
                answer.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] a = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        Arrays.stream(a).forEach(System.err::println);
    }

}
