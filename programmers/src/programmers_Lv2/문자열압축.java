package programmers_Lv2;

public class ���ڿ����� {

	static String s = "aabbaccc";

	public static void main(String[] args) {
		int answer = s.length();
		int size = s.length();

		if (answer <= 2) {
			System.out.println(answer);
		} else {
			for (int i = size / 2; i > 1; i--) {
				System.out.println("i = " + i + " ����");
				int min = check(s, i);
				if (min < answer)
					answer = min;
			}
		}
	}

	// len ���� �ܾ �߶� ������Ѻ���
	static int check(String str, int len) {
		int length = s.length();
		int cnt = 0;
		String split = "";

//		static String s = "aabbaccc";

		for (int k = 0; k + len < length; k += len) {

			// ���� n���� �ڸ� �ܾ� �̱�
			String temp = str.substring(k, k + len);

			System.out.println(k + 2 * len - 1);
			if (k + (2 * len) - 1 < length && str.substring(k + len, k + 2 * len).equals(temp)) {
				System.out.println(temp + "�� " + str.substring(k + len, k + 2 * len) + " �� !");
				if (temp.equals(split)) {
					
				} else
					cnt++;
				split = temp;
			}
		}

		return length;
	}
}