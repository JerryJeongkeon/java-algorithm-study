package programmers_Lv1;

public class 시저암호 {
	static String s = "a B z";
	static int n = 4;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch + n);
				if (ch > 'z')
					ch -= 26;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch + n);
				if (ch > 'Z')
					ch -= 26;
			}

			sb.append(ch);
		}
		System.out.println(sb.toString());
	}
}
