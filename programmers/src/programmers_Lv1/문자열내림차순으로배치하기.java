package programmers.src.programmers_Lv1;

import java.util.ArrayList;
import java.util.Collections;

public class 문자열내림차순으로배치하기 {

	static String s = "Zbcdefg";

	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		Collections.sort(list);

		StringBuilder sb = new StringBuilder();
		while (list.size() > 0) {
			sb.append(list.remove(list.size() - 1));
		}
		System.out.println(sb.toString());
	}
}
