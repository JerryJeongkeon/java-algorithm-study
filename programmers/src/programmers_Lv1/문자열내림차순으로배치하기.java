package programmers_Lv1;

import java.util.ArrayList;
import java.util.Collections;

public class ���ڿ������������ι�ġ�ϱ� {

	static String s = "Zbcdefg";

	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		Collections.sort(list);

		while (list.size() > 0) {
			System.out.println(list.remove(0));
		}
	}
}
