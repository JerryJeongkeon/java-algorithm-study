package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2776_¾Ï±â¿Õ_Hash {
	static int TC, N, M;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine().trim());
		sb = new StringBuilder();
		
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			Map<Integer, Boolean> map = new HashMap<>();
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				map.put(Integer.parseInt(st.nextToken()), true);
			}
			
			M = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < M; m++) {
				if(map.containsKey(Integer.parseInt(st.nextToken())))
					sb.append("1\n");
				else
					sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}

}
