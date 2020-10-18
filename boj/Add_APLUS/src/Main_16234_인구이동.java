import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int n;
	static int L;
	static int R;
	static int map[][];
	static boolean[][] visited;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int sec = 0;
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new boolean[n][n];
			if (!check()) {
				sec++;
			} else
				break;
		}
		System.out.println(sec);
	}

	public static boolean check() {
		List<Node> n_list;
		boolean isDone = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					n_list = new LinkedList<>();
					n_list.add(new Node(i, j));
					int sum = dfs(i, j, n_list, 0);
					if (n_list.size() > 1) {
						change(sum, n_list);
						isDone = false;
					}
				}
			}
		}
	}

	static int dfs(int i, int j, List<Node> n_list, int sum) {
		visited[i][j] = true;
		sum = map[i][j];

		for (int k = 0; k < 4; k++) {
			int next_i = i + di[k];
			int next_j = j + dj[k];

			if (next_i < 0 || next_j < 0 || next_i >= n || next_j >= n) {
				continue;
			}

			if (!visited[next_i][next_j]) {
				int d = Math.abs(map[i][j] - map[next_i][next_j]);
				if (d >= L && d <= R) {
					n_list.add(new Node(next_i, next_j));
					sum += dfs(next_i, next_j, n_list, sum);
				}
			}
		}
	}

	static void change(int sum, List<Node> n_list) {
		int avg = sum / n_list.size();
		for (Node node : n_list) {
			map[node.i][node.j] = avg;
		}
	}

	static class Node {
		int i, j;

		public Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
