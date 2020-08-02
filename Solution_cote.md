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





# :cloud: 토스 코테

```java
package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		boolean flag = true;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '1') {
				if (input.charAt(i + 1) == '1') {
					flag = false;
					break;
				}
			}
		}

		if (input.charAt(input.length() - 1) == '1')
			flag = false;
		System.out.println(flag);
	}
}

```


<hr/>



```java
package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		boolean[] duplicateCheckArray = new boolean[46];
		boolean flag = true;
		int numCount = 0;
		int maxValue = 0;

		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			numCount++;

			if (num > 45 || num < maxValue) {
				flag = false;
				break;
			}

			if (duplicateCheckArray[num]) {
				flag = false;
				break;
			} else {
				duplicateCheckArray[num] = true;
			}
			maxValue = num;
		}

		if (numCount != 6)
			flag = false;

		System.out.println(flag);
	}
}
```



<hr/>



```java
package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> checkHashMap = new HashMap<>();
		int returnValue = 0;

		while (st.hasMoreTokens()) {
			int inputNum = Integer.parseInt(st.nextToken());

			if (checkHashMap.containsKey(inputNum)) {
				sb.append(checkHashMap.get(inputNum));
				sb.append(" ");
			} else {
				returnValue = compute(inputNum);
				checkHashMap.put(inputNum, returnValue);
				sb.append(returnValue);
				sb.append(" ");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	static int compute(int n) {
		return n * 2;
	}
}
```



<hr/>



```java
package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main4 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Map<String, Integer> payHashMap = new HashMap<>();

		String payment = "";
		int index = 0;

		while (st.hasMoreTokens()) {
			payment = st.nextToken();
			index++;

			// TreeMap에 추가
			payHashMap.put(payment, index);
			sb = new StringBuilder();

			if (payHashMap.containsKey(payment)) {
				payHashMap.replace(payment, index);
			}

			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(payHashMap.entrySet());

			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> payment1, Entry<String, Integer> payment2) {
					return payment2.getValue().compareTo(payment1.getValue());
				}
			});

			while (list_entries.size() > 5) {
				list_entries.remove(list_entries.size() - 1);
			}

			for (Entry<String, Integer> entry : list_entries) {
				sb.append(entry.getKey() + " ");
			}

			bw.write(sb.toString().trim());
			if (st.hasMoreTokens())
				bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
```



<hr/>



```java
package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		long kim, lee, money, debt = 0L;

		while (st.hasMoreTokens()) {
			kim = Integer.parseInt(st.nextToken());
			lee = Integer.parseInt(st2.nextToken());

			if (kim > lee) {
				money = kim - lee;

				if (money > debt) {
					money -= debt;
					debt = 0;
					sb.append(money + " ");
				} else {
					debt -= money;
					sb.append("0 ");
				}
			} else {
				debt += lee - kim;
				sb.append("0 ");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
```



<hr/>



```java
package toss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6 {
	static String input = "1 1 0 0;1 0 0 0;0 0 0 1;0 0 1 1";
	static int row, col, answer, next_i, next_j;
	static int[][] arr;
	static String inputStr = "";
	static boolean[][] checked;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		row = 1;
		col = 0;

		// 가로 세로 길이 구하기
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ';') {
				row++;
			} else if (input.charAt(i) == '0' || input.charAt(i) == '1') {
				col++;
			}
		}

		col /= row;
		arr = new int[row][col];
		StringTokenizer st = new StringTokenizer(input, ";");
		int rowIndex = 0;

		// arr에 input Data 모양 배열 만들기
		while (st.hasMoreTokens()) {
			StringTokenizer inputStr = new StringTokenizer(st.nextToken(), " ");
			for (int i = 0; i < col; i++) {
				arr[rowIndex][i] = Integer.parseInt(inputStr.nextToken());
			}
			rowIndex++;
		}

		// bfs로 방문하며 주변 둘레 구하기
		checked = new boolean[row][col];
		answer = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0 && !checked[i][j]) {
					bfs(new Pos(i, j));
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("answer : " + answer);

	}

	// 연결된 지점들을 방문하며 둘레 길이 찾기
	// bfs를 시작할 때마다 방문 여부를 체크하는 배열 새로 만들기 (중복되는 위치의 둘레도 체크해야 함)
	static void bfs(Pos pos) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(pos);
		checked[pos.i][pos.j] = true;

		while (!q.isEmpty()) {
			Pos temp = q.poll();

			for (int k = 0; k < 4; k++) {
				next_i = temp.i + di[k];
				next_j = temp.j + dj[k];

				if (next_i < 0 || next_i >= row || next_j < 0 || next_j >= col)
					continue;

				if (arr[next_i][next_j] == 1) {
					answer++;
				} else if (arr[next_i][next_j] == 0 && !checked[next_i][next_j]) {
					checked[next_i][next_j] = true;
					q.offer(new Pos(next_i, next_j));
				}
			}
		} // end while
	}

	static class Pos {
		int i;
		int j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

	}
}
```



<hr/>

