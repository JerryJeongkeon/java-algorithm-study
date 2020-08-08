package programmers_Lv1;

public class 서울에서김서방찾기 {

	static String[] seoul = { "Jane", "Kim" };

	public static void main(String[] args) {
		String tmp = "Kim";
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals(tmp)) {
				tmp = "김서방은 " + i + "에 있다";
				break;
			}
		}

		System.out.println(tmp);
	}
}
