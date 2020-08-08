package programmers_Lv1;

public class 소수찾기 {

	static int n = 5;

	public static void main(String[] args) {
		int answer = 0;
		boolean[] checked = new boolean[n + 1];

		for (int i = 2; i <= n; i++) {
			if (!checked[i])
				answer++;
			for (int j = i; j <= n; j += i) {
				if (!checked[j])
					checked[j] = true;
			}
		}
		System.out.println("answer : " + answer);
	}
}
