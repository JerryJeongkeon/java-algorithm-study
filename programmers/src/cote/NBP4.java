import java.util.Arrays;

public class NBP4 {

	static int N = 2;
	static int capacity = 5;
	static int[] files = { 1, 2, 3, 4, 5 };

	static int[] dp;
	static boolean[] used;
	static int answer;

	public static void main(String[] args) {
		answer = 0;

		dp = new int[N];
		used = new boolean[files.length];

		for (int i = 0; i < files.length; i++) {
			if (capacity < files[i])
				used[i] = true;
		}

		solve(dp, used, capacity, files, 0, 0);

		System.out.println("answer : " + answer);
	}

	static void solve(int[] dp, boolean[] used, int capacity, int[] files, int size, int idx) {
		System.out.println("===================");
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(used));
		System.out.println("size : " + size);
		System.out.println("=---------------------");

		if (size > answer)
			answer = size;

		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {

				for (int k = 0; k < dp.length; k++) {
					if (dp[k] + files[i] <= capacity) {
						used[i] = true;
						dp[k] += files[i];
						solve(dp, used, capacity, files, size + 1, idx+1);
						used[i] = false;
						dp[k] -= files[i];
					}
				}
			}
		}
	}
}