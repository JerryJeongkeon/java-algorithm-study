import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N과M7 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N + 1];
		used = new boolean[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(0, "");

		System.out.println(sb.toString());

	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				used[i] = true;
				solve(cnt + 1, str + arr[i] + " ");
				used[i] = false;
			}
		}
	}
}
