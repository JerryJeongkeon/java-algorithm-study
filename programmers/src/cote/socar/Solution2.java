package socar;

public class Solution2 {

	// # - ¾Æ·¡·Î 1 Ä­
	// > - ¿À¸¥ÂÊ 1Ä­
	// < - ¿ÞÂÊ 1Ä­
	// * - Ã³À½ÀÌ¸é ¾Æ·¡·Î 1Ä­, µÎ ¹øÂ°¸é STOP

	static String[] drum = { "###*##", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######" };
	static int row, col, answer, cnt;

	public static void main(String[] args) {
		row = drum[0].length();
		col = drum.length;

		answer = 0;

		for (int i = 0; i < col; i++) {
			dfs(0, i, drum[0].charAt(i), false);
		}

		System.out.println("answer : " + answer);
	}

	static void dfs(int i, int j, char ch, boolean flag) {
		if (i < 0 || j < 0 || i >= row || j >= col)
			return;

		// ¼º°ø
		if (i == row - 1) {
			answer++;
			return;
		}

		if (ch == '#') {
			dfs(i + 1, j, drum[i + 1].charAt(j), flag);
		} else if (ch == '>') {
			dfs(i, j + 1, drum[i].charAt(j + 1), flag);
		} else if (ch == '<') {
			dfs(i, j - 1, drum[i].charAt(j - 1), flag);
		} else if (ch == '*') {
			if(flag)
				return;
			else {
				dfs(i+1, j, drum[i + 1].charAt(j), true);
			}
		}
	}
}
