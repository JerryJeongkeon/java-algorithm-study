package programmers;

public class 정수제곱근판별 {
	static int n = 122;
	
	public static void main(String[] args) {
		if(Math.sqrt(n) % 1 == 0) {
			System.out.println((long)((Math.sqrt(n)+1) * (Math.sqrt(n)+1))
					);
		} else {
			System.out.println(-1);
		}
	}

}
