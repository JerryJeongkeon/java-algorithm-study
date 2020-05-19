package programmers_Lv1;

public class 다트게임 {
	static String dartResult = "1D2S#10S";

	public static void main(String[] args) {
		int[] score = new int[3];
		int answer = 0;
		int scoreIdx = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);

			if (ch == 'S' || ch == 'D' || ch == 'T') {
				if (ch == 'D')
					score[scoreIdx - 1] *= score[scoreIdx - 1];
				else if (ch == 'T')
					score[scoreIdx - 1] = score[scoreIdx - 1] * score[scoreIdx - 1] * score[scoreIdx - 1];
			} else if (ch == '*' || ch == '#') {
				if (ch == '*') {
					score[scoreIdx - 1] *= 2;
					if (scoreIdx > 1)
						score[scoreIdx - 2] *= 2;
				} else {
					score[scoreIdx - 1] *= -1;
				}
			} else if (ch - '0' >= 0 && ch - '0' < 10) {
				if (ch - '0' == 1) {
					if (dartResult.charAt(i + 1) - '0' == 0) {
						score[scoreIdx] = 10;
						i++;
						scoreIdx++;
						continue;
					} else {
						score[scoreIdx] = 1;
					}
				} else {
					score[scoreIdx] = dartResult.charAt(i) - '0';
				}
				scoreIdx++;
			}
		}

		answer = score[0] + score[1] + score[2];
		System.out.println(answer);
	}
}