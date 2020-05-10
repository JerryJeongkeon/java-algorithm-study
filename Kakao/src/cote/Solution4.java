package cote;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution4 {
	static int[][] board = { 
			{0, 0, 1, 0}, 
			{0, 0, 0, 0},
			{0, 1, 0, 1},
			{1, 0, 0, 0}
					};

	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int answer, N, next_i, next_j;
	static PriorityQueue<Pos> pq;
	static int[][] costs;
	static boolean[][] visited;

	public static void main(String[] args) {
		answer = Integer.MAX_VALUE;
		N = board.length;

		build(new Pos(0, 0, 0, 0), board);

		answer = costs[N - 1][N - 1];
		System.out.println(answer);
	}

	static void build(Pos before, int[][] board) {
		pq = new PriorityQueue<>();
		pq.offer(before);
		costs = new int[N][N];
		costs[0][0] = 0;
		visited = new boolean[N][N];
		visited[0][0] = true;

		for (int i = 0; i < N; i++) {
			Arrays.fill(costs[i], Integer.MAX_VALUE);
		}

		while (!pq.isEmpty()) {
			Pos temp = pq.poll();

			for (int k = 0; k < 4; k++) {
				next_i = temp.i + di[k];
				next_j = temp.j + dj[k];

				if (next_i < 0 || next_j < 0 || next_i >= N || next_j >= N)
					continue;

				if (costs[next_i][next_j] > temp.cost - 600 &&  board[next_i][next_j] == 0) {
					visited[next_i][next_j] = true;
					int cost = 100;
					if (temp.i == 0 && temp.j == 0) {
						costs[next_i][next_j] = Math.min(temp.cost + cost, costs[next_i][next_j]);
						pq.offer(new Pos(next_i, next_j, k, temp.cost + cost));
					} else {
						if (temp.dist != k) {
							cost += 500;
						}

						if (next_i == N - 1 && next_j == N - 1) {
							costs[next_i][next_j] = Math.min(temp.cost + cost, costs[next_i][next_j]);
						}

						costs[next_i][next_j] = Math.min(temp.cost + cost, costs[next_i][next_j]);
						pq.offer(new Pos(next_i, next_j, k, temp.cost + cost));
					}
				}
			}
		}
	}

	static class Pos implements Comparable<Pos> {
		int i, j, dist, cost;

		public Pos(int i, int j, int dist, int cost) {
			super();
			this.i = i;
			this.j = j;
			this.dist = dist;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pos o) {
			return this.cost - o.cost;
		}
	}
}