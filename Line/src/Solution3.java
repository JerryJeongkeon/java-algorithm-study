import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		
		Time[] times = new Time[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(st.nextToken().trim());
			int out = Integer.parseInt(st.nextToken().trim());
			times[i] = new Time(in, out);
		}
		
		Arrays.sort(times);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(0);
		
		int count = 0;
		int max = 0;
		for(Time time : times) {
			if(max >= time.in) {
				count++;
			}
			if(time.out > max)
				max = time.out;
		}
		
		System.out.println("count : " + count);
	}

	static class Time implements Comparable<Time> {
		int in;
		int out;

		public Time(int in, int out) {
			this.in = in;
			this.out = out;
		}

		@Override
		public int compareTo(Time o) {
			int ret = this.in - o.in;
			if (ret == 0) {
				ret = this.out - o.out;
			}
			return ret;
		}
	}
}
