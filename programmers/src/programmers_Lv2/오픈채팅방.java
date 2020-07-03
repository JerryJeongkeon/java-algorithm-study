package programmers_Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 오픈채팅방 {

	static String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
			"Change uid4567 Ryan" };

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<String, String> map = new HashMap<>();

		for (String str : record) {
			String[] tmp = str.split(" ");
			if (tmp[0].equals("Enter")) {
				map.put(tmp[1], tmp[2]);
			} else if (tmp[0].equals("Change")) {
				map.put(tmp[1], tmp[2]);
			}
		}

		for (String str : record) {
			String[] temp = str.split(" ");

			if (temp[0].equals("Enter")) {
				sb.append("\"" + map.get(temp[1]) + "님이 들어왔습니다.\"/");
			} else if (temp[0].equals("Leave")) {
				sb.append("\"" + map.get(temp[1]) + "님이 나갔습니다.\"/");
			}
		}

		String[] result = sb.toString().split("/");
		System.out.println(Arrays.toString(result));
	}
}