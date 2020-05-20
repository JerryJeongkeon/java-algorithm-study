package programmers_Lv2;

import java.util.Arrays;

public class 탑2 {
	static int[] heights = { 6, 9, 5, 7, 4 };

	public static void main(String[] args) {
		int size = heights.length;
		int[] answer = new int[size];

		for (int i = size - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
