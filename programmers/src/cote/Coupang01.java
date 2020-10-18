import java.util.Arrays;

public class Coupang01 {

	static int N = 10;
	static StringBuilder sb;
	static StringBuilder tempSb;

	public static void main(String[] args) {
		long[] answer = new long[2];
		long max = 0;
		int maxIndex = 0;

		for (int k = 2; k < 10; k++) {
			long value = toKDisposition(N, k);
			if (max <= value) {
				max = value;
				maxIndex = k;
			}
		}
		answer[0] = maxIndex;
		answer[1] = max;
		System.out.println(Arrays.toString(answer));
	}

	private static Long toKDisposition(long targetValue, int k) {
		sb = new StringBuilder();
		while (targetValue != 0) {
			tempSb = new StringBuilder();
			if ((targetValue % k) < 10) {
				tempSb.append((targetValue % k));
				tempSb.append(sb.toString());
				sb = new StringBuilder();
				sb.append(tempSb.toString());
				targetValue /= k;
			} else {
				int temp = (char) ((targetValue % k) + 55);
				tempSb = new StringBuilder();
				tempSb.append(temp);
				tempSb.append(sb.toString());
			}
		}

		long answer = 1;
		String returnValue = sb.toString();
		for (int i = 0; i < returnValue.length(); i++) {
			int num = returnValue.charAt(i) - '0';
			if (num != 0) {
				answer *= num;
			}
		}
		return answer;
	}
}
