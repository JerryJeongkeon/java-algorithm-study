import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 맵을 그린다.

// 2. 도형을 입력받으면 스티커를 붙인다.
//	2-1 가능한 곳에 넣어보고 
//	넣을 수 있나 행, 열 검사 --> 모든 1자리가 0인지 검사	
//			불가능하면 90도 회전
//	2-2 모두 못붙였다면 그냥 버린다.

//	3. 스티커 붙인 뒤 전체 갯수 확인 (calc)

public class Main_18808_스티커붙이기 {
	static int N, M, K, Kn, Km, answer;
	static int[][] board, tBoard;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			Kn = Integer.parseInt(st.nextToken());
			Km = Integer.parseInt(st.nextToken());
			tBoard = new int[Kn][Km];

			for (int i = 0; i < Kn; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < Km; j++) {
					tBoard[i][j] = Integer.parseInt(st.nextToken());
				}

				for (int a = 0; a < 4; a++) {
					if (attach()) { // 스티커를 붙였으면
						break;
					} else { // 스티커를 못붙였다
						rotate(a % 2); // 90도 회전
					}
				}
			}

		}
		// board에 붙은 총 스티커의 수 계산
		calc();

		System.out.println(answer);
	}

	// 스티커 붙여보기 ( tBoard를 board에 붙이기 )
	// 위쪽, 왼쪽부터 확인한다.
	static boolean attach() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i > N - Kn || j > M - Km)
					continue;
				if (check(i, j)) { // 여기 붙일 수 있네?
					sticker(i, j);
					return true;
				}
			}
		}
		return false;
	}

	// si, sj 위치에 스티커가 붙을 수 있는지 check!
	static boolean check(int si, int sj) {
		for (int i = si; i < si + Kn; i++) {
			for (int j = sj; j < sj + Km; j++) {
				if (board[i][j] == 1) {
					if (tBoard[i - si][j - sj] == 1)
						return false;
				}
			}
		}
		return true;
	}

	// 실제 sticker를 붙이는 단계
	static void sticker(int si, int sj) {
		for (int i = si; i < si + Kn; i++) {
			for (int j = sj; j < sj + Km; j++) {
				if (tBoard[i - si][j - sj] == 1)
					board[i][j] = 1;
			}
		}
	}

	// 90도 회전시키기
	static void rotate(int flag) {
		if (flag == 0) {
			int[][] copy = new int[Km][Kn];

			// 0 ~ 4 까지
			for (int i = 0; i < Km; i++) {
				// 1 ~ 0 까지
				for (int j = 0; j < Kn; j++) {
					copy[i][j] = tBoard[Kn - j - 1][i];
				}
			}

			tBoard = new int[Km][Kn];
			for (int i = 0; i < Km; i++) {
				tBoard[i] = copy[i].clone();
			}
		} else {
			int[][] copy = new int[Kn][Km];

			// 0 ~ 4 까지
			for (int i = 0; i < Kn; i++) {
				// 1 ~ 0 까지
				for (int j = 0; j < Km; j++) {
					copy[i][j] = tBoard[Km - j - 1][i];
				}
			}

			tBoard = new int[Kn][Km];
			for (int i = 0; i < Kn; i++) {
				tBoard[i] = copy[i].clone();
			}
		}
	}

	static void calc() {
		answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1)
					answer++;
			}
		}
	}
}
