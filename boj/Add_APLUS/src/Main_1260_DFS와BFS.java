import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS¿ÍBFS {

	static StringTokenizer st;
	static int N, M, V;
	static int[][] map;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			map[s][e] = 1;
			map[e][s] = 1;
		}
		used = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		used = new boolean[N + 1];
		bfs(V);
		System.out.println(sb.toString());
	}
	
	static void dfs(int s) {
		used[s] = true;
		sb.append(s + " ");
		
		for (int i = 1; i <= N; i++) {
			if(map[s][i] == 1 && !used[i])
				dfs(i);
		}
	}
	
	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		used[s] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			sb.append(tmp + " ");
			
			for (int i = 1; i <= N; i++) {
				if(map[tmp][i] == 1 && !used[i]) {
					q.offer(i);
					used[i] = true;
				}
			}
		}
	}
}
