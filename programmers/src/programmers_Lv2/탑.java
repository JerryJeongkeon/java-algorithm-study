package programmers_Lv2;

import java.util.Arrays;
import java.util.Stack;

public class 탑 {
	static int[] heights = { 6, 9, 5, 7, 4 };
	
    static class Tower {
        int idx;
        int height;

        public Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "idx : " + idx + " height : " + height;
        }
    }


	public static void main(String[] args) {
	       Stack<Tower> st = new Stack<>();
	        int[] answer = new int[heights.length];

	        for (int i = 0; i < heights.length; i++) {
	            Tower tower = new Tower(i + 1, heights[i]);
	            int receiveIdx = 0;
	            while (!st.isEmpty()) {
	                Tower top = st.peek();
	                System.out.println("top : " + top.height+ ", tower : " + tower.height);
	                if (top.height > tower.height) {
	                    receiveIdx = top.idx;
	                    break;
	                }

	                st.pop();
	            }

	            st.push(tower);
	            answer[i] = receiveIdx;
	            System.out.println("i : " + i + "siz : " + st.size());
	        }
	        System.out.println(Arrays.toString(answer));
	}
	
}
