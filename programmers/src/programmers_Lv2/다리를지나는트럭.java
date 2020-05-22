package programmers_Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	static int bridge_length = 100;
	static int weight = 100;
	static int[] truck_weight = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };

	public static void main(String[] args) {
		int Time = 0;

		Queue<truck> waitingqueue = new LinkedList<>();
		Queue<truck> runningQueue = new LinkedList<>();

		for (int i = 0; i < truck_weight.length; i++) {
			waitingqueue.add(new truck(truck_weight[i], 0));
		}

		int currWeight = 0;
		while (!waitingqueue.isEmpty()) {
			if (!runningQueue.isEmpty() && runningQueue.peek().in + bridge_length == Time)
				currWeight -= runningQueue.peek().weight;

			if (currWeight + waitingqueue.peek().weight <= weight) {
				waitingqueue.peek().in = Time;
				currWeight += waitingqueue.peek().weight;
				runningQueue.add(waitingqueue.poll());
			}

			if (runningQueue.peek().in + bridge_length == Time) {
				runningQueue.poll();
			}

			Time++;
		}

		while (!runningQueue.isEmpty()) {
			if(runningQueue.size() == 1)
				Time = runningQueue.poll().in + bridge_length;
			else
				runningQueue.poll();
		}

		System.out.println(Time + 1);
	}

	static class truck {
		int weight;
		int in;

		public truck(int w, int i) {
			this.weight = w;
			this.in = i;
		}
	}
}