import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		solve(1, 0, "");

		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			solve(i, cnt + 1, str + i + " ");
		}
	}
}
