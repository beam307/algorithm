import java.util.HashMap;
import java.util.Map;

class Hash01 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], (map.get(completion[i]) - 1));
        }

        for (int i = 0; i < participant.length; i++) {
            if (!map.get(participant[i]).equals(0)) {
                result = participant[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.err.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}