package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean[] duplicateCheckArray = new boolean[46];
		boolean flag = true;
		int numCount = 0;
		int maxValue = 0;

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			numCount++;

			if (num > 45 || num < maxValue) {
				flag = false;
				break;
			}

			if (duplicateCheckArray[num]) {
				flag = false;
				break;
			} else {
				duplicateCheckArray[num] = true;
			}
			maxValue = num;
		}

		if (numCount != 6)
			flag = false;

		System.out.println(flag);
	}
}
