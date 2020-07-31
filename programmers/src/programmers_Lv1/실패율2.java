package programmers_Lv1;

import java.util.PriorityQueue;

public class ½ÇÆÐÀ²2 {
	static int N = 5;
	static int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

	public static void main(String[] args) {
		int[] result = new int[N];
		int[] countStageUsers = new int[N + 2];
		PriorityQueue<Stage> pq = new PriorityQueue<>();

		for (int i = 0; i < stages.length; i++) {
			countStageUsers[stages[i]]++;
		}

		int reach = stages.length;
		double failure = 0;

		for (int i = 1; i < N + 1; i++) {
			if (reach == 0) {
				failure = 0.0;
			} else
				failure = (double) countStageUsers[i] / reach;
			reach -= countStageUsers[i];

			pq.offer(new Stage(i, failure));
		}

		for (int i = 0; i < result.length; i++) {
			Stage temp = pq.poll();
			result[i] = temp.idx;
		}

	}

	static class Stage implements Comparable<Stage> {
		int idx;
		double failure;

		public Stage(int index, double failure) {
			this.idx = index;
			this.failure = failure;
		}

		@Override
		public int compareTo(Stage stage) {
			if (stage.failure == this.failure) {
				return this.idx - stage.idx;
			}
			if (this.failure - stage.failure > 0)
				return -1;
			else
				return 1;
		}
	}
}