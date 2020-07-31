package programmers_Lv1;

import java.util.Arrays;

public class 비밀지도2 {
	static int n = 5;
	static int[] arr1 = { 9, 20, 28, 18, 11 };
	static int[] arr2 = { 30, 1, 21, 17, 28 };

	public static void main(String[] args) {
		String[] answer = new String[n];
		int[][] board1 = new int[n][n];
		int[][] board2 = new int[n][n];

		for (int i = 0; i < n; i++) {
			int num = arr1[i];
			String binaryNum = Integer.toBinaryString(num);
			for (int j = 0; j < binaryNum.length(); j++) {
				board1[i][n - j - 1] = binaryNum.charAt(binaryNum.length() - j - 1) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			int num = arr2[i];
			String binaryNum = Integer.toBinaryString(num);
			for (int j = 0; j < binaryNum.length(); j++) {
				board2[i][n - j - 1] = binaryNum.charAt(binaryNum.length() - j - 1) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			answer[i] = "";
			for (int j = 0; j < n; j++) {
				if(board1[i][j] == 1 || board2[i][j] == 1) {
					answer[i] += "#";
				} else
					answer[i] += " ";
			}
		}
	}
}