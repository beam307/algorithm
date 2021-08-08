package lavel1;

public class Keypad {
    public static void main(String[] args) {

        System.err.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.err.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.err.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int left = 10;
        int right = 12;

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer.append("L");
                left = number;
            } else if (number == 3 || number == 6 || number == 9) {
                answer.append("R");
                right = number;
            } else {
                int dLeft = distance(left, number);
                int dRight = distance(right, number);
                if (dLeft > dRight) {
                    answer.append("R");
                    right = number;
                } else if (dLeft < dRight) {
                    answer.append("L");
                    left = number;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        left = number;
                    } else {
                        answer.append("R");
                        right = number;
                    }
                }
            }
        }

        return answer.toString();
    }

    public static int distance(int start, int end) {
        int[][] xy = new int[4][3];
        int a = 1;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                xy[i][j] = a++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {

                if (start == 0 && xy[i][j] == 11) {
                    startX = j;
                    startY = i;
                }
                if (end == 0 && xy[i][j] == 11) {
                    endX = j;
                    endY = i;
                }

                if (xy[i][j] == start) {
                    startX = j;
                    startY = i;
                }
                if (xy[i][j] == end) {
                    endX = j;
                    endY = i;
                }

            }
        }

        return Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
