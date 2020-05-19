package programmers_Lv1;

import java.util.ArrayList;

public class 프린터 {
	static int[] priorities = { 1, 1, 9, 1, 1, 1 };
	static int location = 0;

	public static void main(String[] args) {
		int answer = 0;
		ArrayList<Document> list = new ArrayList<Document>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(new Document(i, priorities[i]));
		}

		int cnt = 1;
		while (list.size() > 0) {
			if (cnt == priorities.length)
				System.out.println(cnt);

			Document temp = list.remove(0);
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j).priority > temp.priority) {
					list.add(new Document(temp.index, temp.priority));
					break;
				}
				if (j == list.size() - 1) {
					if (temp.index == location) {
						System.out.println(cnt);
					}
					cnt++;
				}
			}
		}
		System.out.println(-1);
	}

	static class Document {
		int index, priority;

		public Document(int i, int p) {
			this.index = i;
			this.priority = p;
		}
	}
}
