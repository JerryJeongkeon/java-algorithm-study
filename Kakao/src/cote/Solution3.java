package cote;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	static String[] gems = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };

	static Map<String, Integer> map;
	static int startIdx, endIdx;

	public static void main(String[] args) {
		map = new HashMap<>();

		for (int i = 0; i < gems.length; i++) {
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			}
		}

		int num = map.size();
		startIdx = 0;
		endIdx = 0;

		int length = findMinTerm(gems, num);
		System.out.println(length);

		for (int i = 0; i < gems.length - length; i++) {
			map.clear();
			int cnt = 0;
			for (int j = i; j < i + length; j++) {
				if (!map.containsKey(gems[j])) {
					map.put(gems[j], 1);
					cnt++;
				}
				if (cnt == num) {
					startIdx = i;
					endIdx = i + length - 1;
					break;
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = startIdx;
		answer[1] = endIdx;
		System.out.println(answer[0] + ", " + answer[1]);

	}

	static public int findMinTerm(String[] gems, int num) {
		int result = 0;
		int max = gems.length;

		result = binarySearch(gems, num, 1, max);
		return result;
	}

	static public int binarySearch(String[] gems, int num, int start, int end) {
		if (start >= end) {
			return start;
		}

		int mid = (start + end) / 2;
		boolean flag = false;

		find: for (int i = 0; i < gems.length - mid; i++) {
			map.clear();
			int count = 0;
			for (int j = i; j < i + mid; j++) {
				if (!map.containsKey(gems[j])) {
					map.put(gems[i], 1);
					count++;
				}
				if (count == num) {
					flag = true;
					break find;
				}
			}
		}

		if (flag)
			return binarySearch(gems, num, start, mid);
		else
			return binarySearch(gems, num, mid + 1, end);
	}
}
