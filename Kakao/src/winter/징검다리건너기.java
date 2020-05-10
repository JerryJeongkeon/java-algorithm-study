package winter;

public class 징검다리건너기 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
		System.out.println(solution(stones, k));
	}

	static public int solution(int[] stones, int k) {
		int answer = 0;
		int max = 0;
		for (int i = 0; i < stones.length; i++) {
			max = Math.max(stones[i], max);
		}
		answer = search(stones, k, 1, max);
		return answer;
	}

	static public int search(int[] stones, int k, int start, int end) {
		// 종료조건
		if (start >= end) {
			return start;
		}
		
		// 중간값
		int num = (start + end) / 2;
		int count = 0;
		boolean flag = false;
		
		for (int i = 0; i < stones.length; i++) {
			if (num >= stones[i]) {
				count++;
				if (count == k) {
					flag = true;
					break;
				}
			} else {
				count = 0;
			}
		}
		if (flag) {
			return search(stones, k, start, num);
		} else {
			return search(stones, k, num + 1, end);
		}

	}

}
