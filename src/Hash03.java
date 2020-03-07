import java.util.HashMap;
import java.util.Map;

public class Hash03 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap();
        for(int i=0 ; i<clothes.length;i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        int size = 1;
        for (String s : map.keySet()) {
            size *= (map.get(s)+1);
        }

        return size -1;
    }

    public static void main(String[] args) {
        String[][] a = new String[][]{
                new String[]{"yellow_hat", "headgear"},
                new String[]{"blue_sunglasses", "eyewear"},
                new String[]{"green_turban", "headgear"}
        };
        String[][] b = new String[][]{
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses", "face"},
                new String[]{"smoky_makeup", "face"}
        };
        String[][] c = new String[][]{ // 24개
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses", "face"},
                new String[]{"yellow_hat2", "headgear"},
                new String[]{"yellow_hat3", "headgear"},
                new String[]{"green_turban2", "eyewear"},
                new String[]{"green_turban3", "eyewear"},
        };
        String[][] d = new String[][]{ // 13개
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses", "face"},
                new String[]{"yellow_hat2", "headgear"},
                new String[]{"green_turban2", "eyewear"},
                new String[]{"green_turban3", "eyewear"},
        };
        String[][] e = new String[][]{
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses", "face"},
                new String[]{"smoky_makeup", "headgear"},
                new String[]{"yellow_hat", "headgear"},
        };
        String[][] f = new String[][]{
                new String[]{"crow_mask", "face"},
                new String[]{"blue_sunglasses2", "eyewear"},
                new String[]{"blue_sunglasses4", "eyewear"},
                new String[]{"yellow_hat", "headgear"},
                new String[]{"yellow_hat2", "headgear"},
        };
        System.err.println(solution(a));
        System.err.println(solution(b));
        System.err.println(solution(c));
    }

}
