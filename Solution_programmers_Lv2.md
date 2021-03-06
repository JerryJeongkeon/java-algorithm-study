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







### :lock: ​Q. 쇠막대기

출처 :  https://programmers.co.kr/learn/courses/30/lessons/42585



###### 문제 설명

여러 개의 쇠막대기를 레이저로 절단하려고 합니다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자릅니다. 쇠막대기와 레이저의 배치는 다음 조건을 만족합니다.



```
- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
```



아래 그림은 위 조건을 만족하는 예를 보여줍니다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진 점선 화살표는 레이저의 발사 방향입니다.

![image0.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/dbd166625b/d3ae656b-bb7b-421c-9f74-fa9ea800b860.png)

이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있습니다.



```
(a) 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현합니다. 또한 모든 '()'는 반드시 레이저를 표현합니다.
(b) 쇠막대기의 왼쪽 끝은 여는 괄호 '('로, 오른쪽 끝은 닫힌 괄호 ')'로 표현됩니다.
```



위 예의 괄호 표현은 그림 위에 주어져 있습니다.
쇠막대기는 레이저에 의해 몇 개의 조각으로 잘리는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로 잘리고, 이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘립니다.

쇠막대기와 레이저의 배치를 표현한 문자열 arrangement가 매개변수로 주어질 때, 잘린 쇠막대기 조각의 총 개수를 return 하도록 solution 함수를 작성해주세요.



##### 제한사항

- arrangement의 길이는 최대 100,000입니다.
- arrangement의 여는 괄호와 닫는 괄호는 항상 쌍을 이룹니다.



##### 입출력 예

| arrangement            | return |
| ---------------------- | ------ |
| ()(((()())(())()))(()) | 17     |

##### 입출력 예 설명

문제에 나온 예와 같습니다.



```java
import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        Stack<Integer> onStack = new Stack<>();
		Stack<Integer> offStack = new Stack<>();
		boolean[] check = new boolean[arrangement.length()];

		for (int i = 0; i < arrangement.length(); i++) {
			char ch = arrangement.charAt(i);

			if (ch == '(' && arrangement.charAt(i + 1) == ')') {
				check[i] = true;
			} else if (ch == '(' && arrangement.charAt(i + 1) == '(') {
				onStack.add(i);
			} else if (ch == ')' && arrangement.charAt(i - 1) == ')') {
				offStack.add(i);
			}
		}

		int answer = 0;
		while (!onStack.isEmpty()) {
			int start = onStack.pop();
			int end = offStack.pop();
			for (int i = start; i <= end; i++) {
				if (check[i])
					answer++;
			}
			answer++;
		}
		return answer;
    }
}
```





2개의 Stack을 사용하여 풀이하였습니다.



먼저, for문을 사용하여 arrangement 를 반복하며 문자를 검사합니다.



1. **'('** (여는 괄호)일 경우, 바로 다음 문자가 **'('**  (여는 괄호) 라면 **onStack**에 넣습니다.

   --> 열고 바로 닫힌다면, 레이저 이므로 check배열에 [i] 번째를 true로 설정

   

2. **')'** (닫는 괄호)일 경우, 이전 문자도 **')'** (닫는 괄호) 라면 **offStack**에 넣습니다.



while문을 통해 양쪽 Stack에서 한개씩 뽑아 여는 괄호를 int start, 닫는 괄호를 int end로 두고



**start**부터 **end**까지 카운트를 세줍니다.



중요한 점은 **레이저**가 있다면 해당 위치에서 **막대가 두 개로 나뉘므로**



check[i]가 true인 i번째를 만났을 때에는 카운트를 하나 더 세주었습니다.







### :lock: ​Q. 카카오프렌즈 컬러링북

출처 :  https://programmers.co.kr/learn/courses/30/lessons/1829



###### 문제 설명

## 카카오 프렌즈 컬러링북

출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)



그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.



![alt text](http://t1.kakaocdn.net/codefestival/apeach.png)



위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.



### 입력 형식

입력은 그림의 크기를 나타내는 `m`과 `n`, 그리고 그림을 나타내는 `m × n` 크기의 2차원 배열 `picture`로 주어진다. 제한조건은 아래와 같다.

- `1 <= m, n <= 100`
- `picture`의 원소는 `0` 이상 `2^31 - 1` 이하의 임의의 값이다.
- `picture`의 원소 중 값이 `0`인 경우는 색칠하지 않는 영역을 뜻한다.



### 출력 형식

리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.



### 예제 입출력

| m    | n    | picture                                                      | answer |
| ---- | ---- | ------------------------------------------------------------ | ------ |
| 6    | 4    | [[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]] | [4, 5] |



### 예제에 대한 설명

예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 `1`로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 `1`이 차지하는 영역으로 총 5칸이다.



```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] map;
    static boolean[][] visited;
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static Queue<Pos> q;
	static int next_i, next_j, cnt, max, M, N;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        M = m;
        N = n;
		q = new LinkedList<Pos>();
		visited = new boolean[m][n];
		max = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					cnt = 0;
					numberOfArea++;
					bfs(picture, new Pos(i, j));
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = max;
		return answer;
    }
    
    static void bfs(int[][] picture, Pos before) {
		q.offer(before);
		visited[before.i][before.j] = true;

		while (!q.isEmpty()) {
			cnt++;
			if (cnt > max)
				max = cnt;

			Pos temp = q.poll();
			for (int k = 0; k < 4; k++) {
				next_i = temp.i + di[k];
				next_j = temp.j + dj[k];

				if (next_i < 0 || next_i >= M || next_j < 0 || next_j >= N)
					continue;
				if (!visited[next_i][next_j] && picture[temp.i][temp.j] == picture[next_i][next_j]) {
					visited[next_i][next_j] = true;
					q.offer(new Pos(next_i, next_j));
				}
			}
		}
	}

	static class Pos {
		int i, j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
```





**간단한 bfs 문제**입니다.



먼저, 모든 지점을 방문하면서 

​	**아직 방문하지 않았고**(!visited), **해당 지점이 색칠되어 있다면**( != 0) 

해당 지점에서 **bfs**함수를 실행하였습니다.

 이때, **numberOfArea** 를 1씩 증가시켜 몇 개의 구역으로 나뉘는지 체크하였습니다.



bfs에서는 상하좌우를 탐색하면서 아직 방문하지 않았고, 현재의 컬러와 같다면

​	Queue에 담아주고 cnt 변수를 이용해 카운트 해주었습니다.



queue에서 Pos 클래스를 뽑을 때마다, max 변수와 대소비교를 통해 최댓값을 찾아

max 변수에 저장하여 최대 넓이를 찾았습니다.







### :lock: Q. [3차] n진수 게임

출처 :  https://programmers.co.kr/learn/courses/30/lessons/17687



###### 문제 설명

## N진수 게임

튜브가 활동하는 코딩 동아리에서는 전통적으로 해오는 게임이 있다. 이 게임은 여러 사람이 둥글게 앉아서 숫자를 하나씩 차례대로 말하는 게임인데, 규칙은 다음과 같다.

1. 숫자를 0부터 시작해서 차례대로 말한다. 첫 번째 사람은 0, 두 번째 사람은 1, … 열 번째 사람은 9를 말한다.
2. 10 이상의 숫자부터는 한 자리씩 끊어서 말한다. 즉 열한 번째 사람은 10의 첫 자리인 1, 열두 번째 사람은 둘째 자리인 0을 말한다.



이렇게 게임을 진행할 경우,
`0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, …`
순으로 숫자를 말하면 된다.



한편 코딩 동아리 일원들은 컴퓨터를 다루는 사람답게 이진수로 이 게임을 진행하기도 하는데, 이 경우에는
`0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, …`
순으로 숫자를 말하면 된다.



이진수로 진행하는 게임에 익숙해져 질려가던 사람들은 좀 더 난이도를 높이기 위해 이진법에서 십육진법까지 모든 진법으로 게임을 진행해보기로 했다. 숫자 게임이 익숙하지 않은 튜브는 게임에 져서 벌칙을 받는 굴욕을 피하기 위해, 자신이 말해야 하는 숫자를 스마트폰에 미리 출력해주는 프로그램을 만들려고 한다. 튜브의 프로그램을 구현하라.



### 입력 형식

진법 `n`, 미리 구할 숫자의 갯수 `t`, 게임에 참가하는 인원 `m`, 튜브의 순서 `p` 가 주어진다.

- 2 ≦ `n` ≦ 16
- 0 ＜ `t` ≦ 1000
- 2 ≦ `m` ≦ 100
- 1 ≦ `p` ≦ `m`



### 출력 형식

튜브가 말해야 하는 숫자 `t`개를 공백 없이 차례대로 나타낸 문자열. 단, `10`~`15`는 각각 대문자 `A`~`F`로 출력한다.



### 입출력 예제

| n    | t    | m    | p    | result           |
| ---- | ---- | ---- | ---- | ---------------- |
| 2    | 4    | 2    | 1    | 0111             |
| 16   | 16   | 2    | 1    | 02468ACE11111111 |
| 16   | 16   | 2    | 2    | 13579BDF01234567 |

[해설 보러가기](http://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/)





```java
import java.util.LinkedList;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < t*m; i++){
            sb.append(change(i, n));
        }
        
        String temp = sb.toString();
        
        int k = 0;
        for(int i = 0; i < temp.length(); i++){
            k++;
            
            if(k == p){
                answer.append(temp.charAt(i));
            }
            
            if(answer.length() >= t)
                break;
            
            if(k == m)
                k = 0;
        }
        
        return answer.toString();
    }
    
    public static String change(int num, int jinsu){
        LinkedList stack = new LinkedList();
        StringBuilder sb = new StringBuilder();
        char ch;
        int n = num;
        
        if(num == 0)
            return "0";
        
        while(n > 0){
            if(n % jinsu > 9){
                stack.add((char)(n%jinsu+55));
            } else {
                stack.add(n%jinsu);
            }
            n /= jinsu;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }
}
```





문자열을 다루는 문제입니다.



2개의 StringBuilder sb와 answer을 선언하여 사용하였습니다.



먼저 t * m 의 길이 만큼 change() 메소드를 통해 sb에 n진수로 변환된 문자열을 붙여주었습니다.



change() 메소드 내에서는 진법 변환을 해주었는데, Stack의 역할을 하는 LinkedList를 이용하였습니다.



add와 pollLast 메소드를 이용하여 진법으로 변환된 문자열을 출력해주었습니다.



이후 for문을 이용하여 문자열 index를 조정하였고  k 변수를 tube의 차례로 나타내어 answer에 문자열을 추가해주었습니다.



### :lock: Q. 영어 끝말잇기

출처 :  https://programmers.co.kr/learn/courses/30/lessons/12981



###### 문제 설명

## 영어 끝말잇기

1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.



1. 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
2. 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
3. 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
4. 이전에 등장했던 단어는 사용할 수 없습니다.
5. 한 글자인 단어는 인정되지 않습니다.



다음은 3명이 끝말잇기를 하는 상황을 나타냅니다.

tank → kick → know → wheel → land → dream → mother → robot → tank

위 끝말잇기는 다음과 같이 진행됩니다.

- 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
- 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
- 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
- 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
- (계속 진행)

끝말잇기를 계속 진행해 나가다 보면, 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.



사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.



##### 제한 사항

- 끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
- words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
- 단어의 길이는 2 이상 50 이하입니다.
- 모든 단어는 알파벳 소문자로만 이루어져 있습니다.
- 끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
- 정답은 [ 번호, 차례 ] 형태로 return 해주세요.
- 만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.

------

##### 입출력 예

| n    | words                                                        | result |
| ---- | ------------------------------------------------------------ | ------ |
| 3    | [tank, kick, know, wheel, land, dream, mother, robot, tank]  | [3,3]  |
| 5    | [hello, observe, effect, take, either, recognize, encourage, ensure, establish, hang, gather, refer, reference, estimate, executive] | [0,0]  |
| 2    | [hello, one, even, never, now, world, draw]                  | [1,3]  |

##### 입출력 예 설명

입출력 예 #1
3명의 사람이 끝말잇기에 참여하고 있습니다.

- 1번 사람 : tank, wheel, mother
- 2번 사람 : kick, land, robot
- 3번 사람 : know, dream, `tank`

와 같은 순서로 말을 하게 되며, 3번 사람이 자신의 세 번째 차례에 말한 `tank`라는 단어가 1번 사람이 자신의 첫 번째 차례에 말한 `tank`와 같으므로 3번 사람이 자신의 세 번째 차례로 말을 할 때 처음 탈락자가 나오게 됩니다.



입출력 예 #2
5명의 사람이 끝말잇기에 참여하고 있습니다.

- 1번 사람 : hello, recognize, gather
- 2번 사람 : observe, encourage, refer
- 3번 사람 : effect, ensure, reference
- 4번 사람 : take, establish, estimate
- 5번 사람 : either, hang, executive

와 같은 순서로 말을 하게 되며, 이 경우는 주어진 단어로만으로는 탈락자가 발생하지 않습니다. 따라서 [0, 0]을 return하면 됩니다.



입출력 예 #3
2명의 사람이 끝말잇기에 참여하고 있습니다.

- 1번 사람 : hello, even, `now`, draw
- 2번 사람 : one, never, world

와 같은 순서로 말을 하게 되며, 1번 사람이 자신의 세 번째 차례에 'r'로 시작하는 단어 대신, n으로 시작하는 `now`를 말했기 때문에 이때 처음 탈락자가 나오게 됩니다.



```java
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
		HashSet<String> set = new HashSet<>();
		int[] result = new int[2];

		set.add(words[0]);
		char lastChar = words[0].charAt(words[0].length() - 1);
		char firstChar = '.';
		int size = words.length;

		for (int i = 1; i < size; i++) {
			firstChar = words[i].charAt(0);
			if (lastChar != firstChar || set.contains(words[i]) || words[i].length() == 1) {
				result[0] = (i % n) + 1;
				result[1] = (i / n) + 1;
				break;
			}
			set.add(words[i]);
			
			lastChar = words[i].charAt(words[i].length() - 1);
		}
		
		return result;
    }
}
```





Set 자료구조를 사용하여 풀이하였습니다.



이전에 나온 단어인지 Set에 추가하여 확인하였고,  for문을 이용하여 words를 하나씩 확인하였습니다.



먼저 words[0] 단어를 Set에 넣어주고, for문을 1부터 size(words.length)만큼 검사합니다.



1. 이전 단어의 마지막 문자와 같지 않거나, 

2. 이미 나온 단어,
3. 단어의 길이가 1인 경우

if문으로 검사하여 result 배열에 결과값을 넣어준 뒤 break를 사용해 종료해주었습니다.



