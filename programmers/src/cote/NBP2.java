import java.util.HashMap;
import java.util.Map;

public class NBP2 {
	static int[] arr = { 1, 2, 3 };

	public static void main(String[] args) {
		int answer = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				int beforeIdx = map.get(arr[i]);
				if (i - beforeIdx < answer) {
					answer = i - beforeIdx;
				}
				map.put(arr[i], i);
			}
		}
		if (answer == Integer.MAX_VALUE)
			System.out.println("-1");
		System.out.println("answer : " + answer);
	}
}
