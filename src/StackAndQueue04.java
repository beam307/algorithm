import java.util.*;

public class StackAndQueue04 {
    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList();
        List<Integer> checked = new ArrayList();
        Queue<Integer> result = new LinkedList();
        int answer = 0;
        for (int priority : priorities) {
            queue.add(priority);
            checked.add(priority);
        }

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            checked.remove(value);
            result.add(value);
            if (location == 0) {
                answer = result.size();
            }
            for (int i = 0; i < checked.size(); i++) {
                if (value < checked.get(i)) {
                    queue.add(value);
                    checked.add(value);
                    result.remove(value);
                    if (location == 0) {
                        answer = queue.size() -1;
                        location = answer;
                        location++;
                    }
                    break;
                }
            }
            location--;
        }


        return answer;
    }

    public static void main(String[] args) {
        System.err.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.err.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
        System.err.println(solution(new int[]{2, 2, 2, 1, 3, 4}, 3)); // 6
    }

}
