package programmers_Lv1;

public class ��ձ��ϱ� {
	static int[] arr = { 1, 2, 3, 4 };

	public static void main(String[] args) {
		double answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		answer /= arr.length;
		System.out.println(answer);
	}
}