import java.util.*;

public class StackAndQueue05 {
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (stack.isEmpty() || stack.peek() == arrangement.charAt(i)) {
                stack.push(arrangement.charAt(i));
            } else {
                stack.pop();
                if (arrangement.charAt(i) != arrangement.charAt(i - 1)) {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        System.err.println(solution("((())(())())(())")); // 10
        System.err.println(solution("()(((()())(())()))(())")); // 17
    }

}
