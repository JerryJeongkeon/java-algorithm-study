package programmers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 실패율 {
	static int N = 4;
	static int[] stages = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

	public static void main(String[] args) {
		int[] answer = new int[N];
		int userSize = stages.length;

		int[] stageCnt = new int[N + 2];
		for (int i = 0; i < userSize; i++) {
			stageCnt[stages[i]]++;
		}

		int nowTotalUser = 0;
		double stageFail = 0.0;
		int temp = 0;

		PriorityQueue<Stage> pq = new PriorityQueue<>(new Comparator<Stage>() {
			@Override
			public int compare(Stage s1, Stage s2) {
				if (s1.failer == s2.failer)
					return s1.index - s2.index;
				if (s2.failer - s1.failer > 0)
					return 1;
				else if (s2.failer - s1.failer < 0)
					return -1;
				return 0;
			}
		});

		for (int i = 1; i <= N; i++) {
			temp = nowTotalUser;
			nowTotalUser += stageCnt[i];

			if (userSize - temp == 0 || stageCnt[i] == 0) {
				pq.add(new Stage(i, 0));
			} else {
				stageFail = (double) stageCnt[i] / (userSize - temp);
				pq.add(new Stage(i, stageFail));
			}
		}

		for (int i = 1; i <= N; i++) {
			answer[i - 1] = pq.remove().index;
		}

		System.out.println(Arrays.toString(answer));
	}

	static class Stage {
		int index;
		double failer;

		public Stage(int i, double f) {
			this.index = i;
			this.failer = f;
		}
	}
}