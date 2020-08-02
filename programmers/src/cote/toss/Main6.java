package toss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6 {
	static String input = "1 1 0 0;1 0 0 0;0 0 0 1;0 0 1 1";
	static int row, col, answer, next_i, next_j;
	static int[][] arr;
	static String inputStr = "";
	static boolean[][] checked;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		row = 1;
		col = 0;

		// 가로 세로 길이 구하기
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ';') {
				row++;
			} else if (input.charAt(i) == '0' || input.charAt(i) == '1') {
				col++;
			}
		}

		col /= row;
		arr = new int[row][col];
		StringTokenizer st = new StringTokenizer(input, ";");
		int rowIndex = 0;

		// arr에 input Data 모양 배열 만들기
		while (st.hasMoreTokens()) {
			StringTokenizer inputStr = new StringTokenizer(st.nextToken(), " ");
			for (int i = 0; i < col; i++) {
				arr[rowIndex][i] = Integer.parseInt(inputStr.nextToken());
			}
			rowIndex++;
		}

		// bfs로 방문하며 주변 둘레 구하기
		checked = new boolean[row][col];
		answer = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0 && !checked[i][j]) {
					bfs(new Pos(i, j));
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("answer : " + answer);

	}

	// 연결된 지점들을 방문하며 둘레 길이 찾기
	// bfs를 시작할 때마다 방문 여부를 체크하는 배열 새로 만들기 (중복되는 위치의 둘레도 체크해야 함)
	static void bfs(Pos pos) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(pos);
		checked[pos.i][pos.j] = true;

		while (!q.isEmpty()) {
			Pos temp = q.poll();

			for (int k = 0; k < 4; k++) {
				next_i = temp.i + di[k];
				next_j = temp.j + dj[k];

				if (next_i < 0 || next_i >= row || next_j < 0 || next_j >= col)
					continue;

				if (arr[next_i][next_j] == 1) {
					answer++;
				} else if (arr[next_i][next_j] == 0 && !checked[next_i][next_j]) {
					checked[next_i][next_j] = true;
					q.offer(new Pos(next_i, next_j));
				}
			}
		} // end while
	}

	static class Pos {
		int i;
		int j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
}