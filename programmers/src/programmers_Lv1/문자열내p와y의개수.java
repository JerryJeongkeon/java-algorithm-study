package programmers.src.programmers_Lv1;

public class 문자열내p와y의개수 {

	static String s = "pPoooyY";
	public static void main(String[] args) {
		boolean answer = true;
		int cnt = 0;
		char ch = ' ';
		
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(ch == 'p' || ch== 'P')
				cnt++;
			else if (ch == 'y' || ch == 'Y')
				cnt--;
		}
		if(cnt != 0)
			System.out.println(false);
		System.out.println(true);
	}
}
