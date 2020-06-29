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

