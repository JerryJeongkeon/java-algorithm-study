package winter;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 캐시 {

	static int cacheSize = 3;
	static String[] cities = {
		"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", 
		"Pangyo", "Seoul", "NewYork", "LA"
	};
	
	public static void main(String[] args) {
		int answer = 0;
		
		if(cacheSize == 0) {
			System.out.println(cities.length * 5);
		}
		
		Map<String, Integer> cacheBox = new LinkedHashMap<>();
		List<String> cacheBox2 = new LinkedList<>();
		
		for (int i = 0; i < cities.length; i++) {
			
			String city = cities[i].toUpperCase();
			
			int time = 5;
			
			if(cacheBox.get(city) == null ) {
				if(cacheBox.size() < cacheSize) {
					cacheBox.put(city, 1);
					cacheBox2.add(city);
				} else {
					cacheBox.put(city, 1);
					cacheBox2.add(city);
					
					cacheBox.remove(cacheBox2.get(0));
					cacheBox2.remove(0);
				}
			} else {
				time = 1;
				cacheBox2.remove(city);
				cacheBox2.add(city);
			}
			answer += time;
		}
		System.out.println(answer);
	}
}
