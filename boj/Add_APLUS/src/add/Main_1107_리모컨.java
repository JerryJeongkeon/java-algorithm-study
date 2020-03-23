package add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �⺻ 100������ N������ ���̰��� min ������ ����
// ���� ��ġ���� �̵��� �� �ִ� N�� ���� ����� ä���� ã�ƺ�.
// ä�η� �ű� ����, ���� ����� ������ �̵��� �� �� �ּڰ��� ���

public class Main_1107_������ {
	static int N, M, min, ShortestChannel;
	static boolean[] nums = new boolean[10];
	static boolean[] check;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());

		check = new boolean[500002];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int m = 0; m < M; m++) {
			nums[Integer.parseInt(st.nextToken())] = true;
		}

		// �⺻ min ���� �밡��;
		min = Math.abs(N - 100);
		// ���� ����� ä�� ã�ƺ���
		findShortDistanceChannel(N);

		int answer = 0;
		answer = Integer.toString(ShortestChannel).length();

		// ������ ä�ο��� ���� N�� ä�α����� �Ÿ��� �����ֱ�
		answer += Math.abs(ShortestChannel - N);

		if (answer < min) {
			System.out.println(answer);
		} else {
			System.out.println(min);
		}
	}

	static void findShortDistanceChannel(int N) {
		if (flag)
			return;

		if (!check[N] && checkChannels(N)) {
			check[N] = true;
			ShortestChannel = N;
			flag = true;
			return;
		} else if (!check[N + 1] && checkChannels(N + 1) && (N + 1) <= 500000) {
			check[N + 1] = true;
			ShortestChannel = N + 1;
			flag = true;
			return;
		} else if (!check[N - 1] && checkChannels(N - 1) && (N - 1) >= 0) {
			check[N - 1] = true;
			ShortestChannel = N - 1;
			flag = true;
			return;
		}
		findShortDistanceChannel(N - 1);
		findShortDistanceChannel(N + 1);
	}

	static boolean checkChannels(int channel) {
		String temp = Integer.toString(channel);
		boolean enable = true;

		for (int i = 0; i < temp.length(); i++) {
			if (nums[temp.charAt(i) - '0']) {
				return false;
			}
		}
		return true;
	}
}
