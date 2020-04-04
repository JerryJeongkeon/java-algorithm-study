import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine(), " ");

		boolean[] used = new boolean[N];
		int cnt = 0;
		int max = 0;
		int zero = 0;
		
		for (int i = 0; i < used.length; i++) {
			int state = Integer.parseInt(st.nextToken());
			if(state == 1)
				used[i] = true;
			else
				zero++;
		}
		
		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				cnt = 0;
			} else
				cnt++;
			
			if (cnt > max)
				max = cnt;
		}
		
		if(max == 1 && zero > 1)
			max = 2;
		System.out.println(max - 1);
	}
}
