package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11723_집합 {
	static int M;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine().trim());
		Set<Integer> Sset = new HashSet<>();
		StringBuilder sb = new StringBuilder();

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (command.equals("all")) {
				for (int i = 1; i <= 20; i++) {
					Sset.add(i);
				}
				continue;
			} else if (command.equals("empty")) {
				Sset.clear();
				continue;
			} else {
				int num = Integer.parseInt(st.nextToken());

				if (command.equals("add")) {
					Sset.add(num);
				} else if (command.equals("remove")) {
					Sset.remove(num);
				} else if (command.equals("check")) {
					if (Sset.contains(num)) {
						sb.append("1\n");
					} else
						sb.append("0\n");
				} else if (command.equals("toggle")) {
					if (Sset.contains(num)) {
						Sset.remove(num);
					} else {
						Sset.add(num);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
