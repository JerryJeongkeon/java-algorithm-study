import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NBP3 {
	static int[] p = {1};
	
	public static void main(String[] args) {
		int answer = 0;

		List<Integer> tempList = new ArrayList<>();
		for(int i = 0; i < p.length; i++) {
			tempList.add(p[i]);
		}
		
		PriorityQueue<Integer> temp1 = new PriorityQueue<>();
		PriorityQueue<Integer> temp2 = new PriorityQueue<>();
		
		while(tempList.size() > 0) {
			for(int i = 0; i < tempList.size(); i++) {
				if(!temp1.contains(tempList.get(i)))
					temp1.offer(tempList.get(i));
				else
					temp2.offer(tempList.get(i));
			}
			
			answer += temp1.size() - 1;
			tempList.clear();
			tempList.addAll(temp2);
			temp1.clear();
			temp2.clear();
		}
		if(answer == 0)
			System.out.println("1");

		System.out.println("answer : " + answer);
	}
}
