## 🚩 자바 알고리즘 풀이

자바 언어를 이용한 알고리즘 문제풀이 해설입니다.



### :lock: ​Q. 주식가격

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42584



###### 문제 설명

초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.



##### 제한사항

- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
- prices의 길이는 2 이상 100,000 이하입니다.



##### 입출력 예

| prices          | return          |
| --------------- | --------------- |
| [1, 2, 3, 2, 3] | [4, 3, 1, 1, 0] |



##### 입출력 예 설명

- 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
- 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
- 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
- 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
- 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.



※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.





```java
class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        for(int i = 0; i < length - 1; i++){
            int num = prices[i];
            int cnt = 0;
            
            for(int j = i + 1; j < length; j++) {
                cnt++;
                if(prices[j] < num){
                    break;
                }
            }
            answer[i] = cnt;
        }
    
        return answer;
    }
}
```







저는 2중 for문을 사용하여 풀이하였습니다.



먼저 prices에 담겨 있는 주식의 가격만큼 반복합니다.



안쪽 2중 for문에서는 i+1번째 주식 가격부터 length까지 비교하여 현재 주식의 가격보다



더 가격이 낮은 지점을 찾으면 break문으로 2중 for문을 빠져나갑니다.



cnt변수를 사용하여 같거나 더 가격이 높아질 경우에 cnt++ 연산으로 몇 초인지는 세주었습니다.



2중 for문이 종료된 이후 cnt값을 answer[i]에 넣어주면서 결과값을 찾았습니다.







### :lock: ​Q. 프린터

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42587



###### 문제 설명

일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.



```
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
```



예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.



내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.



현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.





##### 제한사항

- 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
- 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
- location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.



##### 입출력 예

| priorities         | location | return |
| ------------------ | -------- | ------ |
| [2, 1, 3, 2]       | 2        | 1      |
| [1, 1, 9, 1, 1, 1] | 0        | 5      |



##### 입출력 예 설명

예제 #1

문제에 나온 예와 같습니다.



예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.







```java
import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
		ArrayList<Document> list = new ArrayList<Document>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(new Document(i, priorities[i]));
		}

		int cnt = 1;
		while (list.size() > 0) {
			if (cnt == priorities.length)
				return cnt;

			Document temp = list.remove(0);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).priority > temp.priority) {
					list.add(new Document(temp.index, temp.priority));
					break;
				}
				if (j == list.size() - 1) {
					if (temp.index == location) {
						return cnt;
					}
					cnt++;
				}
			}
		}
		return -1;
	}

	static class Document {
		int index, priority;

		public Document(int i, int p) {
			this.index = i;
			this.priority = p;
		}
	}
}
```







이 문제 같은 경우 ArrayList와 Document class를 만들어서 풀이하였습니다.



먼저 Document 클래스를 만들어서 index와 priority 값을 저장해주었습니다.





이후 while문 list.size() > 0 조건문을 사용하여 마지막까지 확인할 수 있게 하였습니다.



list 0번째를 뽑아서 리스트에 남아있는 요소들과 우선순위를 비교합니다.





1. 만약 현재 우선순위가 가장 높은 경우 -> if (temp.index == location)  문제에서 찾는 조건인 경우에는 return cnt를 통해 몇 번째로 출력되는지를 return합니다.



2. 현재보다 우선 순위가 높은 문서가 있는 경우 -> list.add를 통해 맨 뒤에 붙여줍니다.





이 과정을 통해 가장 우선순위가 높은 문서부터 출력하면서, location에 해당하는 문서를



출력할 때 정답을 찾아주었습니다.







### :lock: ​Q. 기능개발

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42586



###### 문제 설명

프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.



또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.



먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.





##### 제한 사항

- 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
- 작업 진도는 100 미만의 자연수입니다.
- 작업 속도는 100 이하의 자연수입니다.
- 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.



##### 입출력 예

| progresses | speeds   | return |
| ---------- | -------- | ------ |
| [93,30,55] | [1,30,5] | [2,1]  |





##### 입출력 예 설명

첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.

두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.

세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.



따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.







```java
import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
		ArrayList<Document> list = new ArrayList<Document>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(new Document(i, priorities[i]));
		}

		int cnt = 1;
		while (list.size() > 0) {
			if (cnt == priorities.length)
				return cnt;

			Document temp = list.remove(0);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).priority > temp.priority) {
					list.add(new Document(temp.index, temp.priority));
					break;
				}
				if (j == list.size() - 1) {
					if (temp.index == location) {
						return cnt;
					}
					cnt++;
				}
			}
		}
		return -1;
	}

	static class Document {
		int index, priority;

		public Document(int i, int p) {
			this.index = i;
			this.priority = p;
		}
	}
}
```







이 문제 같은 경우 ArrayList와 Document class를 만들어서 풀이하였습니다.



먼저 Document 클래스를 만들어서 index와 priority 값을 저장해주었습니다.





이후 while문 list.size() > 0 조건문을 사용하여 마지막까지 확인할 수 있게 하였습니다.



list 0번째를 뽑아서 리스트에 남아있는 요소들과 우선순위를 비교합니다.





1. 만약 현재 우선순위가 가장 높은 경우 -> if (temp.index == location)  문제에서 찾는 조건인 경우에는 return cnt를 통해 몇 번째로 출력되는지를 return합니다.



2. 현재보다 우선 순위가 높은 문서가 있는 경우 -> list.add를 통해 맨 뒤에 붙여줍니다.





이 과정을 통해 가장 우선순위가 높은 문서부터 출력하면서, location에 해당하는 문서를



출력할 때 정답을 찾아주었습니다.









### :lock: ​Q. 124 나라의 숫자

출처 :  https://programmers.co.kr/learn/courses/30/lessons/12899



###### 문제 설명



124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.



1. 124 나라에는 자연수만 존재합니다.
2. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
3. 

예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.



| 10진법 | 124 나라 | 10진법 | 124 나라 |
| ------ | -------- | ------ | -------- |
| 1      | 1        | 6      | 14       |
| 2      | 2        | 7      | 21       |
| 3      | 4        | 8      | 22       |
| 4      | 11       | 9      | 24       |
| 5      | 12       | 10     | 41       |



자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.



##### 제한사항

- n은 500,000,000이하의 자연수 입니다.



------



##### 입출력 예

| n    | result |
| ---- | ------ |
| 1    | 1      |
| 2    | 2      |
| 3    | 4      |
| 4    | 11     |





```java
class Solution {
    public String solution(int n) {
		StringBuilder temp = new StringBuilder();
		String[] arr = {"4", "1" , "2"};

		int num = n; 
		
		while(num > 0) {
			int remainder = num % 3;
			num /= 3;
			
			if(remainder == 0) {
				num--;
			}
			temp.insert(0, arr[remainder]);
		}
        return temp.toString();
    }
}
```







1, 2, 4로만 이루어진 124 나라의 숫자는 결국 3진법을 사용하는 것과 같다고 생각하였습니다.



하지만 1, 2, 3으로 이루어진 것이 아닌 1, 2, 4로 이루어져 있기 때문에



String배열 arr를 {"4", 1", "2"} 로 선언해두고 사용하였습니다.





"4"가 마지막이 아닌 가장 앞에 나오는 이유는 소인수 분해를 진행할 때처럼 



num의 숫자 값을 3으로 계속 나누어 나머지를 StringBuilder에 덧붙여주었기 때문에



3으로 나누어 떨어지는 경우에는 num이 0값을 갖기 때문입니다.





추가적으로 remainder가 0일 경우 즉, 모두 나누어진 경우인데 



이때 num값은 0이 아닌 1을 갖기 때문에 num을 1 감소시켜주어 while문을 종료시켜 주도록 하였습니다.













저는 2중 for문을 사용하여 풀이하였습니다.



먼저 prices에 담겨 있는 주식의 가격만큼 반복합니다.



안쪽 2중 for문에서는 i+1번째 주식 가격부터 length까지 비교하여 현재 주식의 가격보다



더 가격이 낮은 지점을 찾으면 break문으로 2중 for문을 빠져나갑니다.



cnt변수를 사용하여 같거나 더 가격이 높아질 경우에 cnt++ 연산으로 몇 초인지는 세주었습니다.



2중 for문이 종료된 이후 cnt값을 answer[i]에 넣어주면서 결과값을 찾았습니다.







### :lock: ​Q. 탑

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42588



###### 문제 설명

수평 직선에 탑 N대를 세웠습니다. 모든 탑의 꼭대기에는 신호를 송/수신하는 장치를 설치했습니다. 발사한 신호는 신호를 보낸 탑보다 높은 탑에서만 수신합니다. 또한, 한 번 수신된 신호는 다른 탑으로 송신되지 않습니다.



예를 들어 높이가 6, 9, 5, 7, 4인 다섯 탑이 왼쪽으로 동시에 레이저 신호를 발사합니다. 그러면, 탑은 다음과 같이 신호를 주고받습니다. 높이가 4인 다섯 번째 탑에서 발사한 신호는 높이가 7인 네 번째 탑이 수신하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신합니다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신할 수 없습니다.



| 송신 탑(높이) | 수신 탑(높이) |
| ------------- | ------------- |
| 5(4)          | 4(7)          |
| 4(7)          | 2(9)          |
| 3(5)          | 2(9)          |
| 2(9)          | -             |
| 1(6)          | -             |



맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때 각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록 solution 함수를 작성해주세요.



##### 제한 사항

- heights는 길이 2 이상 100 이하인 정수 배열입니다.
- 모든 탑의 높이는 1 이상 100 이하입니다.
- 신호를 수신하는 탑이 없으면 0으로 표시합니다.



##### 입출력 예

| heights         | return          |
| --------------- | --------------- |
| [6,9,5,7,4]     | [0,0,2,2,4]     |
| [3,9,9,3,5,7,2] | [0,0,0,3,3,3,6] |
| [1,5,3,6,7,6,5] | [0,0,2,0,0,5,6] |



##### 입출력 예 설명

입출력 예 #1
앞서 설명한 예와 같습니다.



입출력 예 #2

[1,2,3] 번째 탑이 쏜 신호는 아무도 수신하지 않습니다.
[4,5,6] 번째 탑이 쏜 신호는 3번째 탑이 수신합니다.
[7] 번째 탑이 쏜 신호는 6번째 탑이 수신합니다.



입출력 예 #3

[1,2,4,5] 번째 탑이 쏜 신호는 아무도 수신하지 않습니다.
[3] 번째 탑이 쏜 신호는 2번째 탑이 수신합니다.
[6] 번째 탑이 쏜 신호는 5번째 탑이 수신합니다.
[7] 번째 탑이 쏜 신호는 6번째 탑이 수신합니다.



```java
class Solution {
    public int[] solution(int[] heights) {
        int size = heights.length;
		int[] answer = new int[size];

		for (int i = size - 1; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
        return answer;
    }
}
```



저는 2중 for문을 이용하여 풀이하였습니다.



size변수에 heights의 길이를 담아두고 answer 배열을 만들어 둔 뒤,



size-1번째부터 0번째 인덱스까지 i번째 (송출탑 높이) 보다 높은 j번째 (송신탑 높이)가 존재하는지 찾습니다.



존재한다면 j + 1번( 0부터 시작되었기 때문 ) 인덱스를 answer배열에 담아주었고



break문을 사용하여 찾았다면 바로 종료해주었습니다.





<hr/>

이 문제가 스택으로 분류되어 있어서 의아했었는데 다른분이 풀이하신 것을 보니

공부하는 데에 도움이 될 것 같아 남겨둡니다.



```java
import java.util.*;

class Solution {
    class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "idx : " + idx + " height : " + height;
        }
    }

    public int[] solution(int[] heights) {
        Stack<Tower> st = new Stack<>();
        int[] answer = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            Tower tower = new Tower(i + 1, heights[i]);
            int receiveIdx = 0;

            while (!st.isEmpty()) {
                Tower top = st.peek();

                if (top.height > tower.height) {
                    receiveIdx = top.idx;
                    break;
                }

                st.pop();
            }

            st.push(tower);
            answer[i] = receiveIdx;
        }

        return answer;
    }
}
```





Stack을 사용한 풀이 방법입니다.



현재 위치의 송출탑에 대한 정보를 Tower를 사용하여 저장해주었고, 



스택에 담겨 있는 값을 확인할 때는 top 변수를 사용하는 것을 알 수 있습니다.





원하는 값을 찾지 못한 경우 ( i번째 단계에서 현재 송출탑이 가장 높은 경우 ) 



while문을 통해 stack에는 가장 높은 현재 송출탑만 남게 되는 것을 알 수 있습니다.







### :lock: ​Q. 스킬트리

출처 :  https://programmers.co.kr/learn/courses/30/lessons/49993



###### 문제 설명

선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 `스파크 → 라이트닝 볼트 → 썬더`일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 `스파크 → 힐링 → 라이트닝 볼트 → 썬더`와 같은 스킬트리는 가능하지만, `썬더 → 스파크`나 `라이트닝 볼트 → 스파크 → 힐링 → 썬더`와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리[1](https://programmers.co.kr/learn/courses/30/lessons/49993#fn1)를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.



##### 제한 조건

- 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.

- 스킬 순서와 스킬트리는 문자열로 표기합니다.

  - 예를 들어, `C → B → D` 라면 CBD로 표기합니다

- 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.

- skill_trees는 길이 1 이상 20 이하인 배열입니다.

- skill_trees의 원소는 스킬을 나타내는 문자열입니다.

  - skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

  

##### 입출력 예

| skill   | skill_trees                         | return |
| ------- | ----------------------------------- | ------ |
| `"CBD"` | `["BACDE", "CBADF", "AECB", "BDA"]` | 2      |



##### 입출력 예 설명

- BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
- CBADF: 가능한 스킬트리입니다.
- AECB: 가능한 스킬트리입니다.
- BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.



```java
import java.util.Map;
import java.util.HashMap;

class Solution {
   public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < skill.length(); i++) {
			map.put(skill.charAt(i), i + 1);
		}

		for (int i = 0; i < skill_trees.length; i++) {
			String str = skill_trees[i];
			int index = 0;
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (skill.contains(Character.toString(ch))) {
					if (map.get(ch) == index + 1) {
						index++;
					} else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				answer++;
		}
      return answer;
   }
}
```



hashMap을 사용하여 풀이하였습니다.



skill에 담긴 스킬들을 hashmap에 <Character, Integer>로 저장해주었습니다.



Character에는 스킬 이름을, Integer에는 해당 스킬이 몇 번째인지 (i+1)를 사용하여 저장합니다.





그 이후에 for문을 사용하여 skill_trees[i] 번째 요소들을 검사합니다.



만약 스킬트리에 구성된 스킬이라면 map에서 스킬의 값이 index+1과 일치하는지 확인합니다.

​	3번째 스킬이 등장한다면 항상 1->2->3 순서로 등장해야만 하므로

   index 변수에 현재 사용된 스킬의 index를 저장해두고 다음번 스킬이 제대로 등장했는지를 확인합니다.



flag 변수를 사용해서 이상이 없다면(flag == true) answer을 1씩 더해주어 풀이하였습니다.







### :lock: ​Q. 다리를 지나는 트럭

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42583



###### 문제 설명

트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.



| 경과 시간 | 다리를 지난 트럭 | 다리를 건너는 트럭 | 대기 트럭 |
| --------- | ---------------- | ------------------ | --------- |
| 0         | []               | []                 | [7,4,5,6] |
| 1~2       | []               | [7]                | [4,5,6]   |
| 3         | [7]              | [4]                | [5,6]     |
| 4         | [7]              | [4,5]              | [6]       |
| 5         | [7,4]            | [5]                | [6]       |
| 6~7       | [7,4,5]          | [6]                | []        |
| 8         | [7,4,5,6]        | []                 | []        |



따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.



##### 제한 조건

- bridge_length는 1 이상 10,000 이하입니다.
- weight는 1 이상 10,000 이하입니다.
- truck_weights의 길이는 1 이상 10,000 이하입니다.
- 모든 트럭의 무게는 1 이상 weight 이하입니다.



##### 입출력 예

| bridge_length | weight | truck_weights                   | return |
| ------------- | ------ | ------------------------------- | ------ |
| 2             | 10     | [7,4,5,6]                       | 8      |
| 100           | 100    | [10]                            | 101    |
| 100           | 100    | [10,10,10,10,10,10,10,10,10,10] | 110    |



```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int Time = 0;

		Queue<truck> waitingqueue = new LinkedList<>();
		Queue<truck> runningQueue = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			waitingqueue.add(new truck(truck_weights[i], 0));
		}

		int currWeight = 0;
		while (!waitingqueue.isEmpty()) {
			if(!runningQueue.isEmpty() && runningQueue.peek().in + bridge_length == Time)
				currWeight -= runningQueue.peek().weight;
			
			if (currWeight + waitingqueue.peek().weight <= weight) {
				waitingqueue.peek().in = Time;
				currWeight += waitingqueue.peek().weight;
				runningQueue.add(waitingqueue.poll());
			}

			if (runningQueue.peek().in + bridge_length == Time) {
				runningQueue.poll();
			}

			Time++;
		}
		while(!runningQueue.isEmpty()) {
			if(runningQueue.size() == 1)
				Time = runningQueue.poll().in + bridge_length;
            else
                runningQueue.poll();
		}
		return (Time + 1);
    }
    
    static class truck{
        int weight;
        int in;
        
        public truck(int w, int i){
            this.weight = w;
            this.in = i;
        }
    }
}
```





waitingQueue와 runningQueue 2개를 이용하여 풀이하였습니다.



currWeight 변수에 현재 다리 위에 있는 truck의 무게를 저장합니다.



waitingQueue 가장 앞에 있는 truck의 무게가 weight보다 작다면



waitingQueue에 있는 truck을 runningQueue로 옮깁니다.



runningQueue 가장 앞에 있는 truck을 확인하여 



( truck의 다리에 올라간 시간 + 다리의 길이 ) == Time (현재 시간) 이 된다면



runningQueue 가장 앞에 있는 truck을 제거해주었습니다.





while문을 이용하여 waitingQueue에 있는 truck을 모두 제거한 뒤



runningQueue 마지막 트럭이 올라간 시간 + 다리의 길이 + 1 을 정답으로 return 해주었습니다.



+1을 해주는 이유는 다리에 있는 모든 트럭이 다리를 지나야 하기 때문입니다.







