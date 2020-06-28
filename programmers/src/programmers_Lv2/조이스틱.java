package programmers_Lv2;

public class ¡∂¿ÃΩ∫∆Ω {

	static String name = "JEROEN";
	
	public static void main(String[] args) {
		int answer = name.length() - 1;
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if(ch == 'A')
				answer--;
			answer += Math.min(ch-'A', 'Z' - ch + 1);
		}
		
		StringBuilder sb = new StringBuilder();

		System.out.println(answer);
	}
}
