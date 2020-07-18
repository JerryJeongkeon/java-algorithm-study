package programmers_Lv2;

public class 점프와순간이동 {
	static int n = 5;

	public static void main(String[] args) {
		int cnt = 0;
		int num = n;

		while (num != 0) {
			if (num % 2 == 0)
				num /= 2;
			else {
				num--;
				cnt++;
			}
		}

		System.out.println("ANSWER : " + cnt);
	}
}
