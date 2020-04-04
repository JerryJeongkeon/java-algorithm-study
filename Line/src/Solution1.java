import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1 {
	static int MessageNum = 5;
	static int MachineNum = 3;
	static int[] jobs;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < MachineNum; i++) {
			pq.offer(0);
		}

		for (int i = 0; i < MessageNum; i++) {
			int message = Integer.parseInt(st.nextToken());
			int time = pq.poll();
			pq.add(time + message);
		}

		int max = 0;
		for (int i = 0; i < MachineNum; i++) {
			max = pq.poll();
		}

		System.out.println(max);
	}
}