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









### 
