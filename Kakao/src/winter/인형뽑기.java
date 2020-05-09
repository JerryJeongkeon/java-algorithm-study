package winter;

import java.util.Stack;

/*
 * Stack을 사용하여 풀이하였음
 * 인형을 뽑을 라인에서 0번째부터 행을 검사하여 인형을 뽑음
 * 뽑은 인형과 맨 위의 요소가 같으면 stack 맨 위 요소를 제거하고 answer += 2
 * stack.peek()과 인형이 다르면 인형을 stack에 담아줌
 * 
 */
public class 인형뽑기 {

	static int[][] board = { 
			{ 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 0, 3 }, 
			{ 0, 2, 5, 0, 1 }, 
			{ 4, 2, 4, 4, 2 },
			{ 3, 5, 1, 3, 1 }
			};
	static int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

	public static void main(String[] args) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < moves.length; i++) {
			int line = moves[i] - 1;

			for (int j = 0; j < board.length; j++) {
				if (board[j][line] == 0)
					continue;
				else {
					if (stack.size() > 0 && stack.peek() == board[j][line]) {
						stack.pop();
						answer += 2;
						board[j][line] = 0;
						break;
					} else {
						stack.push(board[j][line]);
						board[j][line] = 0;
						break;
					}
				}
			}
		}
		System.out.println(answer);
	}
}