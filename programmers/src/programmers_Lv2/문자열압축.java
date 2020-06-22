package programmers_Lv2;

public class 문자열압축 {

	static String s = "aabbaccc";

	public static void main(String[] args) {
		int answer = s.length();
		int size = s.length();

		if (answer <= 2) {
			System.out.println(answer);
		} else {
			for (int i = size / 2; i > 1; i--) {
				System.out.println("i = " + i + " 시작");
				int min = check(s, i);
				if (min < answer)
					answer = min;
			}
		}
	}

	// len 개씩 단어를 잘라서 압축시켜본다
	static int check(String str, int len) {
		int length = s.length();
		int cnt = 0;
		String split = "";

//		static String s = "aabbaccc";

		for (int k = 0; k + len < length; k += len) {

			// 비교할 n개씩 자른 단어 뽑기
			String temp = str.substring(k, k + len);

			System.out.println(k + 2 * len - 1);
			if (k + (2 * len) - 1 < length && str.substring(k + len, k + 2 * len).equals(temp)) {
				System.out.println(temp + "와 " + str.substring(k + len, k + 2 * len) + " 비교 !");
				if (temp.equals(split)) {
					
				} else
					cnt++;
				split = temp;
			}
		}

		return length;
	}
}