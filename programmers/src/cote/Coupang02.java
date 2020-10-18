import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Coupang02 {

	// 가장 오래 기다린 키오스크와 매칭 (작은 시간에 돌아온 키오스크 먼저)
	// 시간이 같을 경우 고유번호가 낮은 순서로 매칭
	// 이때, 가장 많이 매칭되는 키오스크의 고객은 몇명인지를 반환하라!

	static int n = 3;
	static String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
			"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };

	public static void main(String[] args) throws ParseException {
		PriorityQueue<Kiosk> kioskQ = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++)
			kioskQ.add(new Kiosk(i, 0, 0));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd HH:mm:ss");

		for (int i = 0; i < customers.length; i++) {
			String[] tmp = customers[i].split(" ");
			String str = tmp[0] + " " + tmp[1];
			Date d = sdf.parse(str);
			long sec = d.getTime() / 1000;
			Kiosk kiosk = kioskQ.poll();
			long min = Integer.parseInt(tmp[2]) * 60;

			if (kiosk.time <= sec) {
				kioskQ.add(new Kiosk(kiosk.idx, kiosk.cnt + 1, sec + min));
			} else {
				kioskQ.add(new Kiosk(kiosk.idx, kiosk.cnt + 1, kiosk.time + min));
			}
		}

		int max = 0;
		while (true) {
			if (kioskQ.isEmpty())
				break;
			max = Math.max(max, kioskQ.poll().cnt);
		}

		System.out.println(max);

	}

	static class Kiosk implements Comparable<Kiosk> {
		int idx, cnt;
		long time;

		Kiosk(int idx, int cnt, long time) {
			this.idx = idx;
			this.cnt = cnt;
			this.time = time;
		}

		@Override
		public int compareTo(Kiosk k) {
			if(this.time < k.time)
				return -1;
			else if(this.time == k.time)
				if(this.idx < k.idx)
					return -1;
			return 1;
		}
	}
}
