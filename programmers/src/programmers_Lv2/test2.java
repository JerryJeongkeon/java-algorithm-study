package programmers_Lv2;

public class test2 {

	static long n = 11;

	public static void main(String[] args) {
		String three = Long.toBinaryString(n);
		long answer = 0;
		int idx = 0;
		long pow = 3;
		for (int i = three.length() - 1; i >= 0; i--) {
			answer += (three.charAt(i) - '0') * (pow * idx);
			idx++;
			pow*=3;
		}

		System.out.println(answer);
	}
}
