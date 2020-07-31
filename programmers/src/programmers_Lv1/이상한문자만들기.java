package programmers_Lv1;

public class 이상한문자만들기 {
	static String s = "Let MEINTRODUCE MYSELF";

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		
		for (int i = 0; i < s.length(); i++) {
			String upper = s.toUpperCase();
			String lower = s.toLowerCase();
			
			if(s.charAt(i) == ' ') {
				sb.append(' ');
				idx = 0;
			} else {
				if(idx % 2 == 0) {
					sb.append(upper.charAt(i));
					idx++;
				} else {
					sb.append(lower.charAt(i));
					idx++;
				}
			}
		}

		String answer = sb.toString();
		System.out.println(answer);
	}
}
