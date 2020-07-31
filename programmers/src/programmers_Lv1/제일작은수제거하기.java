package programmers_Lv1;

public class 제일작은수제거하기 {
	static int[] arr = { 4, 3, 2, 1 };

	public static void main(String[] args) {
		int length = arr.length;
		int[] arr2 = new int[length - 1];
		if (length == 1) {
			arr[0] = -1;
			System.out.println(arr);
		} else {
			int min = Integer.MAX_VALUE;
			int min_idx = 0;
			for (int i = 0; i < length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					min_idx = i;
				}
			}

			int index = 0;
			for (int i = 0; i < length; i++) {
				if (i == min_idx)
					continue;
				else {
					arr2[index] = arr[i];
					index++;
				}
			}
		}
	}
}