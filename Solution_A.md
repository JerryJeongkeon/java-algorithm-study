## 🚩 자바 알고리즘 풀이

삼성 SW 역량테스트 A 취득을 위한 알고리즘 문제풀이 정리 파일입니다.



### :lock: ​Q. N과 M1

출처 :  https://www.acmicpc.net/problem/15649



> # N과 M (1)
> 
>| 시간 제한 | 메모리 제한 | 제출  | 정답 | 맞은 사람 | 정답 비율 |
> | :-------- | :---------- | :---- | :--- | :-------- | :-------- |
> | 1 초      | 512 MB      | 14840 | 9014 | 6168      | 61.112%   |
> 
> 
> 
> ## 문제
> 
> 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
> 
>- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열



> ## 입력
> 
>첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)



> ## 출력
> 
>한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
> 
> 수열은 사전 순으로 증가하는 순서로 출력해야 한다.



> ## 예제 입력 1 복사
> 
>```
> 3 1
> ```



> ## 예제 출력 1 복사
> 
>```
> 1
> 2
> 3
> ```



> ## 예제 입력 2 복사
> 
>```
> 4 2
> ```



> ## 예제 출력 2 복사
> 
>```
> 1 2
> 1 3
> 1 4
> 2 1
> 2 3
> 2 4
> 3 1
> 3 2
> 3 4
>4 1
> 4 2
>4 3
> ```



> ## 예제 입력 3 복사
> 
>```
> 4 4
> ```



> ## 예제 출력 3 복사
> 
>```
> 1 2 3 4
> 1 2 4 3
> 1 3 2 4
> 1 3 4 2
> 1 4 2 3
> 1 4 3 2
> 2 1 3 4
> 2 1 4 3
> 2 3 1 4
>2 3 4 1
> 2 4 1 3
>2 4 3 1
> 3 1 2 4
>3 1 4 2
> 3 2 1 4
> 3 2 4 1
>3 4 1 2
> 3 4 2 1
> 4 1 2 3
> 4 1 3 2
>4 2 1 3
> 4 2 3 1
>4 3 1 2
> 4 3 2 1
> ```







```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int N, M;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		used = new boolean[N + 1];
		sb = new StringBuilder();
		
		solve(0, "");
		System.out.println(sb.toString());
	}
	
	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				solve(cnt + 1, str + i + " ");
				used[i] = false;
			}
		}
	}
}
```



boolean형 배열 arr를 만들어서 현재 사용했는지 여부를 체크해주었습니다.



solve 메소드를 사용하여 M개를 뽑을 때까지 조건을 반복해주었습니다.



1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열을 뽑아야 하므로



for문으로 1부터 N까지 반복하면서 현재 뽑히지 않았다면 뽑아보고,



뽑은 뒤에는 뽑히지 않은 경우를 위해 used[i]를 false 처리해주고 종료해주었습니다.







### :lock: ​Q. N과 M3

출처 :  https://www.acmicpc.net/problem/15651



# N과 M (3) 

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 9449 | 6196 | 4915      | 66.617%   |



## 문제

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.



- 1부터 N까지 자연수 중에서 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.



## 입력

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)



## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.



## 예제 입력 1 복사

```
3 1
```



## 예제 출력 1 복사

```
1
2
3
```



## 예제 입력 2 복사

```
4 2
```



## 예제 출력 2 복사

```
1 1
1 2
1 3
1 4
2 1
2 2
2 3
2 4
3 1
3 2
3 3
3 4
4 1
4 2
4 3
4 4
```



## 예제 입력 3 복사

```
3 3
```



## 예제 출력 3 복사

```
1 1 1
1 1 2
1 1 3
1 2 1
1 2 2
1 2 3
1 3 1
1 3 2
1 3 3
2 1 1
2 1 2
2 1 3
2 2 1
2 2 2
2 2 3
2 3 1
2 3 2
2 3 3
3 1 1
3 1 2
3 1 3
3 2 1
3 2 2
3 2 3
3 3 1
3 3 2
3 3 3
```



```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {
	static int N, M;
	static StringTokenizer st;
	static boolean[] used;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		used = new boolean[N + 1];
		solve(0, "");

		System.out.println(sb.toString());
	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				solve(cnt + 1, str + i + " ");
			}
		}
	}
}
```



이전 문제 (N과 M2)와는 다르게 같은 숫자를 여러 번 골라도 되는 경우입니다.



따라서 solve 함수 내에서 선택해야 하는 갯수를 카운팅하기 위해 cnt 변수와



숫자들을 덧붙일 문자열 str 두 매개변수만 사용하였습니다.



1부터 N까지 현재 str에 i번째 요소를 덧붙여보면서 출력해주었습니다.



중복이 허용되는 경우이기 때문에 이전처럼 boolean 배열을 이용한 중복처리는 하지 않았습니다.



