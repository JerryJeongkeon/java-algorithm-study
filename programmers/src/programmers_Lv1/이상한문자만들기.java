package programmers_Lv1;

import java.util.StringTokenizer;

public class 이상한문자만들기 {
	static String s = "try hello world";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			String Upper = temp.toUpperCase();
			String Lower = temp.toLowerCase();
			for (int i = 0; i < temp.length(); i++) {
				if (i % 2 == 0) {
					sb.append(Upper.charAt(i));
				} else {
					sb.append(Lower.charAt(i));
				}
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
