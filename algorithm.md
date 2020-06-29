# 이분탐색

## lower_bound

범위 [begin, end) 안의 원소들 중, 특정 target보다 크거나 같은 **첫번째 원소의 인덱스**를 리턴한다. 만약 그런 원소가 없다면 end 인덱스를 리턴한다.

이때 리스트는 모두 정렬된 상태여야 한다. 즉, lower_bound가 성립하기 위해서는 각각의 요소들중 `element < target`를 만족하는 요소들은 만족하지 않는 요소들보다 앞에 있어야한다.

c++의 lower_bound를 확인해보면 아래와같이 구성되어있다.

```c++
template <class ForwardIt, class T>
ForwardIt lower_bound(ForwardIt first, ForwardIt last, const T& value);
```

인자로 (리스트의 시작, 리스트의 끝, 찾고자하는 값)을 받고있다. 그리고 앞에서 언급했다시피 리턴값은 찾고자하는 값의 첫번째 인덱스를 리턴하기 때문에, 고려해서 java로 작성해보자.

<br/>

### 구현

```java
private static int lowerBound(List<Integer> data, int target) {
    int begin = 0;
    int end = data.size();
    
    while(begin < end) {
    	int mid = (begin + end) / 2;
        
        if(data.get(mid) >= target) {
        	end = mid;
        }
        else {
        	begin = mid + 1;
        }
    }
    return end;
}
```

<hr/>

## upper_bound

범위 [begin, end) 안의 원소들 중, **특정 target보다 큰 첫번째 원소의 인덱스**를 리턴한다. 만약 그런 원소가 없다면 end 인덱스를 리턴한다.

이때 리스트는 모두 정렬된 상태여야 한다. 즉, upper_bound가 성립하기 위해서는 각각의 요소들중 `element <= target`를 만족하는 요소들은 만족하지 않는 요소들보다 앞에 있어야한다. lower_bound와 비교해보면 등호가 들어가는데, target보다 큰 인덱스를 구하기 위해서이다.

c++의 upper_bound를 확인해보면 아래와같이 구성되어있다.

```c++
template <class ForwardIt, class T>
ForwardIt upper_bound(ForwardIt first, ForwardIt last, const T& value);
```

인자로 (리스트의 시작, 리스트의 끝, 찾고자하는 값)을 받고있다. 그리고 앞에서 언급했다시피 리턴값은 찾고자하는 값보다 큰 값의 첫번째 인덱스를 리턴하기 때문에, 고려해서 java로 작성해보자.

### 구현

```java
private static int upperBound(List<Integer> data, int target) {
    int begin = 0;
    int end = data.size();
    
    while(begin < end) {
    	int mid = (begin + end) / 2;
        
        if(data.get(mid) <= target) {
        	begin = mid + 1;
        }
        else {
        	end = mid;
        }
    }
    return end;
}
```

<br/>

## 정리

기본적으로 이분탐색의 원리를 따르기때문에 시간복잡도는 O(logn)이고, 정확히는 O(long(리스트의 길이))다. 두 함수를 구축할때 팁은 어떤 값을 찾고자하는지 생각하면 된다.

그리고 return값을 upperbound에서 target보다 큰 인덱스값을 뽑아내는 이유는 아마,
`upperBound() - lowerBound()`를 통해서 중복값의 개수를 구하기 위해서이지 않을까 생각한다.

<br/>

### 출처 : https://velog.io/@junhok82/lowerbound-upperbound

<hr>

**이진탐색 알고리즘**은 위키의 정의를 보면 정확하게 나와있다.

> **이진 검색 알고리즘**(binary search algorithm)은 오름차순으로 정렬된 리스트에서 특정한 값의 위치를 찾는 [알고리즘](https://ko.wikipedia.org/wiki/알고리즘)이다. 처음 중간의 값을 임의의 값으로 선택하여, 그 값과 찾고자 하는 값의 크고 작음을 비교하는 방식을 채택하고 있다. 처음 선택한 중앙값이 만약 찾는 값보다 크면 그 값은 새로운 최고값이 되며, 작으면 그 값은 새로운 최하값이 된다. 검색 원리상 정렬된 리스트에만 사용할 수 있다는 단점이 있지만, 검색이 반복될 때마다 목표값을 찾을 확률은 두 배가 되므로 속도가 빠르다는 장점이 있다. 이진 검색은 [분할 정복 알고리즘](https://ko.wikipedia.org/wiki/분할_정복_알고리즘)의 한 예이다.



이해하기 어렵지 않을 거라 생각한다.

<br/>

```java
Arrays.sort(arr);


.......


public int binarySearch(int[] arr, int target) {
    int first = 0;
    int last = arr.length - 1;
    int mid;

    while (first <= last) {
        mid = (first + last) / 2;

        if (target == arr[mid]) {
            return 1;
        } else {
            if (target < arr[mid]) {
                last = mid - 1;                        	 
            } else {
                first = mid + 1;                        	 
            }
        }
    }
    return 0;
}
```

<br/>

이진 탐색을 사용하기 전에는 무조건 **데이터가 정렬이 되어있어야하는** 전제가 깔려있어야한다.



이진 탐색 알고리즘은 간단하게 말하자면 절반을 나누면서 걸러낸다.



1. 배열의 중간을 먼저 탐색한다.
2. 중간값이 탐색값이면 중단.
3. 중간값이 탐색값이 아니라면 중간값과 탐색값의 크기를 비교한다.
4. 중간값 > 탐색값 - 중간값의 오른쪽 인덱스들은 제외
5.  중간값 < 탐색값 - 중간값의 왼쪽 인덱스들은 제외



정렬이 되어있기 때문에 4번처럼 비교할 필요가 없기 때문에 절반씩 제외시켜 탐색하게 된다.

이로써 시간복잡도는 최악의 경우에도 O(logn)이 된다.



또한 자바는 Arrays 클래스에는 이진 탐색 메소드가 존재한다.



그렇기 때문에 특별한 경우가 아니라면 구현하지 않고 메소드를 사용하면 된다.

```java
Arrays.binarySearch(array, target);
```

<br/>

### 출처: https://mygumi.tistory.com/72 [마이구미의 HelloWorld]

<hr/>

<br>

