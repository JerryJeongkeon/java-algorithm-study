package ebay;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	static int[][] simulation_data = { { 2, 3 }, { 5, 4 }, { 6, 3 }, { 7, 4 } };
	static int N = 1;

	public static void main(String[] args) {
		int answer = 0;
		int size = simulation_data.length;

		PriorityQueue<Bank> waitingQueue = new PriorityQueue<>();

		for (int i = 0; i < size; i++) {
			waitingQueue.offer(new Bank(simulation_data[i][0], simulation_data[i][1]));
		}

		int[] timeArr = new int[N];
		while (!waitingQueue.isEmpty()) {
			Bank temp = waitingQueue.poll();

			for (int i = 0; i <= N; i++) {
				if (i == N) {
					Arrays.sort(timeArr);
					answer += timeArr[0] - temp.inTime;
					timeArr[0] = timeArr[0] + temp.delay;
					break;
				}
				
				if (timeArr[i] <= temp.inTime) {
					timeArr[i] = temp.inTime + temp.delay;
					break;
				}
			}
		}
		System.out.println("answer : " + answer);
	}

	static class Bank implements Comparable<Bank> {
		int inTime;
		int delay;

		public Bank(int i, int d) {
			this.inTime = i;
			this.delay = d;
		}

		@Override
		public int compareTo(Bank o) {
			return this.inTime - o.inTime;
		}
	}
}