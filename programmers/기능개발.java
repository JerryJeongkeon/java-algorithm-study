package programmers;

import java.util.Arrays;

public class 기능개발 {

	// 작업이 완성되는 데까지 걸리는 시간을 구한다.
	// 첫 번째 배포부터 이전에 완성된 기능들을 같이 배포한다.
	// 같이 배포된 것들은 모두 -1로 바꾸어준다.
	
	static int[] progresses = {93, 30, 55, 100};
	static int[] speeds = {1, 30, 5, 1};
	
	public static void main(String[] args) {
		int dayCnt = 0;
		int N = progresses.length;
		int[] workDay = new int[N];
		int[] day = new int[101];
		Arrays.fill(day, -1);
		
		for (int n = 0; n < N; n++) {
			if((100 - progresses[n]) % speeds[n] == 0) {
				workDay[n] = (100 - progresses[n]) / speeds[n];
			} else
				workDay[n] = (100 - progresses[n]) / speeds[n] + 1;
			day[workDay[n]]++;
		}
		
		for (int i = 0; i < 100; i++) {
			System.out.println(day[i]);
			if(day[i] != 0)
				dayCnt++;
		}
		
		
	}
}
