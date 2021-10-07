package month;

public class Solution1 {
    public static void main(String[] args) {
        System.err.println(solution(10));
        System.err.println(solution(12));
    }
    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        return n - 1;
    }
}
