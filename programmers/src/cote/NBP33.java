import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class NBP33 {
	static int[] p = { 103, 101, 103, 103, 101, 102, 100, 100, 101, 104 };

	public static void main(String[] args) {
		int answer = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < p.length; i++) {
			if (hm.containsKey(p[i])) {
				hm.put(p[i], hm.get(p[i]) + 1);
			} else {
				hm.put(p[i], 1);
			}
		}
		
		Iterator<Integer> iter = hm.keySet().iterator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int sum = 0;
		int pivot = 0;
		
		while (iter.hasNext()) {
			int k = iter.next();
			pq.add(hm.get(k));
		}
		
		while (!pq.isEmpty()) {
			int temp = pq.poll();
			answer = answer + (temp - pivot) * pq.size();
			pivot = temp;
		}
		
		System.out.println("answer : " + answer);
	}
}
