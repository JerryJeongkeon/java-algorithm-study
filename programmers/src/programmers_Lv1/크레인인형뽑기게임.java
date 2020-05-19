package programmers_Lv1;

import java.util.Stack;

public class 크레인인형뽑기게임 {

	static int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
			{ 3, 5, 1, 3, 1 } };
	static int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

	public static void main(String[] args) {
		int answer = 0;
		int N = board.length;
		int size = moves.length;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			int line = moves[i];
			int temp = 0;
			int row = 0;
			int toy = 0;
			while (toy == 0 && row < N) {
				if (board[row][line - 1] != 0) {
					toy = board[row][line - 1];
					board[row][line - 1] = 0;
				}
				row++;
			}
			if (toy == 0)
				continue;

			if (stack.size() > 0 && stack.peek() == toy) {
				stack.pop();
				answer += 2;
			} else {
				stack.push(toy);
			}
		}

		System.out.println(answer);
	}
}
