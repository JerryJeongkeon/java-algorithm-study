package add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1107_������_BFS {
	private static boolean[] broken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // �����̰� �̵��Ϸ��� �ϴ� ä�� N ( 0 ~ 500000 )
		int M = Integer.parseInt(br.readLine()); // ���峭 ��ư�� ���� M ( 0 <= M M= 10 )

		broken = new boolean[10]; // ���峭 ��ư ǥ��

		if (M > 0) { // ���峭 ��ư�� �ִٸ�
			String str = br.readLine(); // ���峭 ��ư ���� �Է�
			for (int i = 0; i < str.length(); i += 2) {
				broken[str.charAt(i) - '0'] = true;
			}
		}

		int result = Math.abs(N - 100);
		// �ʱ⿡ ���� �� �ִ� ��� ���ڸ� ���(�ݺ���)
		for (int i = 0; i <= 999999; i++) { // 50������ ū ������ ������ �� �ִ�
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

	// ������ ��ư�� ������ �ϼ��� �� �ִ��� �˻�
	// ���� �� ���ٸ� 0, ���� �� ������ ��� ��������
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