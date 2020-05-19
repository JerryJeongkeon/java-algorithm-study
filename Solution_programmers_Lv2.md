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





