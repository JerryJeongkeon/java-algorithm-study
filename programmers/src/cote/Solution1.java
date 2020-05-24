package cote;

public class Solution1 {
	static int[][] board = { { 1, 1, 3, 3 }, { 4, 1, 3, 4 }, { 1, 2, 1, 1 }, { 2, 1, 3, 2 } };
	static boolean[][] check;
	static int[][] copy;
	static int answer, len, max;

	public static void main(String[] args) {
		len = board.length;
		answer = 0;
		copy = new int[len][len];

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int c = 0; c < len; c++) {
					copy[c] = board[c].clone();
				}
				crush(copy, i, j);
			}
		}
		System.out.println(answer);
	}

	// 1. 블록을 깬다
	// 2. 블록을 내린다.
	// 3. 터뜨린다.
	// 4. 또 터지는지 검사
	// 5. 터지면 (3~4), 안터지면 max와 비교
	static void crush(int[][] copy, int i, int j) {
		// (블록을 깬다) 블록을 내린다
		for (int k = i - 1; k >= 0; k--) {
			copy[k + 1][j] = copy[k][j];
		}
		copy[0][j] = 0;

		// 체크
		while (checking(copy)) {
			check = new boolean[len][len];
			boom(copy);
		}
	}

	static void boom(int[][] map) {
		// 가로로 검사
		for (int i = len - 1; i >= 0; i--) {
			for (int j = 0; j < len - 2; j++) {
				int val = map[i][j];
				int cnt = 1;
				for (int k = j + 1; k < len; k++) {
					if (val == map[i][k]) {
						cnt++;
					} else
						break;
					if (cnt >= 3) {
						for (int kk = j; kk < len; kk++) {
							if (val == map[i][kk])
								check[i][kk] = true;
							else
								break;
						}
					}
				}
			}
		}

		// 세로로 검사
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 2; j++) {
				int val = map[j][i];
				int cnt = 1;
				for (int k = j + 1; k < len; k++) {
					if (val == map[k][i]) {
						cnt++;
					} else
						break;
					if (cnt >= 3) {
						for (int k2 = j; k2 < len; k2++) {
							if (val == map[k2][i])
								check[k2][i] = true;
							else
								break;
						}
					}
				}
			}
		}

		// 터뜨리고 카운트
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (check[i][j]) {
					map[i][j] = 0;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(map[i][j] == 0)
					count++;
			}
		}
		
		if(answer < count)
			answer = count;

		// 블록 내려주기
		for (int i = len - 1; i >= 0; i--) {
			for (int j = 0; j < len - 1; j++) {
				if(map[i][j] == 0) {
					for (int j2 = i; j2 >= 0; j2--) {
						if(map[j2][j] != 0) {
							map[i][j] = map[j2][j];
							map[j2][j] = 0;
							break;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < len; i++) {
			copy[i] = map[i].clone();
		}
	}

	static boolean checking(int[][] map) {
		// 가로 검사
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 2; j++) {
				int val = map[i][j];
				if (val != 0 && val == map[i][j + 1] && val == map[i][j + 2])
					return true;
			}
		}

		// 세로 검사
		for (int i = 0; i < len - 2; i++) {
			for (int j = 0; j < len; j++) {
				int val = map[i][j];
				if (val != 0 && val == map[i + 1][j] && val == map[i + 2][j])
					return true;
			}
		}
		return false;
	}

}