package add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1107_리모컨_BFS {
	private static boolean[] broken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수빈이가 이동하려고 하는 채널 N ( 0 ~ 500000 )
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 M ( 0 <= M M= 10 )

		broken = new boolean[10]; // 고장난 버튼 표시

		if (M > 0) { // 고장난 버튼이 있다면
			String str = br.readLine(); // 고장난 버튼 한줄 입력
			for (int i = 0; i < str.length(); i += 2) {
				broken[str.charAt(i) - '0'] = true;
			}
		}

		int result = Math.abs(N - 100);
		// 초기에 누를 수 있는 모든 숫자를 고려(반복문)
		for (int i = 0; i <= 999999; i++) { // 50만보다 큰 수에서 내려올 수 있다
			int cnt = check(i);
			if (cnt > 0) {
				int len = Math.abs(i - N);
				if (result > cnt + len) {
					result = cnt + len;
				}
			}
		}

		System.out.println(result);

	} // end of main

	// 숫자판 버튼을 눌러서 완성할 수 있는지 검사
	// 누를 수 없다면 0, 누를 수 있으면 몇번 눌렀는지
	private static int check(int num) {
		if (num == 0) {
			if (broken[0]) {
				return 0;
			} else
				return 1;
		}
		int cnt = 0;

		while (num > 0) {
			if (broken[num % 10]) {
				return 0;
			}
			num /= 10;
			cnt++;
		}

		return cnt;
	}

} // end of class