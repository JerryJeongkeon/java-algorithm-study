package programmers_Lv1;

import java.util.Arrays;

public class ���������������ι�ġ�ϱ� {
	static long n = 118372;

	public static void main(String[] args) {
		String input = "" + n;
		int size = input.length();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = input.charAt(i) - '0';
		}
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for (int i = size - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}
		long answer = Long.parseLong(sb.toString());
		System.out.println(answer);
	}

}
