## 🚩 자바 알고리즘 풀이

자바 언어를 이용한 알고리즘 문제풀이 해설입니다.



### :lock: ​Q. 예산

출처 :  https://programmers.co.kr/learn/courses/30/lessons/43237

## 예산

###### 문제 설명

국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것입니다. 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있습니다. 그래서 정해진 총액 이하에서 **가능한 한 최대의** 총 예산을 다음과 같은 방법으로 배정합니다.



```
1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다. 
   상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다. 
```



예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때, 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 됩니다.
각 지방에서 요청하는 예산이 담긴 배열 budgets과 총 예산 M이 매개변수로 주어질 때, 위의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.



##### 제한 사항

- 지방의 수는 3 이상 100,000 이하인 자연수입니다.
- 각 지방에서 요청하는 예산은 1 이상 100,000 이하인 자연수입니다.
- 총 예산은 `지방의 수` 이상 1,000,000,000 이하인 자연수입니다.



##### 입출력 예

| budgets              | M    | return |
| -------------------- | ---- | ------ |
| [120, 110, 140, 150] | 485  | 127    |

<br/>

```java
class Solution {
    public int solution(int[] budgets, int M) {
        int max = 0;
        for(int budget : budgets){
            if(max < budget)
                max = budget;
        }
        return binarySearch(budgets, M, 0, max + 1);
    }
    
    static int binarySearch(int[] arr, int M, int start, int end){
        int mid = (start+end) / 2;
        
        if(mid <= start)
            return start;
        
        int sum = 0;
        
        for(int budget : arr){
            if(budget <= mid)
                sum += budget;
            else
                sum += mid;
        }
        
        int result = 0;
        
        if(sum < M){
            result = binarySearch(arr, M, mid, end);
        } else if(sum == M)
            result = mid;
        else
            result = binarySearch(arr, M, start, mid);
    
        return result;
    }
}
```

<hr/>
이분탐색을 이용하여 풀이하였습니다.



먼저 max 변수를 이용해 최대값을 찾아준 뒤, binarySearch 함수를 실행하였습니다.  여유롭게  ( max + 1 ) 로 주어야 정답이 나옵니다.



mid값을 (start + end) / 2를 통해 찾아주었고 



sum의 값이 M 보다 작다면 mid부터 end까지 다시 탐색하고,

sum의 값이 M 보다 크다면 start부터 mid까지 탐색합니다.



만약 sum이 M과 일치하면 result를 mid값으로 설정해주었습니다.

<hr>
### :lock: ​Q. 입국심사

출처 :  https://programmers.co.kr/learn/courses/30/lessons/43238

### 입국심사



###### 문제 설명

n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.



처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.



모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.



입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.



##### 제한사항

- 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
- 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
- 심사관은 1명 이상 100,000명 이하입니다.



##### 입출력 예

| n    | times   | return |
| ---- | ------- | ------ |
| 6    | [7, 10] | 28     |



##### 입출력 예 설명

가장 첫 두 사람은 바로 심사를 받으러 갑니다.

7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.

10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.

14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.

20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.

## 



<br/>

```java
class Solution {
    static long answer = Long.MAX_VALUE;
    public long solution(int n, int[] times) {
        long max = 0;
        
        for(int i = 0; i < times.length; i++){
            if(max < times[i])
                max = times[i];
        }
        max *= n;
        
        long min = 1;
        long mid, sum;
        
        while(min <= max){
            sum = 0;
            mid = (min + max) / 2;
            
            for(int time : times){
                sum += mid / time;
            }
            
            if(sum >= n){
                if(mid < answer){
                    answer = mid;
                }
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}
```

<hr/>



**이분탐색**을 이용하여 풀이하였습니다.



먼저 max값을 가능한 최대의 경우로 설정하기 위해

for문을 이용하여 times 배열의 가장 큰 값을 찾습니다.

그 다음, 가능한 최대의 경우를 생각하여 max값에 n을 곱한 값을 max값으로 설정합니다.



이분탐색을 시작하여 만약 조건에 성립하고 기존 answer보다 작은 값이라면

answer을 갱신하여 최솟값을 찾아주었습니다.



이분탐색을 진행하기 위해 **sum(가능한 인원 수)** 값이 n보다 크다면

​	max 값을 mid + 1로 조정해주었고,

sum 값이 n보다 작다면 start 값을 mid + 1로 조절해주었습니다.



<hr/>