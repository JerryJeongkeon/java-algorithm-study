package programmers_Lv1;

public class ���￡���輭��ã�� {

	static String[] seoul = { "Jane", "Kim" };

	public static void main(String[] args) {
		String tmp = "Kim";
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals(tmp)) {
				tmp = "�輭���� " + i + "�� �ִ�";
				break;
			}
		}

		System.out.println(tmp);
	}
}
