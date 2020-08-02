package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> checkHashMap = new HashMap<>();
		int returnValue = 0;

		while (st.hasMoreTokens()) {
			int inputNum = Integer.parseInt(st.nextToken());

			if (checkHashMap.containsKey(inputNum)) {
				sb.append(checkHashMap.get(inputNum));
				sb.append(" ");
			} else {
				returnValue = compute(inputNum);
				checkHashMap.put(inputNum, returnValue);
				sb.append(returnValue);
				sb.append(" ");
			}
		}

		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}

	static int compute(int n) {
		return n * 2;
	}
}
