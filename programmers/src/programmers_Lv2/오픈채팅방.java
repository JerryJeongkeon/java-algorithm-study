package programmers_Lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ����ä�ù� {

	static String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
			"Change uid4567 Ryan" };

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Map<String, String> map = new HashMap<>();

		for (String str : record) {
			st = new StringTokenizer(str, " ");
			if (st.nextToken().equals("Enter")) {
				map.put(st.nextToken(), st.nextToken());
			} else if (st.nextToken().equals("Change")) {
				map.put(st.nextToken(), st.nextToken());
			}
		}

		for (String str : record) {
			String[] temp = str.split(" ");

			if (temp[0].equals("Enter")) {
				sb.append("\"" + map.get(temp[1]) + "���� ���Խ��ϴ�.\"/");
			} else if (temp[0].equals("Leave")) {
				sb.append("\"" + map.get(temp[1]) + "���� �������ϴ�.\"/");
			}
		}

		String[] result = sb.toString().split("/");
		System.out.println(Arrays.toString(result));
	}
}