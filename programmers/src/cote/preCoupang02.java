import java.util.Arrays;

public class preCoupang02 {
	static int k = 3;
	static int t = 11;
	static int[] arr = { 1, 2, 3, 5, 8 };
	static int answer = 0;

	public static void main(String[] args) {
		Arrays.sort(arr);
		combi(0, 0, 0);
		System.out.println(answer);
	}

	static void combi(int idx, int cnt, int sum) {
		System.out.println("idsx : " + idx + " cnt : " + cnt + " sum : " + sum);
		if (cnt >= k && sum <= t)
			answer++;

		for (int i = idx; i < arr.length; i++) {
			int temp = sum + arr[i];
			if (temp <= t) {
				combi(i + 1, cnt + 1, temp);
			} else
				return;
		}
	}
}
