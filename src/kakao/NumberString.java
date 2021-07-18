package kakao;

import java.util.HashMap;
import java.util.Map;

public class NumberString {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }

    public static int solution(String s) {

        String[] numberStrings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String answer = s;
        for (int i = 0; i < numberStrings.length; i++) {
            answer = answer.replaceAll(numberStrings[i], Integer.toString(i));
        }

        return Integer.parseInt(answer);
    }

}
