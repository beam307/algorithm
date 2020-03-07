import java.util.Arrays;
import java.util.Comparator;

public class Sort03 {
    public static int solution(int[] data) {
        Integer[] citations = Arrays.stream(data).boxed().toArray(Integer[]::new);
        Arrays.sort(citations, Comparator.reverseOrder());

        int result = 0;
        for (int i = citations[0]; i > 0; i--) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= i) {
                    count++;
                } else {
                    break;
                }
            }
            if (count >= i) {
                result = i;
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.err.println(solution(new int[]{3, 0, 6, 1, 5}));
    }

}
