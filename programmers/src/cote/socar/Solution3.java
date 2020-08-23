package socar;

public class Solution3 {

	static int r = 4;
	static int[][] delivery = { { 1, 10 }, { 8, 1 }, { 8, 1 }, { 3, 100 }, { 8, 1 }, { 8, 1 }, { 8, 1 }, { 8, 1 },
			{ 8, 1 }, { 8, 1 }, { 8, 1 }, { 8, 1 }, { 9, 100 }, { 8, 1 }, { 8, 1 }, { 8, 1 } };

	static Point[][] map;
	static boolean[][] visited;
	static int answer;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		map = new Point[r][r];
		visited = new boolean[r][r];
		answer = 0;

		for (int i = 0; i < delivery.length; i++) {
			map[i / r][i % r] = new Point(delivery[i][0], delivery[i][1]);
		}

		visited[0][0] = true;
		dfs(r, map, 0, 0, 0, map[0][0].cost);
		System.out.println(answer);
	}

	static void dfs(int r, Point[][] map, int cnt, int i, int j, int sum) {
		if (answer < sum)
			answer = sum;

		if (cnt >= 16)
			return;
		else {
			for (int k = 0; k < 4; k++) {
				int next_i = i + di[k];
				int next_j = j + dj[k];
				if (next_i >= 0 && next_i < r && next_j >= 0 && next_j < r) {
					if (!visited[next_i][next_j]) {
						visited[next_i][next_j] = true;
						if (cnt < map[next_i][next_j].time) {
							dfs(r, map, cnt + 1, next_i, next_j, sum + map[next_i][next_j].cost);
						} else
							dfs(r, map, cnt + 1, next_i, next_j, sum);
						visited[next_i][next_j] = false;
					} else {
						dfs(r, map, cnt + 1, next_i, next_j, sum);
					}
				}
			}
		}
	}

	static class Point {
		int time, cost;

		public Point(int t, int c) {
			this.time = t;
			this.cost = c;
		}
	}

}
