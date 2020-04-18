import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {
	static int[] arr;
	static int N, M;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		used = new boolean[N + 1];
		sb = new StringBuilder();
		
		solve(0, "");
		System.out.println(sb.toString());
	}
	
	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				solve(cnt + 1, str + i + " ");
				used[i] = false;
			}
		}
	}
}
