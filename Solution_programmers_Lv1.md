

## 🚩 자바 알고리즘 풀이

자바 언어를 이용한 알고리즘 문제풀이 해설입니다.



### :lock: ​Q. 다트게임

출처 :  https://programmers.co.kr/learn/courses/30/lessons/17682



> 카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
> 갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
>
> 1. 다트 게임은 총 3번의 기회로 구성된다.
> 2. 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
> 3. 점수와 함께 Single(`S`), Double(`D`), Triple(`T`) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
> 4. 옵션으로 스타상(`*`) , 아차상(`#`)이 존재하며 스타상(`*`) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(`#`) 당첨 시 해당 점수는 마이너스된다.
> 5. 스타상(`*`)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(`*`)의 점수만 2배가 된다. (예제 4번 참고)
> 6. 스타상(`*`)의 효과는 다른 스타상(`*`)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(`*`) 점수는 4배가 된다. (예제 4번 참고)
> 7. 스타상(`*`)의 효과는 아차상(`#`)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(`#`)의 점수는 -2배가 된다. (예제 5번 참고)
> 8. Single(`S`), Double(`D`), Triple(`T`)은 점수마다 하나씩 존재한다.
> 9. 스타상(`*`), 아차상(`#`)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
>
> 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
>
> ### 입력 형식
>
> 점수|보너스|[옵션]으로 이루어진 문자열 3세트.
> 예) `1S2D*3T`
>
> - 점수는 0에서 10 사이의 정수이다.
> - 보너스는 S, D, T 중 하나이다.
> - 옵선은 *이나 # 중 하나이며, 없을 수도 있다.
>
> ### 출력 형식
>
> 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
> 예) 37
>
> ### 입출력 예제
>
> | 예제 | dartResult | answer | 설명                        |
> | ---- | ---------- | ------ | --------------------------- |
> | 1    | `1S2D*3T`  | 37     | 11 * 2 + 22 * 2 + 33        |
> | 2    | `1D2S#10S` | 9      | 12 + 21 * (-1) + 101        |
> | 3    | `1D2S0T`   | 3      | 12 + 21 + 03                |
> | 4    | `1S*2T*3S` | 23     | 11 * 2 * 2 + 23 * 2 + 31    |
> | 5    | `1D#2S*3S` | 5      | 12 * (-1) * 2 + 21 * 2 + 31 |
> | 6    | `1T2D3D#`  | -4     | 13 + 22 + 32 * (-1)         |
> | 7    | `1D2S3T*`  | 59     | 12 + 21 * 2 + 33 * 2        |



```java
class Solution {
  public int solution(String dartResult) {
		int[] score = new int[3];
		int answer = 0;
		int scoreIdx = 0;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);
			if (ch >= '0' && ch <= '9') {
				if (ch == '1') {
					if (dartResult.charAt(i + 1) == '0') {
						score[scoreIdx] = 10;
						i++;
						scoreIdx++;
						continue;
					}
					score[scoreIdx] = 1;
					scoreIdx++;
				} else {
					score[scoreIdx] = ch - '0';
					scoreIdx++;
				}
			} else if (ch == 'S' || ch == 'D' || ch == 'T') {
				if (ch == 'D') {
					score[scoreIdx - 1] *= score[scoreIdx - 1];
				} else if (ch == 'T') {
					score[scoreIdx - 1] *= score[scoreIdx - 1] * score[scoreIdx - 1];
				}
			} else if (ch == '*' || ch == '#') {
				if (ch == '*') {
					if (scoreIdx == 1) {
						score[0] *= 2;
						continue;
					}
					score[scoreIdx - 1] *= 2;
					score[scoreIdx - 2] *= 2;
				} else if (ch == '#') {
					score[scoreIdx - 1] *= -1;
				}
			}
		}
        answer = score[0] + score[1] + score[2];
        return answer;
  }
}
```



3개의 점수를 저장하는 score배열을 생성하고 현재 몇 번째 점수를 가르키고 있는지 위치를 알기 위해 scoreIdx 변수를 만들어주었습니다.



for문을 이용하여 입력으로 들어온 문자열을 한 자씩 돌면서 if else문을 이용하여

1. 'S', 'D', 'T'인 경우에 대해 작성해주었습니다.
2. '*', '#'인 경우도 따로 처리해주었습니다.
3. '0 ~ 9'인 경우 score[scoreIdx] 번째에 점수를 넣어주었습니다.

예외적으로 숫자가 1인 경우에 10점이 나올 수 있으므로 scoreIdx+1번째의 값이 0인 경우 10점을 넣어주고 아닌 경우에는 1점을 넣어주었습니다.



모두 계산한 뒤 answer에 score배열의 점수들을 모두 더해 출력해주었습니다.







### :lock: ​ Q. 실패율

출처 : https://programmers.co.kr/learn/courses/30/lessons/42889



슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.

- 실패율은 다음과 같이 정의한다.
  - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

##### 제한사항

- 스테이지의 개수 N은 `1` 이상 `500` 이하의 자연수이다.

- stages의 길이는 `1` 이상 `200,000` 이하이다.

- stages에는

   

  ```
  1
  ```

   

  이상

   

  ```
  N + 1
  ```

   

  이하의 자연수가 담겨있다.

  - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
  - 단, `N + 1` 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.

- 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.

- 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 `0` 으로 정의한다.

##### 입출력 예

| N    | stages                   | result      |
| ---- | ------------------------ | ----------- |
| 5    | [2, 1, 2, 6, 2, 4, 3, 3] | [3,4,2,1,5] |
| 4    | [4,4,4,4,4]              | [4,1,2,3]   |

##### 입출력 예 설명

입출력 예 #1
1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.

- 1 번 스테이지 실패율 : 1/8

2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.

- 2 번 스테이지 실패율 : 3/7

마찬가지로 나머지 스테이지의 실패율은 다음과 같다.

- 3 번 스테이지 실패율 : 2/4
- 4번 스테이지 실패율 : 1/2
- 5번 스테이지 실패율 : 0/1

각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

- [3,4,2,1,5]

입출력 예 #2

모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.

- [4,1,2,3]



```java
import java.util.PriorityQueue;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] result = new int[N];
		int[] countStageUsers = new int[N + 2];
		PriorityQueue<Stage> pq = new PriorityQueue<>();

		for (int i = 0; i < stages.length; i++) {
			countStageUsers[stages[i]]++;
		}

		int reach = stages.length;
		double failure = 0;

		for (int i = 1; i < N + 1; i++) {
			if (reach == 0) {
				failure = 0.0;
			} else
				failure = (double) countStageUsers[i] / reach;
			reach -= countStageUsers[i];

			pq.offer(new Stage(i, failure));
		}

		for (int i = 0; i < result.length; i++) {
			Stage temp = pq.poll();
			result[i] = temp.idx;
		}
        return result;
	}

	static class Stage implements Comparable<Stage> {
		int idx;
		double failure;

		public Stage(int index, double failure) {
			this.idx = index;
			this.failure = failure;
		}

		@Override
		public int compareTo(Stage stage) {
			if (stage.failure == this.failure) {
				return this.idx - stage.idx;
			}
			if (this.failure - stage.failure > 0)
				return -1;
			else
				return 1;
		}
	}
}
```



단계별 실패율을 구해주기 위해서 Stage 객체를 만들어주었습니다.

각각의 Stage 결과를 PriorityQueue에 실패율이 높은 순에서 낮은 순으로 정렬해주었습니다.



실패율을 구하기 위해 먼저 countStageUsers 배열에 해당 스테이지에 도달한 유저의 수를 저장하고, reach(해당 스테이지에 도달한 전체 유저의 수) 변수를 이용하였습니다.



이후 정답을 출력하는 answer 배열에 PriorityQueue에서 뽑아내어 순서대로 담아주었습니다.



PriorityQueue를 사용한 이유는 PriorityQueue의 경우 정렬 시 O(logN)의 시간복잡도를 가지며

삽입과 삭제 시 O(1)의 시간복잡도를 가지기 때문에 최대 Stage가 20만에 달하는 데이터들을 정렬하고 출력하기에 적합하다고 생각하였습니다.







### :lock: ​ Q. 비밀지도

출처 : https://programmers.co.kr/learn/courses/30/lessons/17681



## 비밀지도

네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

1. 지도는 한 변의 길이가 `n`인 정사각형 배열 형태로, 각 칸은 공백(" ) 또는벽(#") 두 종류로 이루어져 있다.
2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 지도 1과 지도 2라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
3. 지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 `1`, 공백 부분을 `0`으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.



![secret map](http://t1.kakaocdn.net/welcome2018/secret8.png)

네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.

### 입력 형식

입력으로 지도의 한 변 크기 `n` 과 2개의 정수 배열 `arr1`, `arr2`가 들어온다.

- 1 ≦ `n` ≦ 16
- `arr1`, `arr2`는 길이 `n`인 정수 배열로 주어진다.
- 정수 배열의 각 원소 `x`를 이진수로 변환했을 때의 길이는 `n` 이하이다. 즉, 0 ≦ `x` ≦ 2n - 1을 만족한다.

### 출력 형식

원래의 비밀지도를 해독하여 `'#'`, `공백`으로 구성된 문자열 배열로 출력하라.

### 입출력 예제

| 매개변수 | 값                                            |
| -------- | --------------------------------------------- |
| n        | 5                                             |
| arr1     | [9, 20, 28, 18, 11]                           |
| arr2     | [30, 1, 21, 17, 28]                           |
| 출력     | `["#####","# # #", "### #", "# ##", "#####"]` |

| 매개변수 | 값                                                           |
| -------- | ------------------------------------------------------------ |
| n        | 6                                                            |
| arr1     | [46, 33, 33 ,22, 31, 50]                                     |
| arr2     | [27 ,56, 19, 14, 14, 10]                                     |
| 출력     | `["######", "### #", "## ##", " #### ", " #####", "### # "]` |





```java
class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int[][] board1 = new int[n][n];
		int[][] board2 = new int[n][n];

		for (int i = 0; i < n; i++) {
			int num = arr1[i];
			String binaryNum = Integer.toBinaryString(num);
			for (int j = 0; j < binaryNum.length(); j++) {
				board1[i][n - j - 1] = binaryNum.charAt(binaryNum.length() - j - 1) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			int num = arr2[i];
			String binaryNum = Integer.toBinaryString(num);
			for (int j = 0; j < binaryNum.length(); j++) {
				board2[i][n - j - 1] = binaryNum.charAt(binaryNum.length() - j - 1) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			answer[i] = "";
			for (int j = 0; j < n; j++) {
				if(board1[i][j] == 1 || board2[i][j] == 1) {
					answer[i] += "#";
				} else
					answer[i] += " ";
			}
		}
		return answer;
  }
}
```



정수값의 데이터를 2진수로 변환하는게 가장 핵심이 되는 문제입니다.



JAVA에서 제공하는 Integer.toBinaryString() 함수를 사용하여 풀이하였습니다.



board라는 이름의 배열 2개를 만들어준 뒤, 

​	둘 중 하나라도 벽(1)인 곳에는 arr배열에 '#'을 넣어주고 아닌 경우에는 " " 공백을 넣어주었습니다.



마지막으로 StringBuilder()를 사용해도 되지만, 지도의 크기가 작아 String 변수에 문자를 덧붙여주었습니다.







### :lock: ​ Q. 예산

출처 : https://programmers.co.kr/learn/courses/30/lessons/12982



## 예산

###### 문제 설명

S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다. 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다. 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.

물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.

부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.

##### 제한사항

- d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
- d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
- budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.

------

##### 입출력 예

| d           | budget | result |
| ----------- | ------ | ------ |
| [1,3,2,5,4] | 9      | 3      |
| [2,2,3,3]   | 10     | 4      |

##### 입출력 예 설명

입출력 예 #1
각 부서에서 [1원, 3원, 2원, 5원, 4원]만큼의 금액을 신청했습니다. 만약에, 1원, 2원, 4원을 신청한 부서의 물품을 구매해주면 예산 9원에서 7원이 소비되어 2원이 남습니다. 항상 정확히 신청한 금액만큼 지원해 줘야 하므로 남은 2원으로 나머지 부서를 지원해 주지 않습니다. 위 방법 외에 3개 부서를 지원해 줄 방법들은 다음과 같습니다.

- 1원, 2원, 3원을 신청한 부서의 물품을 구매해주려면 6원이 필요합니다.
- 1원, 2원, 5원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
- 1원, 3원, 4원을 신청한 부서의 물품을 구매해주려면 8원이 필요합니다.
- 1원, 3원, 5원을 신청한 부서의 물품을 구매해주려면 9원이 필요합니다.

3개 부서보다 더 많은 부서의 물품을 구매해 줄 수는 없으므로 최대 3개 부서의 물품을 구매해 줄 수 있습니다.

입출력 예 #2
모든 부서의 물품을 구매해주면 10원이 됩니다. 따라서 최대 4개 부서의 물품을 구매해 줄 수 있습니다.





```java
import java.util.Arrays;

class Solution {
  public int solution(int[] d, int budget) {
      int answer = 0;
      Arrays.sort(d);
      
      int index = 0;
      
      while(budget >= d[index]){
          answer++;
          budget -= d[index];
          index++;
          
          if(index == d.length)
              break;
      }
      return answer;
  }
}
```



우선 예산을 필요로 하는 금액으로 d 배열을 정렬시켜주었습니다.

그 다음, 적은 예산을 필요로 하는 부서부터 하나씩 지원해줍니다. ( **budget 0- d[index]** )



예산에서 지원금을 빼주고, 마지막에 도달했을 경우에 종료시켜주기 위해

index 변수를 만들어주었습니다.









### :lock: ​ Q. 직사각형 별찍기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12969



## 직사각형 별찍기



###### 문제 설명

이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.

------

##### 제한 조건

- n과 m은 각각 1000 이하인 자연수입니다.

------

##### 예시

입력

```
5 3
```

출력

```java
*****
*****
*****
```



```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args)  throws IOException{		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

    }
}
```





아주 기초적인 문제입니다.



빠른 입출력을 위해 BufferedReader와 BufferedWriter를 이용했습니다.









### :lock: ​ Q. x만큼 간격이 있는 n개의 숫자

출처 : https://programmers.co.kr/learn/courses/30/lessons/12954



## x만큼 간격이 있는 n개의 숫자



###### 문제 설명

함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.



#### 제한 조건

- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.



#### 입출력 예

| x    | n    | answer       |
| ---- | ---- | ------------ |
| 2    | 5    | [2,4,6,8,10] |
| 4    | 3    | [4,8,12]     |
| -4   | 2    | [-4, -8]     |







```java
class Solution{
  public long[] solution(long x, int n) {
      long[] answer = new long[n];

		for (int i = 0; i < n; i++) {
			answer[i] = x * (i + 1);
		}
      
      return answer;
  }
}
```







아주 기초적인 문제입니다.



배열의 인덱스는 0번부터 시작하기 때문에,



조건을 answer[i] = x * (i + 1)로 주었습니다.







### :lock: ​ Q. 행렬의 덧셈

출처 : https://programmers.co.kr/learn/courses/30/lessons/12950



## 행렬의 덧셈



###### 문제 설명

행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.



##### 제한 조건

- 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.



##### 입출력 예

| arr1          | arr2          | return        |
| ------------- | ------------- | ------------- |
| [[1,2],[2,3]] | [[3,4],[5,6]] | [[4,6],[7,9]] |
| [[1],[2]]     | [[3],[4]]     | [[4],[6]]     |





```java
import java.util.Arrays;

class Solution {
  public int[][] solution(int[][] arr1, int[][] arr2) {
      int[][] answer = new int[arr1.length][];
      
      for (int i = 0; i < arr1.length; i++) {
		    answer = arr1.clone();
            for(int j = 0; j < arr1[i].length; j++){
            answer[i][j] += arr2[i][j];
          }
		}
      return answer;
  }
}
```





행과 열이 같은 두 개의 행렬의 덧셈 문제입니다.



행과 열이 같기 때문에 첫 번째 행렬(arr1) 에 두 번째 행렬(arr2)을 바로 더해주었습니다.



2중 for문을 이용하였습니다.









###   :lock:  Q. 핸드폰 번호 가리기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12948



## 핸드폰 번호 가리기



###### 문제 설명

프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 `*`으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.



##### 제한 조건

- s는 길이 4 이상, 20이하인 문자열입니다.



##### 입출력 예

| phone_number | return      |
| ------------ | ----------- |
| 01033334444  | *******4444 |
| 027778888    | *****8888   |





```java
class Solution {
  public String solution(String phone_number) {
      String answer = "";  
      StringBuilder sb = new StringBuilder();
      int length = phone_number.length();
      
		for (int i = 0; i < length - 4; i++) {
			sb.append('*');
		}
		for (int i = length - 4; i < phone_number.length(); i++) {
			sb.append(phone_number.charAt(i));
		}
      
        answer = sb.toString();
      
      return answer;
  }
}
```





phone_number의 길이를 알아내기 위해 int형 변수 length에 길이를 저장해두었습니다.



빠른 문자열 처리를 위해 StringBuilder를 사용하였습니다.



for문으로 0 ~ (length - 4)번째 까지는 '*'을 sb에 append 해주고



이후 마지막 4자리에는 실제 phone_number의 적혀 있는 숫자를 적어주었습니다.









###  :lock:  Q. 하샤드 수

출처 : https://programmers.co.kr/learn/courses/30/lessons/12947



## 하샤드 수





###### 문제 설명

양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.



##### 제한 조건

- `x`는 1 이상, 10000 이하인 정수입니다.



##### 입출력 예

| arr  | return |
| ---- | :----: |
| 10   |  true  |
| 12   |  true  |
| 11   | false  |
| 13   | false  |



##### 입출력 예 설명



**입출력 예 #1**
10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.

**입출력 예 #2**
12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.

**입출력 예 #3**
11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.

**입출력 예 #4**
13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.





```java
import java.io.IOException;
class Solution {
  public boolean solution (int x) throws IOException {
		int sum = 0;
		int a = x;
      
		while (a >= 1) {
			sum += a % 10;
			a /= 10;
		}

		if (x % sum == 0) {
			return true;
		} else
			return false;
  }
}
```





첫 번째 예제의 경우 10의 자릿수의 합은 ( 1 + 0 ) = 1, 

​		10 % 1 == 0 이므로 하샤드 수입니다. ( **return true** )



두 번째 예제의 경우 12의 자릿수의 합은 ( 1 + 2 ) = 3, 

​		12 % 3 == 0 이므로 하샤드 수입니다. ( **return true** )



세 번째 예제의 경우 11의 자릿수의 합은 ( 1 + 1 ) = 2, 

​		11 % 2 == 1 이므로 하샤드 수가 아닙니다. ( **return false** )



네 번째 예제의 경우 13의 자릿수의 합은 ( 1 + 3 ) = 4, 

​		13 % 4 == 1 이므로 하샤드 수가 아닙니다. ( **return false** )





먼저 각 자릿수의 합을 구해주기 위하여 while문을 이용하였습니다.



초기 숫자 x를 저장하고 있는 a변수를 이용하였습니다.



자릿수의 합을 저장해둘 변수 sum을 만들어주었습니다.





while문 안에서, sum에 현재 a의 일의 자리를 더해주고 ( sum += a % 10 )



​	a 를 10으로 나누어주었습니다.





while문을 빠져나오고 나서 x(초기 입력으로 주어진 수)를 sum으로 나누어



​	나머지가 0이면 true를 반환하고 아닐 경우 false를 반환하도록 해주었습니다.







###  :lock:  Q. 평균 구하기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12944



## 평균 구하기





###### 문제 설명

정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.



#### 제한사항

- arr은 길이 1 이상, 100 이하인 배열입니다.
- arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.



#### 입출력 예

| arr       | return |
| --------- | :----: |
| [1,2,3,4] |  2.5   |
| [5,5]     |   5    |





```java
class Solution {
  public double solution(int[] arr) {
      double answer = 0;
      for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		answer /= arr.length;
      return answer;
  }
}
```





평균을 찾아야 하므로 double형 변수 answer을 선언합니다.

arr의 모든 요소들을 answer에 더해준 뒤, arr의 length만큼 나누어 정답을 찾아주었습니다.







###  :lock:  Q. 콜라츠 추측

출처 : https://programmers.co.kr/learn/courses/30/lessons/12943



## 콜라츠 추측



###### 문제 설명

1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다.



```
1-1. 입력된 수가 짝수라면 2로 나눕니다. 
1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
```



예를 들어, 입력된 수가 6이라면 6→3→10→5→16→8→4→2→1 이 되어 총 8번 만에 1이 됩니다. 위 작업을 몇 번이나 반복해야하는지 반환하는 함수, solution을 완성해 주세요. 단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환해 주세요.



##### 제한 사항

- 입력된 수, `num`은 1 이상 8000000 미만인 정수입니다.



##### 입출력 예

| n      | result |
| ------ | ------ |
| 6      | 8      |
| 16     | 4      |
| 626331 | -1     |



##### 입출력 예 설명

입출력 예 #1
문제의 설명과 같습니다.



입출력 예 #2
16 -> 8 -> 4 -> 2 -> 1 이되어 총 4번만에 1이 됩니다.



입출력 예 #3
626331은 500번을 시도해도 1이 되지 못하므로 -1을 리턴해야합니다.



```java
class Solution {
  public int solution(long num) {
		int index = 1;
      
		if(num == 1) {
			return 0;
		}
      
		while(index < 500) {
			if(num % 2 == 0) {
				num /= 2;
				if(num == 1) {
					break;
				}
			} else {
				num *= 3;
				num++;
			}
			index++;
		}
      
		if(index == 500)
			index = -1;
      return index;
  }
}
```





몇 번의 연산이 수행되었는지 확인하기 위해 index 변수를 생성하였습니다.



while문을 반복하면서 1이 아니라면 짝수일 경우 2로 나누어주고,

​		홀수일 경우에는 3을 곱하고 1을 더해주었습니다.



500번을 수행하고 나서 index값이 500이라면 -1을 출력하고

​	그 전에 종료되었다면 index를 출력해주었습니다.







###  :lock:  Q. 최대공약수와 최소공배수

출처 : https://programmers.co.kr/learn/courses/30/lessons/12940



## 최대공약수와 최소공배수



###### 문제 설명

두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.



##### 제한 사항

- 두 수는 1이상 1000000이하의 자연수입니다.



##### 입출력 예

| n    | m    | return  |
| ---- | ---- | ------- |
| 3    | 12   | [3, 12] |
| 2    | 5    | [1, 10] |



##### 입출력 예 설명

입출력 예 #1
위의 설명과 같습니다.



입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.



```java
class Solution {
  public int[] solution(int n, int m) {
      		int[] answer = new int[2];
		answer[0] = gcd(n, m);
		answer[1] = n * m / answer[0];
		return answer;
	}
	static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
```



먼저 유클리드 호제법을 이용하여 최소공배수를 구해 answer[0]에 저장하였습니다.

이후 answer[1]에는 최소공배수를 이용해서 최대공약수를 구해주었습니다.



유클리드 호제법을 사용하여 최소공배수를 구하는 방법은 아래 글을 참고해주세요.



https://javacoding.tistory.com/56?category=352749



이전에 정리해둔 유클리드 호제법을 이용하여 최소공배수와 최대공약수를 구하는 방법이었습니다.







###  :lock:  Q. 짝수와 홀수

출처 : https://programmers.co.kr/learn/courses/30/lessons/12937



## 짝수와 홀수



###### 문제 설명

정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.



##### 제한 조건

- num은 int 범위의 정수입니다.
- 0은 짝수입니다.



##### 입출력 예



| num  | return |
| ---- | :----: |
| 3    | "Odd"  |
| 4    | "Even" |



```java
class Solution {
  public String solution(int num) {

		if(num %2 == 0) {
			return ("Even");
		}else
			return ("Odd");
  }
}
```



% 연산자를 이용하여 입력으로 주어지는 num을 2로 나누어



나머지가 0이면 짝수를 반환하고 나머지가 홀수 (else)이면 홀수를 반환해주었습니다.







###  :lock:  Q. 제일 작은 수 제거하기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12935



## 제일 작은 수 제거하기



###### 문제 설명

정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.



##### 제한 조건

- arr은 길이 1 이상인 배열입니다.
- 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.



##### 입출력 예

| arr       | return  |
| --------- | ------- |
| [4,3,2,1] | [4,3,2] |
| [10]      | [-1]    |





```java
import java.util.ArrayList;
class Solution {
  public int[] solution(int[] arr) {
		int length = arr.length;
        int[] arr2 = new int[length-1];
		if(length == 1) {
			arr[0] = -1;
            return arr;
		} else {
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 0; i < length; i++) {
				if(min > arr[i]) {
					min = arr[i];
					min_idx = i;
				}
			}
			
			int index = 0;
			for (int i = 0; i < length; i++) {
				if(i == min_idx)
					continue;
				else {
					arr2[index] = arr[i];
					index++;
				}
			}
		}
      return arr2;
  }
}
```



우선 정답으로 출력되는 배열 arr2를 만들어주었습니다.



만약 입력으로 주어지는 배열의 길이가 1 이라면 arr2[0]에 -1을 담아 바로 리턴해주었고



길이가 2이상일 경우에는 최소값(min)과 그때의 인덱스(min_index)를 찾아주었습니다.



그 이후에 arr2배열에 min_index를 제외한 나머지 정수들을 담아주었습니다.



이때 단지 최소값으로 비교하면 최소값의 원소가 중복될 경우 



배열의 정수값이 누락될 수 있기 때문에 이를 방지하기 위해 index변수를 사용하여



최소값을 한 번만 제외하고 모두 옮겨주도록 하였습니다.







###  :lock:  Q. 정수 제곱근 판별

출처 : https://programmers.co.kr/learn/courses/30/lessons/12934



## 정수 제곱근 판별



###### 문제 설명

임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.



##### 제한 사항

- n은 1이상, 50000000000000 이하인 양의 정수입니다.



##### 입출력 예

| n    | return |
| ---- | :----: |
| 121  |  144   |
| 3    |   -1   |



###### 입출력 예 설명



**입출력 예#1**
121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.



**입출력 예#2**
3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.



```java
class Solution {
  public long solution(long n) {
      long answer = 0;
      	if(Math.sqrt(n) % 1 == 0) {
			answer = (long)((Math.sqrt(n)+1) * (Math.sqrt(n)+1));
		} else {
            answer = -1;
		}
      return answer;
  }
}
```



JAVA에서 제공하는 Math.sqrt() 함수를 사용하였습니다.



제곱근이 정수인지 아닌지 



Math.sqrt(n) % 1  == 0  연산을 이용하여 판별해주었습니다.







###  :lock:  Q. 정수 내림차순으로 배치하기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12933



## 정수 내림차순으로 배치하기



###### 문제 설명

함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.



##### 제한 조건

- `n`은 1이상 8000000000 이하인 자연수입니다.



##### 입출력 예

| n      | return |
| ------ | :----: |
| 118372 | 873211 |



```java
import java.util.Arrays;

class Solution {
  public long solution(long n) {
		String input = ""+ n;
		int size = input.length();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = input.charAt(i)- '0';
		}
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for (int i = size - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}
		long answer = Long.parseLong(sb.toString());
		return answer;
  }
}
```



입력으로 주어지는 n을 String input에 담은 뒤 한 자리씩 nums 배열에 저장하였습니다.



nums배열을 Arrays.sort() 함수를 이용하여 정렬해준 뒤



StringBuilder를 사용하여 내림차순으로 덧붙여주었습니다.



마지막으로 Long.parseLong을 이용하여 문자열을 long 변수 answer에 담아 출력해주었습니다.







###  :lock:  Q. 자연수 뒤집어 배열로 만들기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12932



## 자연수 뒤집어 배열로 만들기



###### 문제 설명

자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.



##### 제한 조건

- n은 10,000,000,000이하인 자연수입니다.



##### 입출력 예

| n     | return      |
| ----- | ----------- |
| 12345 | [5,4,3,2,1] |

```java
class Solution {
  public int[] solution(long n) {
		String input = ""+n;
		int size = input.length();
		int[] answer = new int[size];
		for (int i = size - 1; i >= 0; i--) {
			answer[i] = input.charAt(size - i - 1) - '0';
		}
		return answer;
  }
}
```



입력으로 주어지는 n을 String input에 담은 뒤 역순으로 한 자리씩 answer 배열에 저장하였습니다.



for 문을 사용하여 size - 1번째부터 0까지 역순으로 한 자씩 담아준 뒤



answer 배열을 return 해주었습니다.







###  :lock:  Q. 자릿수 더하기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12931



## 자릿수 더하기



###### 문제 설명

자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.



##### 제한사항

- N의 범위 : 100,000,000 이하의 자연수



##### 입출력 예

| N    | answer |
| ---- | ------ |
| 123  | 6      |
| 987  | 24     |



##### 입출력 예 설명

입출력 예 #1
문제의 예시와 같습니다.



입출력 예 #2
9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.



```java
import java.util.*;

public class Solution {
    public int solution(int N) {
		int answer = 0;
		while(N >= 1) {
			answer += N % 10;
			N /= 10;
		}
		return answer;
    }
}
```



입력으로 주어지는 N을 while문을 이용하여 일의 자리에 위치한 정수를 answer 변수에



계속 더해주었습니다. 더해준 뒤에는 10으로 나누어주고 N이 1보다 크거나 같을 때까지 반복합니다.



이 과정으로 모든 자릿수의 합을 구할 수 있었습니다.













###  :lock:  Q. 이상한 문자 만들기

출처 : https://programmers.co.kr/learn/courses/30/lessons/12930



## 이상한 문자 만들기



###### 문제 설명

문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.



##### 제한 사항

- 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
- 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.



##### 입출력 예

| s               | return          |
| --------------- | --------------- |
| try hello world | TrY HeLlO WoRlD |



##### 입출력 예 설명

try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.





```java
class Solution {
  public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
      	String upper = s.toUpperCase();
		String lower = s.toLowerCase();
      
		for (int i = 0; i < s.length(); i++) {		
			if(s.charAt(i) == ' ') {
				sb.append(' ');
				idx = 0;
			} else {
				if(idx % 2 == 0) {
					sb.append(upper.charAt(i));
					idx++;
				} else {
					sb.append(lower.charAt(i));
					idx++;
				}
			}
		}

        String answer = sb.toString();
        return answer;
  }
}
```



Stringbuilder 를 활용하여 풀이하였습니다.



먼저 문제에서 주어지는 s를 사용하여 upper와 lower를 만들었습니다.



이후 for문을 반복하면서 공백을 만났을 경우, idx 값을 0으로 초기화해준 뒤 공백을 붙여주었습니다.



공백이 아닌 문자를 만났을 때에는 **idx % 2** 값이 0인 경우 upper에서 문자를 붙여주고, 0이 아닌 경우에는 lower에서 문자를 붙여주었습니다.







###  :lock:  Q. 키패드 누르기

출처 : https://programmers.co.kr/learn/courses/30/lessons/67256



## 키패드 누르기



###### 문제 설명

스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

![kakao_phone1.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/4b69a271-5f4a-4bf4-9ebf-6ebed5a02d8d/kakao_phone1.png)

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 `*` 키패드에 오른손 엄지손가락은 `#` 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.



1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
2. 왼쪽 열의 3개의 숫자 `1`, `4`, `7`을 입력할 때는 왼손 엄지손가락을 사용합니다.
3. 오른쪽 열의 3개의 숫자 `3`, `6`, `9`를 입력할 때는 오른손 엄지손가락을 사용합니다.
4. 가운데 열의 4개의 숫자 `2`, `5`, `8`, `0`을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
   4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.



순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.



##### **[제한사항]**

- numbers 배열의 크기는 1 이상 1,000 이하입니다.

- numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.

- hand는

   

  ```
  "left"
  ```

   

  또는

   

  ```
  "right"
  ```

   

  입니다.

  - `"left"`는 왼손잡이, `"right"`는 오른손잡이를 의미합니다.

- 왼손 엄지손가락을 사용한 경우는 `L`, 오른손 엄지손가락을 사용한 경우는 `R`을 순서대로 이어붙여 문자열 형태로 return 해주세요.



------

##### **입출력 예**

| numbers                           | hand      | result          |
| --------------------------------- | --------- | --------------- |
| [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5] | `"right"` | `"LRLLLRLLRRL"` |
| [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2] | `"left"`  | `"LRLLRRLLLRR"` |
| [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]    | `"right"` | `"LLRLLRLLRL"`  |



##### **입출력 예에 대한 설명**

**입출력 예 #1**

순서대로 눌러야 할 번호가 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]이고, 오른손잡이입니다.

| 왼손 위치 | 오른손 위치 | 눌러야 할 숫자 | 사용한 손 | 설명                                                         |
| --------- | ----------- | -------------- | --------- | ------------------------------------------------------------ |
| *         | #           | 1              | L         | 1은 왼손으로 누릅니다.                                       |
| 1         | #           | 3              | R         | 3은 오른손으로 누릅니다.                                     |
| 1         | 3           | 4              | L         | 4는 왼손으로 누릅니다.                                       |
| 4         | 3           | 5              | L         | 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.  |
| 5         | 3           | 8              | L         | 왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다.  |
| 8         | 3           | 2              | R         | 왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다. |
| 8         | 2           | 1              | L         | 1은 왼손으로 누릅니다.                                       |
| 1         | 2           | 4              | L         | 4는 왼손으로 누릅니다.                                       |
| 4         | 2           | 5              | R         | 왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다. |
| 4         | 5           | 9              | R         | 9는 오른손으로 누릅니다.                                     |
| 4         | 9           | 5              | L         | 왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.  |
| 5         | 9           | -              | -         |                                                              |

따라서 `"LRLLLRLLRRL"`를 return 합니다.

**입출력 예 #2**

왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 `"LRLLRRLLLRR"`이 됩니다.

**입출력 예 #3**

오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 `"LLRLLRLLRL"`이 됩니다.



```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<String, Integer> map = new HashMap<>();
		map.put("12", 1);
		map.put("15", 2);
		map.put("18", 3);
		map.put("10", 4);

		map.put("22", 0);
		map.put("25", 1);
		map.put("28", 2);
		map.put("20", 3);

		map.put("32", 1);
		map.put("35", 2);
		map.put("38", 3);
		map.put("30", 4);

		map.put("42", 2);
		map.put("45", 1);
		map.put("48", 2);
		map.put("40", 3);

		map.put("52", 1);
		map.put("55", 0);
		map.put("58", 1);
		map.put("50", 2);

		map.put("62", 2);
		map.put("65", 1);
		map.put("68", 2);
		map.put("60", 3);

		map.put("72", 3);
		map.put("75", 2);
		map.put("78", 1);
		map.put("70", 2);

		map.put("82", 2);
		map.put("85", 1);
		map.put("88", 0);
		map.put("80", 1);

		map.put("92", 3);
		map.put("95", 2);
		map.put("98", 1);
		map.put("90", 2);

		map.put("*2", 4);
		map.put("*5", 3);
		map.put("*8", 2);
		map.put("*0", 1);

		map.put("02", 3);
		map.put("05", 2);
		map.put("08", 1);
		map.put("00", 0);

		map.put("#2", 4);
		map.put("#5", 3);
		map.put("#8", 2);
		map.put("#0", 1);

		StringBuilder sb = new StringBuilder();
		String left = "*";
		String right = "#";

		for (int i = 0; i < numbers.length; i++) {
			String ch = "" + numbers[i];
			if (ch.equals("1") || ch.equals("4") || ch.equals("7")) {
				sb.append("L");
				left = ch;
			} else if (ch.equals("3") || ch.equals("6") || ch.equals("9")) {
				sb.append("R");
				right = ch;
			} else {
				String leftTemp = left;
				String rightTemp = right;
				
				int leftDist = map.get(left+ch);
				int rightDist = map.get(right + ch);
				
				if(leftDist > rightDist) {
					sb.append("R");
					right = ch;
				} else if (leftDist < rightDist) {
					sb.append("L");
					left = ch;
				} else {
					if(hand.equals("left")) {
						sb.append("L");
						left = ch;
					} else {
						sb.append("R");
						right = ch;
					}
				}
			}
		}
		return sb.toString();
    }
}
```



문제가 잘 풀리지 않아 거의 노가다 하다시피 풀이하여 추천드리지 않습니다...



해쉬맵에 현재 위치에서 다음 번호까지의 거리를 모두 저장해두었습니다.



손이 이동하면 움직인 위치를 left 또는 right에 저장해두고 다음번 키패드까지의 거리를 계산하였습니다.







### :lock: ​ Q. 약수의 합

## 약수의 합



###### 문제 설명

정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.



##### 제한 사항

- `n`은 0 이상 3000이하인 정수입니다.



##### 입출력 예

| n    | return |
| ---- | ------ |
| 12   | 28     |
| 5    | 6      |



###### 입출력 예 설명

입출력 예 #1
12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.

입출력 예 #2
5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.



```java
class Solution {
  public int solution(int num) {
	    int answer = 0;
      
	    for(int i = 1; i <= num/2; i++){
	          if(num%i == 0) answer += i;
	    }
      
        return answer + num;
	}
}
```





정수 num의 모든 약수의 합을 구하는 문제입니다.



가장 큰 약수는 num을 2로 나누었을 때 나머지가 0인 경우이므로, for문을 1부터 num/2 까지 반복하면서  **num % i**가 0인 경우에 answer 변수에 더해주었습니다.



출처 : https://programmers.co.kr/learn/courses/30/lessons/12928







### :lock: ​ Q. 시저암호

## 시저암호



###### 문제 설명

어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.



##### 제한 조건

- 공백은 아무리 밀어도 공백입니다.
- s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
- s의 길이는 8000이하입니다.
- n은 1 이상, 25이하인 자연수입니다.



##### 입출력 예



| s     | n    | result |
| ----- | ---- | ------ |
| AB    | 1    | BC     |
| z     | 1    | a      |
| a B z | 4    | e F d  |





```java
class Solution {
  public String solution(String s, int n) {
      	StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch + n);
				if (ch > 'z')
					ch -= 26;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch + n);
				if (ch > 'Z')
					ch -= 26;
			}

			sb.append(ch);
		}

		return sb.toString();
  }
}
```





StringBuilder와 문자의 덧셈을 이용하여 풀이하였습니다.



먼저 각 문자가 소문자인 경우 **if (ch >= 'a' && ch <= 'z')** 와 대문자인 경우 **else if (ch >= 'A' && ch <= 'Z')** 로 나누었습니다.



각각의 경우에 모두 ch에 n을 더해주었고 'z' 혹은 'Z' 보다 커지는 경우에는 -26 연산을 이용하였습니다.



출처 : https://programmers.co.kr/learn/courses/30/lessons/12926







### :lock: ​ Q. 문자열을 정수로 바꾸기

## 문자열을 정수로 바꾸기



###### 문제 설명

문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.



##### 제한 조건

- s의 길이는 1 이상 5이하입니다.
- s의 맨앞에는 부호(+, -)가 올 수 있습니다.
- s는 부호와 숫자로만 이루어져있습니다.
- s는 0으로 시작하지 않습니다.



##### 입출력 예

예를들어 str이 1234이면 1234를 반환하고, -1234이면 -1234를 반환하면 됩니다.
str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.



```java
class Solution {
  public int solution(String s) {
      return Integer.parseInt(s);
  }
}
```



JAVA 언어를 사용하는 사람들에게는 너무 쉬운 문제입니다.



Integer.parseInt() 함수를 사용하였습니다.



출처 : https://programmers.co.kr/learn/courses/30/lessons/12925







### :lock: ​ Q. 수박수박수박수박수박수?

## 수박수박수박수박수박수?



###### 문제 설명

길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.



##### 제한 조건

- n은 길이 10,000이하인 자연수입니다.



##### 입출력 예

| n    | return   |
| ---- | -------- |
| 3    | 수박수   |
| 4    | 수박수박 |



```java
class Solution {
  public String solution(int n) {
      	int m = n;
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			if ((m - n) % 2 == 0)
				sb.append("수");
			else
				sb.append("박");
			n--;
		}
		return sb.toString();
  }
}
```



StringBuilder를 사용하여 풀이하였습니다.



변수 m을 만들어 시작할 때의 n 값을 저장한 뒤



**(m-n) % 2 == 0**  연산으로 n을 1씩 감소하며 문자를 덧붙여주었습니다.





출처 : https://programmers.co.kr/learn/courses/30/lessons/12922







### :lock: ​ Q. 소수 찾기

## 소수 찾기



###### 문제 설명

1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)



##### 제한 조건

- n은 2이상 1000000이하의 자연수입니다.



##### 입출력 예

| n    | result |
| ---- | ------ |
| 10   | 4      |
| 5    | 3      |



##### 입출력 예 설명

입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환



입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환



```java
class Solution {
  public int solution(int n) {
		int answer = 0;
		boolean[] checked = new boolean[n + 1];

		for (int i = 2; i <= n; i++) {
			if (!checked[i])
				answer++;
			for (int j = i; j <= n; j += i) {
				if (!checked[j])
					checked[j] = true;
			}
		}      
      return answer;
  }
}
```



이전에 공부했었던 에라토스테네스의 체를 활용하여 풀이하였습니다.





**에라토스테네스의 체에 대해 알고 있다면 풀이에 도움이 될 것 같아 관련 자료를 찾아보았습니다.**





![img](https://blog.kakaocdn.net/dn/LucuQ/btqARxJsGyA/NgJbnKpoDwLeXhNQefa9ZK/img.gif)

**출처 : 위키백과** 



[
에라토스테네스의 체 - 위키백과, 우리 모두의 백과사전위키백과, 우리 모두의 백과사전. 둘러보기로 가기 검색하러 가기 수학에서 에라토스테네스의 체는 소수(소쑤)를 찾는 방법이다. 고대 그리스 수학자 에라토스테네스가 발견하였다. 알고리즘[편집\] 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다. 그림에서 회색 사각형으로 두른 수들이 여기에 해당한다. 2는 소수이므로 오른쪽에 2를 쓴다. (빨간색) 자기 자신을 제외한 2의 배수를 모두 지운다. 남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다. (초ko.wikipedia.org](https://ko.wikipedia.org/wiki/에라토스테네스의_체)







**먼저 소수를 찾기 위해 boolean 배열 checked를 만들었습니다.**



**그리고 나서, 2부터 n까지 i의 만큼씩 더해 반복하며 소수에 해당하지 않는 수는**



**checked 배열에 true 처리하여 표시해주었습니다. ( 에라토스테네스의 체와 유사하게 )**



**모두 표시해준 이후 checked 배열이 false인 숫자들만 카운트 해주었습니다.**







출처 : https://programmers.co.kr/learn/courses/30/lessons/12921







### :lock: ​ Q. 서울에서 김서방 찾기

## 서울에서 김서방 찾기



###### 문제 설명

String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.



##### 제한 사항

- seoul은 길이 1 이상, 1000 이하인 배열입니다.
- seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
- Kim은 반드시 seoul 안에 포함되어 있습니다.



##### 입출력 예

| seoul       | return            |
| ----------- | ----------------- |
| [Jane, Kim] | 김서방은 1에 있다 |





```java
class Solution {
  public String solution(String[] seoul) {
      	String tmp = "Kim";
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals(tmp)) {
				tmp = "김서방은 " + i + "에 있다";
                break;
			}
		}
      return tmp;
  }
}
```



String temp에 "Kim"을 저장해두고 for문을 이용하여 정답을 찾았습니다.



input으로 주어지는 seoul[i] 번째가 tmp와 같다면, 



break한 뒤에 return 해주었습니다.





출처 : https://programmers.co.kr/learn/courses/30/lessons/12919







### :lock: ​ Q. 문자열 다루기 기본

## 문자열 다루기 기본



###### 문제 설명

문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.



##### 제한 사항

- `s`는 길이 1 이상, 길이 8 이하인 문자열입니다.



##### 입출력 예

| s    | return |
| ---- | ------ |
| a234 | false  |
| 1234 | true   |





```java
class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch < '0' || ch > '9')
					return false;
			}
			return true;
		} else
			return false;
    }
}
```



아주 간단한 문제였습니다.



입력으로 주어지는 문자열 s의 길이를 먼저 확인한 뒤,



주어지는 문자들이 숫자로 구성되어 있는지 확인하였습니다.





출처 : https://programmers.co.kr/learn/courses/30/lessons/12918







### :lock: ​ Q. 문자열 내림차순으로 배치하기

## 문자열 내림차순으로 배치하기



###### 문제 설명

문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.



##### 제한 사항

- str은 길이 1 이상인 문자열입니다.



##### 입출력 예

| s       | return  |
| ------- | ------- |
| Zbcdefg | gfedcbZ |





```java
import java.util.ArrayList;
import java.util.Collections;

class Solution {
  public String solution(String s) {
		ArrayList<Character> list = new ArrayList<>();
      
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		Collections.sort(list);
      
		StringBuilder sb = new StringBuilder();
      
		while (list.size() > 0) {
			sb.append(list.remove(list.size() - 1));
		}
      
        return sb.toString();
  }
}
```



문자를 정렬한 뒤 출력해주는 문제입니다.



먼저, ArrayList를 활용하여 입력으로 주어진 s 문자열을 list에 담아주었습니다.



이후 Collections의 sort 메소드를 사용하여 정렬해주었고



마지막으로 StringBuilder를 사용하여 정렬된 문자열을 출력해주었습니다.



출처 : https://programmers.co.kr/learn/courses/30/lessons/12917







### :lock:  Q. 문자열 내 p와 y의 개수

## 문자열 내 p와 y의 개수



###### 문제 설명

대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.



예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.



##### 제한사항

- 문자열 s의 길이 : 50 이하의 자연수
- 문자열 s는 알파벳으로만 이루어져 있습니다.



------

##### 입출력 예

| s       | answer |
| ------- | ------ |
| pPoooyY | true   |
| Pyy     | false  |



##### 입출력 예 설명

입출력 예 #1
'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.



입출력 예 #2
'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.





```java
class Solution {
    boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;
		char ch = ' ';
		
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if(ch == 'p' || ch== 'P')
				cnt++;
			else if (ch == 'y' || ch == 'Y')
				cnt--;
		}
		if(cnt != 0)
			return false;
		return true;
    }
}
```



입력으로 주어지는 문자열 s에 대하여



for문을 사용하여 p또는 P라면 cnt++,

y또는 Y라면 cnt--연산을 수행하였습니다.



실행 결과가 0이 아닌 경우에 false를 리턴하고, 0이라면 true를 리턴해주었습니다.



출처 : https://programmers.co.kr/learn/courses/30/lessons/12916