package programmers_Lv3;

public class 입국심사 {
	static int n = 6;
	static int[] times = {7, 10};
	
	public static void main(String[] args) {
		long answer = Long.MAX_VALUE;
		long max = 0;
		for(int time : times) {
			if(max < time)
				max = time;
		}
		max *= n;
		long start = 0;
		long mid, sum;
		
		while(start <= max) {
			mid = (start + max) / 2;
			sum = 0;
			
			for(int time : times) {
				sum += mid / time;
			}
			
			if(sum >= n) {
				if(answer > mid)
					answer = mid;
				max = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println("answer : " + answer);

	}
}
