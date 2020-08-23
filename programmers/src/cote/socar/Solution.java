package socar;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static String[] bakery_schedule = { "12:00 10" };
	static String current_time = "12:00";
	static int K = 11;
	static int result, tempTime, tempMinute, tempStock;
	static PriorityQueue<Bakery> bakeryQueue;
	static String temp;

	public static void main(String[] args) {
		bakeryQueue = new PriorityQueue<>();

		for (int i = 0; i < bakery_schedule.length; i++) {
			StringTokenizer st = new StringTokenizer(bakery_schedule[i], " ");
			temp = st.nextToken();
			tempTime = Integer.parseInt(temp.substring(0, 2));
			tempMinute = Integer.parseInt(temp.substring(3, 5));

			tempStock = Integer.parseInt(st.nextToken());

			bakeryQueue.offer(new Bakery(tempTime, tempMinute, tempStock));
		}

		int currentTime = Integer.parseInt(current_time.substring(0, 2));
		int currentMinute = Integer.parseInt(current_time.substring(3, 5));

		while (!bakeryQueue.isEmpty()) {
			Bakery currentBakery = bakeryQueue.poll();

			if (currentBakery.time < currentTime)
				continue;
			else if (currentBakery.time == currentTime && currentBakery.minute < currentMinute)
				continue;

			if (K <= currentBakery.stock) {
				result = 60 * (currentBakery.time - currentTime);
				if (currentBakery.minute >= currentMinute)
					result += currentBakery.minute - currentMinute;
				else {
					result += ((currentBakery.minute - currentMinute) - 60);
				}
				K -= currentBakery.stock;
				break;
			} else if (K > currentBakery.stock) {
				K -= currentBakery.stock;
			}
		}

		if (K > 0)
			result = -1;

		System.out.println("result : " + result);
	}

	static class Bakery implements Comparable<Bakery> {
		int time;
		int minute;
		int stock;

		public Bakery(int time, int minute, int stock) {
			this.time = time;
			this.minute = minute;
			this.stock = stock;
		}

		@Override
		public int compareTo(Bakery o) {
			if (this.time == o.time)
				return this.minute - o.minute;
			return this.time - o.time;
		}
	}
}
