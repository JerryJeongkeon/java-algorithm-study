import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	static List<Integer> list;
	static int N, M, answer;
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		arr = new int[N];

		for (int n = 1; n <= N; n++) {
			arr[n - 1] = n;
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int m = 0; m < M; m++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		solve(list);
		
	}
	
	static void solve(ArrayList<Integer> lst) {
		
	}
}
