package programmers_Lv1;

public class �ڸ������ϱ� {
	static int N = 987;

	public static void main(String[] args) {
		int answer = 0;
		while (N >= 1) {
			answer += N % 10;
			N /= 10;
		}
		System.out.println(answer);
	}

}
