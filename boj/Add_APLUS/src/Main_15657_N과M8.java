import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {
	static int N, M;
	static int[] arr;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		solve(1, 0, "");
		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = idx; i <= N; i++) {
				solve(i, cnt + 1, str + arr[i] + " ");
			}
		}
	}

}
