import java.util.ArrayList;
import java.util.List;

public class BP04 {
    public static int[] solution(int brown, int red) {
        int x = 0;
        int y = 0;
        List<Integer> divisors = new ArrayList<>();
        divisors.add(red);
        for (int i = red / 2; i >= 1; i--) {
            if (red % i == 0) {
                divisors.add(i);
            }
        }

        for (int exX : divisors) {
            int exY = red / exX;
            if (brown == (((exX + 2) * (exY + 2)) - (exX * exY))) {
                x = exX + 2;
                y = exY + 2;
                break;
            }
        }


        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] a = solution(10, 2);
        System.err.println(a[0] + ", " + a[1]);
    }

}
