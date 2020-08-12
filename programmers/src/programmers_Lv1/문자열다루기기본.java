package programmers_Lv1;

public class 문자열다루기기본 {
	static String s = "1234";
	
	public static void main(String[] args) {
		if(s.length() == 4 || s.length() == 6) {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch < '0' || ch > '9')
					System.out.println(false);
			}
			System.out.println(true);
		} else
			System.out.println(false);
	}

}
