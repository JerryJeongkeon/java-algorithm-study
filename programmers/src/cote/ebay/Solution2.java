package ebay;

import java.util.Arrays;

public class Solution2 {
	static int num = 18;
	static int[] cards = { 1, 2, 5 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] dp = new int[num + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		Arrays.sort(cards);
		solution(0, 0, num, dp, cards);
		System.out.println("answer : " + min);
	}

	static void solution(int value, int depth, int target, int[] dp, int[] cards) {
		System.out.println("depth :" + depth + ", value : " + value);
		if (value == target) {
			if (depth < min)
				min = depth;
		}

		for (int i = cards.length - 1; i >= 0; i--) {
			if (value + cards[i] <= target && dp[value + cards[i]] > depth + 1) {
				dp[value + cards[i]] = depth + 1;
				solution(value + cards[i], depth + 1, target, dp, cards);
			}
		}
	}
}
