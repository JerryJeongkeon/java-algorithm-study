package programmers_Lv2;

public class 숫자124나라 {

	static int n = 6;
	public static void main(String[] args) {
		StringBuilder temp = new StringBuilder();
		String[] arr = {"4", "1" , "2"};

		int num = n; 
		
		while(num > 0) {
			int remainder = num % 3;
			num /= 3;
			
			if(remainder == 0) {
				num--;
			}
			temp.insert(0, arr[remainder]);
		}
		System.out.println(temp.toString());
	}
}
