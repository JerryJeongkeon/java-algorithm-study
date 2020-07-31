package programmers_Lv1;

public class 다트게임2 {
	static String dartResult = "1D2S#10S";

	public static void main(String[] args) {
		int[] score = new int[3];
		int answer = 0;
		int scoreIdx = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			if (ch >= '0' && ch <= '9') {
				if (ch == '1') {
					if (dartResult.charAt(i + 1) == '0') {
						score[scoreIdx] = 10;
						i++;
						scoreIdx++;
						continue;
					}
					score[scoreIdx] = 1;
					scoreIdx++;
				} else {
					score[scoreIdx] = ch - '0';
					scoreIdx++;
				}
			} else if (ch == 'S' || ch == 'D' || ch == 'T') {
				if (ch == 'D') {
					score[scoreIdx - 1] *= score[scoreIdx - 1];
				} else if (ch == 'T') {
					score[scoreIdx - 1] *= score[scoreIdx - 1] * score[scoreIdx - 1];
				}
			} else if (ch == '*' || ch == '#') {
				if (ch == '*') {
					if (scoreIdx == 1) {
						score[0] *= 2;
						continue;
					}
					score[scoreIdx - 1] *= 2;
					score[scoreIdx - 2] *= 2;
				} else if (ch == '#') {
					score[scoreIdx - 1] *= -1;
				}
			}
		}
		answer = score[0] + score[1] + score[2];
	}
}