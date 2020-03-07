import java.util.Arrays;
import java.util.Comparator;

public class Sort02 {
    public static String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1;
                String temp2 = o2;
                return (temp2 + temp1).compareTo(temp1 + temp2);
            }
        });
        String result = String.join("", strings);

        if("0".equals(result.substring(0, 1))) {

            return "0";
        }
        return result;
    }


    public static void main(String[] args) {
        System.err.println(solution(new int[]{0, 0, 0}));
    }

}
