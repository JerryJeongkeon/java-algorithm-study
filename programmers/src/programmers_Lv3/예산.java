package programmers_Lv3;

public class ¿¹»ê {
	static int[] budgets = { 120, 110, 140, 150 };
	static int M = 485;

	public static void main(String[] args) {
		int max = 0;
		for (int budget : budgets) {
			if (budget > max)
				max = budget;
		}

		System.out.println(binarySearch(budgets, M, 0, max+1));
	}

	static int binarySearch(int[] arr, int M, int start, int end) {
		int mid = (start + end) / 2;

		if (mid <= start)
			return start;

		int sum = 0;

		for (int budget : arr) {
			if (budget <= mid)
				sum += budget;
			else
				sum += mid;
		}

		int result = 0;

		if (sum < M)
			result = binarySearch(arr, M, mid, end);
		else if (sum == M)
			result = mid;
		else
			result = binarySearch(arr, M, start, mid);

		return result;
	}

}
