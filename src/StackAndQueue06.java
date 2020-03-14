import java.util.Stack;

public class StackAndQueue06 {
    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int price : prices) {
            stack.push(price);
        }

        while (!stack.isEmpty()) {
            int peek = stack.pop();
            int result = 0;
            for (int i = stack.size() + 1; i < prices.length; i++) {
                result++;
                if (peek > prices[i]) {
                    break;
                }
            }
            answer[stack.size()] = result;
        }

        return answer;
    }

    public static void main(String[] args) {
        print(solution(new int[]{1, 2, 3, 2, 3})); // 4, 3, 1, 1, 0
        print(solution(new int[]{1, 2, 3, 2, 3, 1})); // 5, 4, 1, 2, 1, 0
        print(solution(new int[]{3, 1})); // 1, 0
    }

    public static void print(int[] input) {
        for (int i : input) {
            System.err.print(i + " ");
        }
        System.err.println();
    }

}
