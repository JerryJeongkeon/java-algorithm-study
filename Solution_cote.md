## 🚩 코테 문제풀이



# :cloud: 라인 코딩테스트



### :lock: ​Q. 문자 메시지 전송 문제



> 
> 
>/*
> 문자 메세지 전송 문제
> 
> 문자 메세지의 총 갯수 a
> 문자 메세지를 처리할 수 있는 기계수 b
> 
> 각 문자를 처리하는데 걸리는 시간을 배열로 주어짐
> 전체 문자를 처리하는데 걸리는 시간 출력
> 
> 
>
> 
>메세지의 총 갯수가 크지 않아 pq로 처리했음
>  */
>
> 
> 
>### 입력 형식
> 
> - input
>   5 3
>  1 2 3 4 5
> 
>
> 
> ### 출력 형식
>
> output
>7
> 
> 



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1 {
	static int MessageNum = 5;
	static int MachineNum = 3;
	static int[] jobs;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < MachineNum; i++) {
			pq.offer(0);
		}

		for (int i = 0; i < MessageNum; i++) {
			int message = Integer.parseInt(st.nextToken());
			int time = pq.poll();
			pq.add(time + message);
		}

		int max = 0;
		for (int i = 0; i < MachineNum; i++) {
			max = pq.poll();
		}

		System.out.println(max);
	}
}
```









### :lock: ​Q. 도서관 문제



> 
>
> /*
> 도서관 문제였던거 같음
> 총 출입 인원의 수와 각 인원들이 들어온시간, 나간시간을 알려줌
> 각 인원이 들어왔을때 도서관에 사람이 있던 경우가 몇번이였는지 세는 문제였음
>  */
>
> 
>
> ### 입력 형식
>
> - input
>
>   5
>   5 9
>   1 3
>   4 6
>   8 12
>   8 9
>
> 
>
> ### 출력 형식
>
> output
> 3
>
> 



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		
		Time[] times = new Time[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(st.nextToken().trim());
			int out = Integer.parseInt(st.nextToken().trim());
			times[i] = new Time(in, out);
		}
		
		Arrays.sort(times);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(0);
		
		int count = 0;
		int max = 0;
		for(Time time : times) {
			if(max >= time.in) {
				count++;
			}
			if(time.out > max)
				max = time.out;
		}
		
		System.out.println("count : " + count);
	}

	static class Time implements Comparable<Time> {
		int in;
		int out;

		public Time(int in, int out) {
			this.in = in;
			this.out = out;
		}

		@Override
		public int compareTo(Time o) {
			int ret = this.in - o.in;
			if (ret == 0) {
				ret = this.out - o.out;
			}
			return ret;
		}
	}
}

```







### :lock: ​Q. 지하철 문제



> 
>
> /*
> 지하철 문제였음
> 지하철 좌석의 총 수가 주어지고 각 자리에 사람이 있는지 없는지 알려주면
> 좌우에 사람이 가장 멀리 있도록 앉는 경우가 얼마인지 계산하는 문제
> 자리에 사람이 있으면 1, 없으면 0으로 표시
>  */
>
> 
>
> ### 입력 형식
>
> - input
>
>   7
>   0 1 0 0 0 1 1
>
>   
>
> - 7
>   0 1 0 1 0 1 0
>
>   
>
> - 7
>   0 0 0 0 0 0 1
>

> ### 출력 형식
>
> output
> 2
>
> 1
>
> 5
>
> 



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());
		st = new StringTokenizer(br.readLine(), " ");

		boolean[] used = new boolean[N];
		int cnt = 0;
		int max = 0;
		int zero = 0;
		
		for (int i = 0; i < used.length; i++) {
			int state = Integer.parseInt(st.nextToken());
			if(state == 1)
				used[i] = true;
			else
				zero++;
		}
		
		for (int i = 0; i < used.length; i++) {
			if (used[i]) {
				cnt = 0;
			} else
				cnt++;
			
			if (cnt > max)
				max = cnt;
		}
		
		if(max == 1 && zero > 1)
			max = 2;
		System.out.println(max - 1);
	}
}

```







