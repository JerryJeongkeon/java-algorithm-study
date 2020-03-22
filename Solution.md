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

			if (ch == 'S' || ch == 'D' || ch == 'T') {
				if (ch == 'D')
					score[scoreIdx - 1] *= score[scoreIdx - 1];
				else if (ch == 'T')
					score[scoreIdx - 1] = score[scoreIdx - 1] * score[scoreIdx - 1] * score[scoreIdx - 1];
			} else if (ch == '*' || ch == '#') {
				if (ch == '*') {
					score[scoreIdx - 1] *= 2;
					if (scoreIdx > 1)
						score[scoreIdx - 2] *= 2;
				} else {
					score[scoreIdx - 1] *= -1;
				}
			} else if (ch - '0' >= 0 && ch - '0' < 10) {
				if (ch - '0' == 1) {
					if (dartResult.charAt(i + 1) - '0' == 0) {
						score[scoreIdx] = 10;
						i++;
						scoreIdx++;
						continue;
					} else {
						score[scoreIdx] = 1;
					}
				} else {
					score[scoreIdx] = dartResult.charAt(i) - '0';
				}
				scoreIdx++;
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





**블록체인**의 위키 정의를 보면 결코 쉽지 않은 기술처럼 보이며 모든 것이 한번에 이해되지도 않을 것 같습니다. 하지만 글자 그대로 **블록**과 **체인**은 조금만 노력하면 이해가 가능합니다







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
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int userSize = stages.length;

		int[] stageCnt = new int[N + 2];
		for (int i = 0; i < userSize; i++) {
			stageCnt[stages[i]]++;
		}

		int nowTotalUser = 0;
		double stageFail = 0.0;
		int temp = 0;
        
        PriorityQueue<Stage> pq = new PriorityQueue<>(new Comparator<Stage>() {
			@Override
			public int compare(Stage s1, Stage s2) {
				if (s1.failer == s2.failer)
					return s1.index - s2.index;
				if (s2.failer - s1.failer > 0)
					return 1;
				else if (s2.failer - s1.failer < 0)
					return -1;
				return 0;
			}
		});
        
        for (int i = 1; i <= N; i++) {
			temp = nowTotalUser;
			nowTotalUser += stageCnt[i];

			if (userSize - temp == 0 || stageCnt[i] == 0) {
				pq.add(new Stage(i, 0));
			} else {
				stageFail = (double) stageCnt[i] / (userSize - temp);
				pq.add(new Stage(i, stageFail));
			}
		}

		for (int i = 1; i <= N; i++) {
			answer[i - 1] = pq.remove().index;
		}

        return answer;
    }
        
    static class Stage{
        int index;
        double failer;
        
        public Stage(int i, double f){
            this.index = i;
            this.failer = f;
        }        
    }
}
```



단계별 실패율을 구해주기 위해서 Stage 객체를 만들어주었습니다.

각각의 Stage 결과를 PriorityQueue에 실패율이 높은 순에서 낮은 순으로 정렬해주었습니다.



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
      
      String temp ="";
      int index = 0;
      
      for(int i = 0; i < n; i++){
          temp = Integer.toBinaryString(arr1[i]);
          index = 0;
          for(int j = n - temp.length(); j < n; j++){
              board1[i][j] = temp.charAt(index) - '0';
              index++;
          }
          
          temp = Integer.toBinaryString(arr2[i]);
          index = 0;
          for(int j = n - temp.length(); j < n; j++){
              board2[i][j] = temp.charAt(index) - '0';
              index++;
          }
      }
      
      StringBuilder sb = new StringBuilder();
      char[][] arr = new char[n][n];
      
      for(int i = 0; i < n; i++){
          sb = new StringBuilder();
          for(int j = 0; j < n; j++){
              if(board1[i][j] == 1 || board2[i][j] == 1){
                  arr[i][j] = '#';
                  sb.append(arr[i][j]);
                } else 
                  sb.append(" ");
          }
          answer[i] = sb.toString();
          System.out.println(answer[i]);
          }
      
      return answer;
  }
}
```



정수값의 데이터를 2진수로 변환하는게 가장 핵심이 되는 문제입니다.



JAVA에서 제공하는 Integer.toBinaryString() 함수를 사용하여 풀이하였습니다.



board라는 이름의 배열 2개를 만들어준 뒤, 

​	둘 중 하나라도 벽(1)인 곳에는 arr배열에 '#'을 넣어주고 아닌 경우에는 " " 공백을 넣어주었습니다.



마지막으로 StringBuilder()를 사용하여 문자열로 만들어준 뒤 answer배열에 담아 출력해주었습니다.

