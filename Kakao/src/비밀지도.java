public class 비밀지도 {

	static int n = 5;
	static int[] arr1 = {9, 20, 28, 18, 11};
	static int[] arr2 = {30, 1, 21, 17, 28};
	
	public static void main(String[] args) {
		char[][] map = new char[n][n];
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(Integer.toBinaryString(arr1[i]));
		}
	}
}