import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_≈‰∏∂≈‰ {

	static int N, M, day;
	static int[][] map;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<Pos> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<Pos>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new Pos(i, j, 0));
			}
		}
		bfs();
		System.out.println(day);
	} // end Main

	static void bfs() {
		while (!q.isEmpty()) {
			Pos before = q.poll();
			day = before.day;

			for (int k = 0; k < 4; k++) {
				int next_i = before.i + di[k];
				int next_j = before.j + dj[k];

				if (next_i >= 0 && next_j >= 0 && next_i < N && next_j < M) {
					if (map[next_i][next_j] == 0) {
						map[next_i][next_j] = 1;
						q.offer(new Pos(next_i, next_j, day + 1));
					}
				}
			}
		}
	}

	static class Pos {
		int i, j, day;

		public Pos(int i, int j, int day) {
			this.i = i;
			this.j = j;
			this.day = day;
		}
	}
}
