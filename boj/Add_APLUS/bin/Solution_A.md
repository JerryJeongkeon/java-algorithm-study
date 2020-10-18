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







### :lock: ​Q. N과 M4

출처 :  https://www.acmicpc.net/problem/15652



# N과 M (4)

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 6845 | 5669 | 4711      | 83.101%   |



## 문제

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.



- 1부터 N까지 자연수 중에서 M개를 고른 수열

- 같은 수를 여러 번 골라도 된다.

- 고른 수열은 비내림차순이어야 한다.

  - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

  

## 입력

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)



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
2 2
2 3
2 4
3 3
3 4
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
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
```





```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15652_N과M4 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		solve(1, 0, "");

		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			solve(i, cnt + 1, str + i + " ");
		}
	}
}

```



중복이 허용되는 조합의 경우의 수를 찾는 문제입니다.



오름차순으로 출력해주어야 하기 때문에 현재의 값 (idx) 부터 N 까지 for문을 사용하였습니다.



문제의 조건에서 주어진 비내림차순을 성립시키기 위해 i값을 idx로 넣어준 뒤 진행시켜



비내림차순의 수열을 찾아낼 수 있었습니다.







### :lock: ​Q. N과 M5

출처 :  https://www.acmicpc.net/problem/15654



# N과 M (5)

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 4916 | 3688 | 2984      | 75.107%   |



## 문제

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.

- N개의 자연수 중에서 M개를 고른 수열



## 입력

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.



## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.



## 예제 입력 1 복사

```
3 1
4 5 2
```



## 예제 출력 1 복사

```
2
4
5
```



## 예제 입력 2 복사

```
4 2
9 8 7 1
```



## 예제 출력 2 복사

```
1 7
1 8
1 9
7 1
7 8
7 9
8 1
8 7
8 9
9 1
9 7
9 8
```



## 예제 입력 3 복사

```
4 4
1231 1232 1233 1234
```



## 예제 출력 3 복사

```
1231 1232 1233 1234
1231 1232 1234 1233
1231 1233 1232 1234
1231 1233 1234 1232
1231 1234 1232 1233
1231 1234 1233 1232
1232 1231 1233 1234
1232 1231 1234 1233
1232 1233 1231 1234
1232 1233 1234 1231
1232 1234 1231 1233
1232 1234 1233 1231
1233 1231 1232 1234
1233 1231 1234 1232
1233 1232 1231 1234
1233 1232 1234 1231
1233 1234 1231 1232
1233 1234 1232 1231
1234 1231 1232 1233
1234 1231 1233 1232
1234 1232 1231 1233
1234 1232 1233 1231
1234 1233 1231 1232
1234 1233 1232 1231
```





```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		used = new boolean[N + 1];

		st = new StringTokenizer(br.readLine().trim(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(1, 0, "");

		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			if (idx > N)
				return;

			for (int i = 1; i <= N; i++) {
				if (!used[i]) {
					used[i] = true;
					solve(idx + 1, cnt + 1, str + arr[i] + " ");
					used[i] = false;
				}
			}
		}
	}
}
```



이 문제에서부터는 입력으로 주어지는 정수들을 저장할 배열 arr를 선언해주었습니다.



수열을 찾아주기 전에 Arrays.sort를 이용하여 정렬한 뒤 탐색하였습니다.



중복된 요소가 사용된 조합은 불가능하므로 used배열을 이용하여 체크해주었습니다.



for문을 1부터 N까지 반복하여 가능한 모든 수열을 찾아주었습니다.







### :lock: ​Q. N과 M6

출처 :  https://www.acmicpc.net/problem/15655



# N과 M (6)

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 3814 | 3287 | 2728      | 86.658%   |



## 문제

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.



- N개의 자연수 중에서 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다.



## 입력

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.



## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.



## 예제 입력 1 복사

```
3 1
4 5 2
```



## 예제 출력 1 복사

```
2
4
5
```



## 예제 입력 2 복사

```
4 2
9 8 7 1
```



## 예제 출력 2 복사

```
1 7
1 8
1 9
7 8
7 9
8 9
```



## 예제 입력 3 복사

```
4 4
1231 1232 1233 1234
```



## 예제 출력 3 복사

```
1231 1232 1233 1234
```





```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N과M6 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		used = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(1, 0, "");

		System.out.println(sb.toString());

	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str + "\n");
			return;
		} else {
			if (idx > N)
				return;

			for (int i = idx; i <= N; i++) {
				used[i] = true;
				solve(i + 1, cnt + 1, str + arr[i] + " ");
				used[i] = false;
			}
		}
	}
}
```



문제의 조건으로 고른 수열은 오름차순이어야 하고



중복된 조합이 발생하지 않아야 합니다.



오름차순으로 출력해주기 위해 Arrays.sort 를 사용하여 정렬해준 뒤 탐색하였습니다.



이후 used배열을 사용하여 중복을 제거해주었고



다음번 함수를 실행시킬 때 idx의 값으로 i+1을 인자로 넘겨 연속으로 등장하는 중복값을 제거해주었습니다.







### :lock: ​Q. N과 M7

출처 :  https://www.acmicpc.net/problem/15656



# N과 M (7)

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 4069 | 3164 | 2584      | 79.410%   |



## 문제

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.



- N개의 자연수 중에서 M개를 고른 수열
- 같은 수를 여러 번 골라도 된다.



## 입력

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.



## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.



## 예제 입력 1 복사

```
3 1
4 5 2
```



## 예제 출력 1 복사

```
2
4
5
```



## 예제 입력 2 복사

```
4 2
9 8 7 1
```



## 예제 출력 2 복사

```
1 1
1 7
1 8
1 9
7 1
7 7
7 8
7 9
8 1
8 7
8 8
8 9
9 1
9 7
9 8
9 9
```



## 예제 입력 3 복사

```
3 3
1231 1232 1233
```



## 예제 출력 3 복사

```
1231 1231 1231
1231 1231 1232
1231 1231 1233
1231 1232 1231
1231 1232 1232
1231 1232 1233
1231 1233 1231
1231 1233 1232
1231 1233 1233
1232 1231 1231
1232 1231 1232
1232 1231 1233
1232 1232 1231
1232 1232 1232
1232 1232 1233
1232 1233 1231
1232 1233 1232
1232 1233 1233
1233 1231 1231
1233 1231 1232
1233 1231 1233
1233 1232 1231
1233 1232 1232
1233 1232 1233
1233 1233 1231
1233 1233 1232
1233 1233 1233
```





```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N과M7 {
	static int N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[] arr;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[N + 1];
		used = new boolean[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		solve(0, "");

		System.out.println(sb.toString());

	}

	static void solve(int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				used[i] = true;
				solve(cnt + 1, str + arr[i] + " ");
				used[i] = false;
			}
		}
	}
}

```



이 문제에서는 이전 문제와 달리 같은 수가 중복된 경우도 포함해야 합니다.



따라서 마지막 숫자가 가장 앞에 올 수 있기 때문에 이전 문제에서 사용해주었던



매개변수 idx를 삭제해주었고 if(idx > N) return; 조건 역시 삭제해주었습니다.



for문에서 1부터 N까지의 arr[i]를 모두 탐색하기 때문에 중복된 경우까지 모두 찾아주었습니다.







### :lock: ​Q. N과 M8

출처 :  https://www.acmicpc.net/problem/15657



# N과 M (8)

| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞은 사람 | 정답 비율 |
| :-------- | :---------- | :--- | :--- | :-------- | :-------- |
| 1 초      | 512 MB      | 3460 | 3014 | 2566      | 87.309%   |



## 문제

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.



- N개의 자연수 중에서 M개를 고른 수열

- 같은 수를 여러 번 골라도 된다.

- 고른 수열은 비내림차순이어야 한다.

  - 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.

  

## 입력

첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.



## 출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.



## 예제 입력 1 복사

```
3 1
4 5 2
```



## 예제 출력 1 복사

```
2
4
5
```



## 예제 입력 2 복사

```
4 2
9 8 7 1
```



## 예제 출력 2 복사

```
1 1
1 7
1 8
1 9
7 7
7 8
7 9
8 8
8 9
9 9
```



## 예제 입력 3 복사

```
4 4
1231 1232 1233 1234
```



## 예제 출력 3 복사

```
1231 1231 1231 1231
1231 1231 1231 1232
1231 1231 1231 1233
1231 1231 1231 1234
1231 1231 1232 1232
1231 1231 1232 1233
1231 1231 1232 1234
1231 1231 1233 1233
1231 1231 1233 1234
1231 1231 1234 1234
1231 1232 1232 1232
1231 1232 1232 1233
1231 1232 1232 1234
1231 1232 1233 1233
1231 1232 1233 1234
1231 1232 1234 1234
1231 1233 1233 1233
1231 1233 1233 1234
1231 1233 1234 1234
1231 1234 1234 1234
1232 1232 1232 1232
1232 1232 1232 1233
1232 1232 1232 1234
1232 1232 1233 1233
1232 1232 1233 1234
1232 1232 1234 1234
1232 1233 1233 1233
1232 1233 1233 1234
1232 1233 1234 1234
1232 1234 1234 1234
1233 1233 1233 1233
1233 1233 1233 1234
1233 1233 1234 1234
1233 1234 1234 1234
1234 1234 1234 1234
```





```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {
	static int N, M;
	static int[] arr;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		solve(1, 0, "");
		System.out.println(sb.toString());
	}

	static void solve(int idx, int cnt, String str) {
		if (cnt == M) {
			sb.append(str.trim() + "\n");
			return;
		} else {
			for (int i = idx; i <= N; i++) {
				solve(i, cnt + 1, str + arr[i] + " ");
			}
		}
	}

}

```





이 문제에서는 같은 수를 뽑아도 되지만, 고른 수열이 비내림차순을 이루어야 합니다.



이 조건을 만족시키기 위해서 우선 arr배열을 정렬해준 뒤 다음번 solve를 호출할 때 idx값으로 i를 넘깁니다.



for문을 i부터 N까지 반복하면 이전 뽑힌 수와 같거나 큰 수를 뽑을 수 있게 됩니다.





