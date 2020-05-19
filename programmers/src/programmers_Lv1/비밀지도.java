package programmers_Lv1;

public class 비밀지도 {
	static int n = 5;
	static int[] arr1 = {9, 20, 28, 18, 11};
	static int[] arr2 = {30, 1, 21, 17, 28};
	
	public static void main(String[] args) {
		String[] answer = new String[n];
		int[][] board1 = new int[n][n];
		int[][] board2 = new int[n][n];

		String temp = "";
		int index = 0;

		for (int i = 0; i < n; i++) {
			temp = Integer.toBinaryString(arr1[i]);
			index = 0;
			for (int j = n - temp.length(); j < n; j++) {
				board1[i][j] = temp.charAt(index) - '0';
				index++;
			}

			temp = Integer.toBinaryString(arr2[i]);
			index = 0;
			for (int j = n - temp.length(); j < n; j++) {
				board2[i][j] = temp.charAt(index) - '0';
				index++;
			}
		}

		StringBuilder sb = new StringBuilder();
		char[][] arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				if (board1[i][j] == 1 || board2[i][j] == 1) {
					arr[i][j] = '#';
					sb.append(arr[i][j]);
				} else
					sb.append(" ");
			}
			answer[i] = sb.toString();
			System.out.println(answer[i]);
		}
	}
}