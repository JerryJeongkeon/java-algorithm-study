package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		long kim, lee, money, debt = 0L;

		while (st.hasMoreTokens()) {
			kim = Integer.parseInt(st.nextToken());
			lee = Integer.parseInt(st2.nextToken());

			if (kim > lee) {
				money = kim - lee;

				if (money > debt) {
					money -= debt;
					debt = 0;
					sb.append(money + " ");
				} else {
					debt -= money;
					sb.append("0 ");
				}
			} else {
				debt += lee - kim;
				sb.append("0 ");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
}
