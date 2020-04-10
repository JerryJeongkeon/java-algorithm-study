package programmers;

public class 콜라츠추측 {
	static int n = 626331;
	
	public static void main(String[] args) {
		int index = 1;
		while(index < 500) {
			if(n % 2 == 0) {
				n /= 2;
				if(n == 1) {
					System.out.println(index);
					break;
				}
			} else {
				n *= 3;
				n++;
			}
			index++;
		}
		if(index == 500)
			System.out.println(-1);
	}

}
