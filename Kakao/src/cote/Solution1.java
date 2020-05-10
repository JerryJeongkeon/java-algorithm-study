package cote;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
	static int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
	static String hand = "left";

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("12", 1);
		map.put("15", 2);
		map.put("18", 3);
		map.put("10", 4);

		map.put("22", 0);
		map.put("25", 1);
		map.put("28", 2);
		map.put("20", 3);

		map.put("32", 1);
		map.put("35", 2);
		map.put("38", 3);
		map.put("30", 4);

		map.put("42", 2);
		map.put("45", 1);
		map.put("48", 2);
		map.put("40", 3);

		map.put("52", 1);
		map.put("55", 0);
		map.put("58", 1);
		map.put("50", 2);

		map.put("62", 2);
		map.put("65", 1);
		map.put("68", 2);
		map.put("60", 3);

		map.put("72", 3);
		map.put("75", 2);
		map.put("78", 1);
		map.put("70", 2);

		map.put("82", 2);
		map.put("85", 1);
		map.put("88", 0);
		map.put("80", 1);

		map.put("92", 3);
		map.put("95", 2);
		map.put("98", 1);
		map.put("90", 2);

		map.put("*2", 4);
		map.put("*5", 3);
		map.put("*8", 2);
		map.put("*0", 1);

		map.put("02", 3);
		map.put("05", 2);
		map.put("08", 1);
		map.put("00", 0);

		map.put("#2", 4);
		map.put("#5", 3);
		map.put("#8", 2);
		map.put("#0", 1);

		StringBuilder sb = new StringBuilder();
		String left = "*";
		String right = "#";

		for (int i = 0; i < numbers.length; i++) {
			String ch = "" + numbers[i];
			if (ch.equals("1") || ch.equals("4") || ch.equals("7")) {
				sb.append("L");
				left = ch;
			} else if (ch.equals("3") || ch.equals("6") || ch.equals("9")) {
				sb.append("R");
				right = ch;
			} else {
				String leftTemp = left;
				String rightTemp = right;
				
				int leftDist = map.get(left+ch);
				int rightDist = map.get(right + ch);
				
				if(leftDist > rightDist) {
					sb.append("R");
					right = ch;
				} else if (leftDist < rightDist) {
					sb.append("L");
					left = ch;
				} else {
					if(hand.equals("left")) {
						sb.append("L");
						left = ch;
					} else {
						sb.append("R");
						right = ch;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
