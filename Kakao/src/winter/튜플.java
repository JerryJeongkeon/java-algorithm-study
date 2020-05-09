package winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * StringTokenizer를 사용하여 "{}"로 잘라준다
 * , 로만 이루어진 문자열을 제외하고 list에 담아준다.
 * list를 문자열의 길이로 잘라준다.
 * list에 담겨있는 문자열에서 숫자를 꺼내 answerList에 숫자만 담아준다.
 * answerList에 담겨있는 숫자들을 차례대로 int[] answer에 옮겨담는다.
 * return answer;
 */

public class 튜플 {
	static String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(s, "{}");
		ArrayList<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			if (!temp.equals(","))
				list.add(temp);
		}

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		ArrayList<String> answerList = new ArrayList<>();
		for(String temp : list) {
			String[] arr = temp.split(",");
			
			for (int j = 0; j < arr.length; j++) {
				if(!answerList.contains(arr[j]))
					answerList.add(arr[j]);
			}
		}
		
		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answerList.size(); i++) {
			answer[i] = Integer.parseInt(answerList.get(i));
		}

		System.out.println(Arrays.toString(answer));
	}
}