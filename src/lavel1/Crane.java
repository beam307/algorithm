package lavel1;

import java.util.Stack;

public class Crane {

    public static void main(String[] args) {

        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        System.err.println(solution(board, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int b = board[i][move - 1];
                if (b != 0) {
                    if (basket.size() > 0 && basket.peek() == b) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(b);
                    }

                    board[i][move - 1] = 0;
                    break;
                }
            }
        }


        return answer;
    }
}