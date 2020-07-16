package programmers_Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 영어끝말잇기 {
	static int n = 5;
	static String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		int[] result = new int[2];
		boolean flag = true;

		for (int i = 0; i < words.length; i++) {
			if (!flag) {
				result[0] = i - 1;
				break;
			}
		}

		System.out.println(Arrays.toString(result));
	}
}