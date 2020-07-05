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
		
		// Count한 갯수 pq에 담기
		while (iter.hasNext()) {
			int k = iter.next();
			pq.add(hm.get(k));
		}
		
		// Count값으로 answer 계산
		// 시작 1, 1, 2, 3, 3 (4)
		while (!pq.isEmpty()) {
			int temp = pq.poll();
			// 1 2 2 (2) / 1 1 (1)
			// answer = 0 + (1 - 0) * 4
			answer = answer + (temp - pivot) * pq.size();
			// pivot = 1
			pivot = temp;
			
			// 1, 2, 3, 3 남아있고 / answer = 4 / pivot = 1
		}
		
		System.out.println("answer : " + answer);
	}
}
