import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Coupang04 {

	static String depar = "ULSAN";
	static String hub = "SEOUL";
	static String dest = "BUSAN";
	static String[][] roads = { { "SEOUL", "DAEJEON" }, { "ULSAN", "BUSAN" }, { "DAEJEON", "ULSAN" },
			{ "DAEJEON", "GWANGJU" }, { "SEOUL", "ULSAN" }, { "DAEJEON", "BUSAN" }, { "GWANGJU", "BUSAN" } };

	static ArrayList<ArrayList<Integer>> roadMapList = new ArrayList<>();
	static int[] minTerm;

	public static void main(String[] args) {
		int totalCount = 0;
		HashMap<String, Integer> roadMap = new HashMap<>();

		for (int i = 0; i < roads.length; i++) {
			if (!roadMap.containsKey(roads[i][0])) {
				roadMap.put(roads[i][0], totalCount++);
				roadMapList.add(new ArrayList<>());
			} else {
				roadMap.put(roads[i][1], totalCount++);
				roadMapList.add(new ArrayList<>());
			}
			roadMapList.get(roadMap.get(roads[i][0])).add(roadMap.get(roads[i][1]));
		}

		minTerm = new int[totalCount];
		int answer = findLoad(roadMap.get(depar), roadMap.get(hub));
		answer *= findLoad(roadMap.get(hub), roadMap.get(dest));
		System.out.println(answer % 10007);
	}

	private static int findLoad(Integer departure, Integer dest) {
		Queue<Integer> locationQ = new LinkedList<>();
		locationQ.add(departure);
		int count = 0;

		while (true) {
			if (locationQ.isEmpty())
				break;

			int temp = locationQ.remove();
			if (temp == dest)
				count++;

			for (int i : roadMapList.get(temp)) {
				locationQ.add(i);
			}
		}

		return count % 10007;
	}

}