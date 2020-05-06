import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, cnt, max, zero;
	static StringTokenizer st;
	static int[][] map, copy;
	static ArrayList<Pos> list;
	static boolean[] used;
	static Queue<Pos> q;
	static boolean[][] visited;

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
	
	static void bfs(int i, int j) {
		q.add(new Pos(i, j));
		visited = new boolean[N][M];
	}
	
	static void spreadVirus() {
		copy = new int[N][M];
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			copy[i] = map[i].clone();
		}
		
		for (int i = 0; i < zero; i++) {
			if(used[i]) {
				Pos temp = list.get(i);
				copy[list.get(i).i][list.get(i).j] = 1;
			}
		}
		
		// virus 퍼뜨리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copy[i][j] == 2) {
					bfs(i, j);
				}
			}
		}
		
		max = Math.max(cnt, max);
	}

	static void solve(int idx, int cnt) {
		if (cnt == 3) {
			spreadVirus();
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