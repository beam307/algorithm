import java.util.Stack;

public class StackAndQueue01 {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for (int i = heights.length; i >= 1; i--) {
            Stack<Integer> stack = new Stack<>();
            for (int j : heights) {
                stack.push(j);
            }
            int peek = 0;
            int result = 0;
            for (int j = 0; j < heights.length - i + 1; j++) {
                peek = stack.pop();
            }
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (peek < pop) {
                    result = stack.size() + 1;
                    break;
                }
            }
            answer[i - 1] = result;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(new int[]{6, 9, 5, 7, 4});
        for (int value : result) {
            System.err.print(value);
        }
        System.err.println();
        int[] result2 = solution(new int[]{3, 9, 9, 3, 5, 7, 2});
        for (int value : result2) {
            System.err.print(value);
        }
    }

}
