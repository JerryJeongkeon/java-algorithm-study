package programmers.src.programmers_Lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;

public class 문자열내마음대로정리하기 {
	static String[] strings = {"sun", "bed", "car"};
	static int n = 1;
	
	public static void main(String[] args) {
		Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(n) > o2.charAt(n))
					return 1;
				else if(o1.charAt(n) == o2.charAt(n))
					return o1.compareTo(o2);
				else
					return -1;
			}
		});
	}

}
