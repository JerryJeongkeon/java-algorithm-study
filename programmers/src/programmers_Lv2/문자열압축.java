package programmers_Lv2;

public class 문자열압축 {

	static String s = "aabbaccc";

	public static void main(String[] args) {
		int answer = s.length();
		int size = s.length();

		if (answer <= 2) {
			System.out.println(answer);
		} else {
			for (int i = size / 2; i >= 1; i--) {
				int min = check(s, i);
				if (min < answer)
					answer = min;
			}
		}
		System.out.println("answer : " + answer);
	}

	// len 개씩 단어를 잘라서 압축시켜본다
	static int check(String str, int len) {
		int length = s.length();
		int cnt = len;
		String split = "";
		int sameCheck = 0;

		System.out.println("len : " + len + "----");
		for (int k = 0; k + len < length; k += len) {
			System.out.println("cnt : " + cnt + "k : " + k);
			// 비교할 n개씩 자른 단어 뽑기
			String temp = str.substring(k, k + len);
			if (temp.equals(split)) {
				k += len;
				sameCheck+=len+1;
				System.out.println("k:"+ k +", " + sameCheck);
				
				System.out.println(sameCheck);
				if (sameCheck >= 10)
					cnt++;
				else if (sameCheck >= 100)
					cnt++;
				continue;
			} else
				sameCheck = 0;

			if (k + (2 * len) <= length && str.substring(k + len, k + 2 * len).equals(temp)) {
				cnt += len + 1;
				k += len;

				split = temp;
			} else {
				cnt += len;
			}
		}
		cnt += length % len;
		System.out.println("len :  "+ len + " cnt : " + cnt);
		return cnt;
	}
}