import java.util.HashMap;
import java.util.Map;

public class Coupang03 {

	static int k = 2;
	static int[] score = { 1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100 };

	public static void main(String[] args) {
		int[] gaps = new int[score.length];
		for (int i = 1; i < score.length; i++) {
			gaps[i] = score[i - 1] - score[i];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < gaps.length; i++) {
			if (!map.containsKey(gaps[i])) {
				map.put(gaps[i], 1);
			} else {
				map.put(gaps[i], map.get(gaps[i]) + 1);
			}
		}

		boolean[] check = new boolean[score.length];
		for (int i = 1; i < gaps.length; i++) {
			if (map.get(gaps[i]) >= k) {
				check[i-1] = check[i] = true;
			} else
				continue;
		}

		int counter = 0;
		for (int i = 0; i < score.length; i++) {
			if (check[i])
				counter++;
		}
		System.out.println(score.length - counter);
	}
}
