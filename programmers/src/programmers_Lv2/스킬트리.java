package programmers_Lv2;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리 {
	static String skill = "CBD";
	static String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

	public static void main(String[] args) {
		int answer = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i + 1);
		}

		for (int i = 0; i < skill_trees.length; i++) {
			String str = skill_trees[i];
			int index = 0;
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (skill.contains(Character.toString(ch))) {
					if (map.get(ch) == index + 1) {
						index++;
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				answer++;
		}
		System.out.println(answer);
	}
}