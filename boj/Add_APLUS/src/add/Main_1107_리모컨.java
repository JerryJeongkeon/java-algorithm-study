package add;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 기본 100번에서 N번과의 차이값을 min 값으로 설정
// 현재 위치에서 이동할 수 있는 N과 가장 가까운 채널을 찾아봄.
// 채널로 옮긴 값과, 가장 가까운 곳으로 이동한 값 중 최솟값을 출력

public class Main_1107_리모컨 {
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

		// 기본 min 값은 노가다;
		min = Math.abs(N - 100);
		// 가장 가까운 채널 찾아보자
		findShortDistanceChannel(N);

		int answer = 0;
		answer = Integer.toString(ShortestChannel).length();

		// 근접한 채널에서 실제 N번 채널까지의 거리도 더해주기
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
