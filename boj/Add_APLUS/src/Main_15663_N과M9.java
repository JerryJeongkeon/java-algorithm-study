import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15663_N과M9 {

	static int N, M;
	static StringTokenizer st;
	static int[] arr;
	static boolean[] used;
	static Set<String> Set;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Set = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine(), " ");

		arr = new int[N + 1];
		used = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		solve(0, "");

		Iterator<String> it = Set.iterator();
		while (it.hasNext()) {
			bw.write(it.next() + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			Set.add(str.trim());
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				if (!used[i]) {
					used[i] = true;
					solve(cnt + 1, str + arr[i] + " ");
					used[i] = false;
				}
			}
		}
	}
}
