package programmers_Lv1;

public class �����������Ǻ� {
	static int n = 118372;

	public static void main(String[] args) {
		if (Math.sqrt(n) % 1 == 0) {
			System.out.println((long) ((Math.sqrt(n) + 1) * (Math.sqrt(n) + 1)));
		} else {
			System.out.println(-1);
		}
	}

}
