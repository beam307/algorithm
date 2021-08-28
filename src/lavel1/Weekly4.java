package lavel1;

import java.util.*;
import java.util.stream.Collectors;

public class Weekly4 {

    public static void main(String[] args) {
        System.err.println(
                //                        5      4       3     2      1
                solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                        new String[]{"PYTHON", "C++", "SQL"},
                        new int[]{7, 5, 5}));
        System.err.println(
                solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                        new String[]{"JAVA", "JAVASCRIPT"},
                        new int[]{7, 5})
        );
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Integer> results = new TreeMap<>();

        for (String t : table) {
            String[] tables = t.split(" ");
            String career = tables[0];
            int score = 0;

            for (int i = 0; i < languages.length; i++) {
                String lang = languages[i];
                int preferScore = preference[i];

                for (int j = 1; j < tables.length; j++) {
                    if (lang.equals(tables[j])) {
                        score += preferScore * (6 - j);
                        break;
                    }
                }
            }
            results.put(career, score);
        }

        List<Map.Entry<String, Integer>> resultList = results.entrySet().stream().sorted(Collections.reverseOrder((Map.Entry.comparingByValue()))).collect(Collectors.toList());

        return resultList.get(0).getKey();
    }
}
