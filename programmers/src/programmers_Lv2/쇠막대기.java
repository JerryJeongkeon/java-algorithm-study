package programmers_Lv2;

import java.util.Stack;

public class 쇠막대기 {
	static String arrangement = "()(((()())(())()))(())";

	public static void main(String[] args) {
		Stack<Integer> onStack = new Stack<>();
		Stack<Integer> offStack = new Stack<>();
		boolean[] check = new boolean[arrangement.length()];
		int[] count = new int[arrangement.length()];

		for (int i = 0; i < arrangement.length(); i++) {
			char ch = arrangement.charAt(i);

			if (ch == '(' && arrangement.charAt(i + 1) == ')') {
				check[i] = true;
			} else if (ch == '(' && arrangement.charAt(i + 1) == '(') {
				onStack.add(i);
			} else if (ch == ')' && arrangement.charAt(i - 1) == ')') {
				offStack.add(i);
			}
		}

		int answer = 0;
		while (!onStack.isEmpty()) {
			int start = onStack.pop();
			int end = offStack.pop();
			for (int i = start; i <= end; i++) {
				if (check[i])
					answer++;
				count[i]++;
			}
			answer++;
		}
		System.out.println("test : " + answer);
	}
}