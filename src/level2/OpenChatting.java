package level2;

import java.util.*;

public class OpenChatting {
    public static void main(String[] args) {

        String[] a = solution(new String[]{
                "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
        });


        System.err.println(Arrays.toString(a));
    }

    public static String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> checked = new HashMap<>();
        for (String rec : record) {
            String[] data = rec.split(" ");
            String type = data[0];
            String uid = data[1];

            if ("Enter".equals(type)) {
                checked.put(uid, data[2]);
                answer.add(uid + "님이 들어왔습니다.");
            } else if ("Leave".equals(type)) {
                answer.add(uid + "님이 나갔습니다.");
            } else {
                checked.put(uid, data[2]);
            }
        }

        System.out.println(answer);

        return answer.stream().map(m -> {
            String hangul = m.replaceAll("[a-zA-Z0-9]", "");
            String uid = m.replaceAll("[가-힣 .]", "");
            return checked.get(uid) + hangul;
        }).toArray(String[]::new);
    }

}
