package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2776_¾Ï±â¿Õ {
	static int TC, N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine().trim());
		sb = new StringBuilder();

		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			int[] arr1 = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr1);

			M = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < M; i++) {
				sb.append(Arrays.binarySearch(arr1, Integer.parseInt(st.nextToken())) > -1 ? "1\n" : "0\n");
			}
		}
		System.out.println(sb.toString());
	}
}