package lavel1;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NewId {
    public static void main(String[] args) {

        System.err.println(solution("~!@#$%^&*()=+[{]}:?,<>/"));
        System.err.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.err.println(solution("z-+.^."));
        System.err.println(solution("=.="));
        System.err.println(solution("123_.def"));
        System.err.println(solution("abcdefghijklmn.p"));

    }

    public static String solution(String new_id) {

        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        new_id = "".equals(new_id) ? "a" : new_id;
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^\\.|\\.$", "");
        }

        if (new_id.length() <= 2) {
            char last = new_id.charAt(new_id.length() - 1);
            while(new_id.length() < 3) {
                new_id += last;
            }
        }

        return new_id;
    }
}
