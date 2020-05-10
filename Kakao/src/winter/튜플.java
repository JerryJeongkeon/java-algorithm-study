package winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * StringTokenizer瑜� �궗�슜�븯�뿬 "{}"濡� �옒�씪以��떎
 * , 濡쒕쭔 �씠猷⑥뼱吏� 臾몄옄�뿴�쓣 �젣�쇅�븯怨� list�뿉 �떞�븘以��떎.
 * list瑜� 臾몄옄�뿴�쓽 湲몄씠濡� �옒�씪以��떎.
 * list�뿉 �떞寃⑥엳�뒗 臾몄옄�뿴�뿉�꽌 �닽�옄瑜� 爰쇰궡 answerList�뿉 �닽�옄留� �떞�븘以��떎.
 * answerList�뿉 �떞寃⑥엳�뒗 �닽�옄�뱾�쓣 李⑤���濡� int[] answer�뿉 �삷寃⑤떞�뒗�떎.
 * return answer;
 */

public class 튜플 {
	static String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer(s, "{}");
		ArrayList<String> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			System.out.println(temp);
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