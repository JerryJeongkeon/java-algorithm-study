package programmers_Lv1;

public class 콜라츠추측 {
	static long num = 1;
	
	public static void main(String[] args) {
		int index = 1;
		if(num == 1) {
			System.out.println(index);
		}
		while(index < 500) {
			if(num % 2 == 0) {
				num /= 2;
				if(num == 1) {
					System.out.println(index);
					break;
				}
			} else {
				num *= 3;
				num++;
			}
			index++;
		}
		if(index == 500)
			System.out.println(-1);
	}
}
