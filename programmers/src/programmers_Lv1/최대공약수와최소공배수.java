package programmers_Lv1;

import java.util.Arrays;

public class �ִ��������ּҰ���� {
	static int n = 12;
	static int m = 18;

	public static void main(String[] args) {
		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0];
		System.out.println(Arrays.toString(answer));
	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
