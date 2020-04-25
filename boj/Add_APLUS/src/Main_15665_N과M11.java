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

public class Main_15665_N과M11 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr;
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		set = new LinkedHashSet<>();
		solve(0, "");

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			bw.write(it.next());
		}
		bw.flush();
		bw.close();
	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			set.add(str.trim() + "\n");
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				solve(cnt + 1, str + arr[i] + " ");
			}
		}
	}
}