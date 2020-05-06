## 🚩 자바 알고리즘 풀이

자바 언어를 이용한 알고리즘 문제풀이 해설입니다.



### :lock: ​Q. 크레인 인형뽑기 게임

출처 :  https://programmers.co.kr/learn/courses/30/lessons/64061



###### 문제 설명

게임개발자인 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.



![crane_game_101.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/69f1cd36-09f4-4435-8363-b71a650f7448/crane_game_101.png)



게임 화면은 **1 x 1** 크기의 칸들로 이루어진 **N x N** 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. (위 그림은 5 x 5 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다. 모든 인형은 1 x 1 크기의 격자 한 칸을 차지하며 **격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.** 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.



![crane_game_102.png](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/638e2162-b1e4-4bbb-b0d7-62d31e97d75c/crane_game_102.png)



만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다. 위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 **두 개**가 없어집니다.



![crane_game_103.gif](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/8569d736-091e-4771-b2d3-7a6e95a20c22/crane_game_103.gif)



크레인 작동 시 인형이 집어지지 않는 경우는 없으나 만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 또한 바구니는 모든 인형이 들어갈 수 있을 만큼 충분히 크다고 가정합니다. (그림에서는 화면표시 제약으로 5칸만으로 표현하였음)



게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때, 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 return 하도록 solution 함수를 완성해주세요.



##### **[제한사항]**

- board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
- board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
  - 0은 빈 칸을 나타냅니다.
  - 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
- moves 배열의 크기는 1 이상 1,000 이하입니다.
- moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.



##### **입출력 예**

| board                                                        | moves             | result |
| ------------------------------------------------------------ | ----------------- | ------ |
| [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]] | [1,5,3,5,1,2,1,4] | 4      |





##### 입출력 예에 대한 설명**

**입출력 예 **

**#1**

인형의 처음 상태는 문제에 주어진 예시와 같습니다. 크레인이 [1, 5, 3, 5, 1, 2, 1, 4] 번 위치에서 차례대로 인형을 집어서 바구니에 옮겨 담은 후, 상태는 아래 그림과 같으며 바구니에 담는 과정에서 터트려져 사라진 인형은 4개 입니다.



![crane_game_104.jpg](https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/bb0f59c7-6b72-485a-8302-217fe53ea88f/crane_game_104.jpg)





```java
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
 		int answer = 0;
		int size = moves.length;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < size; i++) {
			int line = moves[i];
			int temp = 0;
			int row = 0;
			int toy = 0;
			while (toy == 0 && row < N) {
				if (board[row][line - 1] != 0) {
					toy = board[row][line - 1];
					board[row][line - 1] = 0;
				}
				row++;
			}
			if (toy == 0)
				continue;

			if (stack.size() > 0 && stack.peek() == toy) {
				stack.pop();
				answer += 2;
			} else {
				stack.push(toy);
			}
		}

		return answer;

    }
}
```





저는 Stack을 사용하여 풀이하였습니다.



먼저 뽑는 과정만큼 (moves) for문을 사용하여 반복합니다.



해당 위치에서 가장 위부터 차례대로 검사하여 0이 아닌 인형을 만날 때까지 while문으로 찾아주었습니다.



인형을 찾았을 때에는 stack의 가장 위에 위치한 인형과 비교하여 가장 위에 있는 인형과 같다면



stack에서 인형을 하나 꺼내준 뒤, answer값을 2 증가시켜주었습니다.



while문은 N과 같아진다면 해당 위치에 인형이 없는 것으로 알고 while 탐색을 종료하였습니다.



Level 1의 문제치고는 생각은 간단하지만 구현하는 데에 어려울 수 있었던 문제라고 생각합니다.







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

