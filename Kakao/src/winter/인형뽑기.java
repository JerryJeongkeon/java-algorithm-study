package winter;

import java.util.Stack;

/*
 * Stack�쓣 �궗�슜�븯�뿬 ���씠�븯���쓬
 * �씤�삎�쓣 戮묒쓣 �씪�씤�뿉�꽌 0踰덉㎏遺��꽣 �뻾�쓣 寃��궗�븯�뿬 �씤�삎�쓣 戮묒쓬
 * 戮묒� �씤�삎怨� 留� �쐞�쓽 �슂�냼媛� 媛숈쑝硫� stack 留� �쐞 �슂�냼瑜� �젣嫄고븯怨� answer += 2
 * stack.peek()怨� �씤�삎�씠 �떎瑜대㈃ �씤�삎�쓣 stack�뿉 �떞�븘以�
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