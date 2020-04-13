package programmers;

import java.util.Arrays;

public class 정수뒤집어배열로만들기 {
	static long n = 12345;
	
	public static void main(String[] args) {
		String input = ""+n;
		int size = input.length();
		int[] answer = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			answer[i] = input.charAt(size - i - 1) - '0';
		}
		System.out.println(Arrays.toString(answer));
	}

}
