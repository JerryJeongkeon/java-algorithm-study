import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, cnt, max, zero;
	static StringTokenizer st;
	static int[][] map;
	static ArrayList<Pos> list;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero++;
					list.add(new Pos(i, j));
				}
			}
		}

		used = new boolean[zero];
		solve(0, 0);

	}

	static void solve(int idx, int cnt) {
		if (cnt == 3) {
			System.out.println(Arrays.toString(used));
			return;
		}

		if (zero == idx)
			return;

		if (!used[idx]) {
			used[idx] = true;
			solve(idx + 1, cnt + 1);
			used[idx] = false;
			solve(idx + 1, cnt);
		}
	}

	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}