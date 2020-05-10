package winter;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {

	static String[] user_id = {
			"frodo1", "frodo2", "frodo3", "frodo4"
	};
	static String[] banned_id = {
			"******", "******"
	};
	
	static boolean[][] map;
	static int result, uSize, bSize;
	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		result = 0;
		uSize = user_id.length;
		bSize = banned_id.length;		
		map = new boolean[uSize][bSize];
		
		for (int i = 0; i < uSize; i++) {
			for (int j = 0; j < bSize; j++) {
				if(user_id[i].length() == banned_id[j].length()) {
					boolean flag = true;
					for (int k = 0; k < banned_id[j].length(); k++) {
						if(banned_id[j].charAt(k) == '*')
							continue;
						if(user_id[i].charAt(k) != banned_id[j].charAt(k)) {
							flag = false;
							break;
						}
					}
					if(flag)
						map[i][j] = true;
				}
			}
		}
		
		boolean[] used = new boolean[user_id.length];
		select(0, used);
		result = set.size();
		System.out.println(result);
	}

	static void select(int cnt, boolean[] use) {
		if(cnt == bSize) {
			String temp = "";
			for (int i = 0; i < use.length; i++) {
				if(use[i])
					temp += i + " ";
			}
			System.out.println(temp);
			set.add(temp);
			return;
		}
		
		for (int i = 0; i < uSize; i++) {
			if(!use[i]) {
				if(map[i][cnt]) {
					use[i] = true;
					select(cnt+1, use);
					use[i] = false;
				}
			}
		}
	}
}