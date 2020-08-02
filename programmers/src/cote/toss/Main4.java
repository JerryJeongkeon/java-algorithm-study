package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main4 {
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Map<String, Integer> payHashMap = new HashMap<>();

		String payment = "";
		int index = 0;

		while (st.hasMoreTokens()) {
			payment = st.nextToken();
			index++;

			// TreeMap¿¡ Ãß°¡
			payHashMap.put(payment, index);
			sb = new StringBuilder();

			if (payHashMap.containsKey(payment)) {
				payHashMap.replace(payment, index);
			}

			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(payHashMap.entrySet());

			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> payment1, Entry<String, Integer> payment2) {
					return payment2.getValue().compareTo(payment1.getValue());
				}
			});

			while (list_entries.size() > 5) {
				list_entries.remove(list_entries.size() - 1);
			}

			for (Entry<String, Integer> entry : list_entries) {
				sb.append(entry.getKey() + " ");
			}

			bw.write(sb.toString().trim());
			if (st.hasMoreTokens())
				bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
