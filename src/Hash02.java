import java.util.Arrays;

class Hash02 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.err.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.err.println(solution(new String[]{"123", "456", "789"}));
        System.err.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}