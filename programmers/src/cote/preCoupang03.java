
public class preCoupang03 {
	static int r = 3;
	static int[][] delivery = { { 1, 5 }, { 8, 3 }, { 4, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 }, { 4, 2 }, { 5, 2 },
			{ 4, 1 } };
	static Point[][] map;
	static boolean[][] v;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int answer = 0;

	public static void main(String[] args) {
		map = new Point[r][r];
		v = new boolean[r][r];
		for (int i = 0; i < delivery.length; i++) {
			map[i / r][i % r] = new Point(delivery[i][0], delivery[i][1]);
		}
		v[0][0] = true;
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

				if (next_i >= 0 && next_j >= 0 && next_i < r && next_j < r) {
					if (!v[next_i][next_j]) {
						v[next_i][next_j] = true;
						if (map[next_i][next_j].time > cnt)
							dfs(r, map, cnt + 1, next_i, next_j, sum + map[next_i][next_j].cost);
						else
							dfs(r, map, cnt + 1, next_i, next_j, sum);
						v[next_i][next_j] = false;
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
