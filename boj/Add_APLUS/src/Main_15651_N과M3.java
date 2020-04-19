import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static int N, M;
	static StringTokenizer st;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		used = new boolean[N + 1];
		solve(0, "");

		System.out.println(sb.toString());
	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				solve(cnt + 1, str + i + " ");
			}
		}
	}
}