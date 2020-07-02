public class NBP1 {
	static int[] arrA = { 4, 3, 2, 1 };
	static int[] arrB = { 5, 4, 1, 2 };

	public static void main(String[] args) {
		boolean flag = false;
		int len = arrA.length;

		if (arrA.length != arrB.length) {
			System.out.println("길이 다름");
		}

		for (int i = 0; i < arrA.length; i++) {
			if (arrA[0] == arrB[i]) {
				flag = true;
				for (int j = i + 1; j < i + len; j++) {
					if (arrA[j - i] != arrB[j % len]) {
						flag = false;
						break;
					}
				}
				if (flag)
					System.out.println("true : " + i);
			}
		}
	}
}