package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		boolean flag = true;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '1') {
				if (input.charAt(i + 1) == '1') {
					flag = false;
					break;
				}
			}
		}

		if (input.charAt(input.length() - 1) == '1')
			flag = false;
		System.out.println(flag);
	}
}
