package programmers_Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	static int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
			{ 0, 0, 0, 3 } };
	static int m = 6;
	static int n = 4;
	static int[][] map;
	static boolean[][] visited;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<Pos> q;
	static int next_i, next_j, cnt, max;

	public static void main(String[] args) {
		int numberOfArea = 0;
		q = new LinkedList<Pos>();
		visited = new boolean[m][n];
		max = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					cnt = 0;
					numberOfArea++;
					bfs(new Pos(i, j));
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = max;
		System.out.println(Arrays.toString(answer));
	}

	static void bfs(Pos before) {
		q.offer(before);
		visited[before.i][before.j] = true;

		while (!q.isEmpty()) {
			cnt++;
			if (cnt > max)
				max = cnt;

			Pos temp = q.poll();
			for (int k = 0; k < 4; k++) {
				next_i = temp.i + di[k];
				next_j = temp.j + dj[k];

				if (next_i < 0 || next_i >= m || next_j < 0 || next_j >= n)
					continue;
				if (!visited[next_i][next_j] && picture[temp.i][temp.j] == picture[next_i][next_j]) {
					visited[next_i][next_j] = true;
					q.offer(new Pos(next_i, next_j));
				}
			}
		}
	}

	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}