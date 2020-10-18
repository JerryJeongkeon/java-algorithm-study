import java.util.PriorityQueue;

public class preCoupang01 {
	static int[][] goods = {{5000, 1}, {3000, 2}, {1000, 1}};
	static int[][] coupons = {{10, 2}, {50, 4}};
	static long answer;
	
	public static void main(String[] args) {
		System.out.println(solve());
	}
	
	static long solve() {
		PriorityQueue<Good> goodsQ = new PriorityQueue<>();
		PriorityQueue<Coupon> couponsQ = new PriorityQueue<>();
		
		for (int i = 0; i < goods.length; i++) {
			goodsQ.offer(new Good(goods[i][0], goods[i][1]));
		}
		
		for (int i = 0; i < coupons.length; i++) {
			couponsQ.offer(new Coupon(coupons[i][0], coupons[i][1]));
		}
		
		while(!couponsQ.isEmpty()) {
			Coupon temp = couponsQ.poll();
			System.out.println("COupont : " + temp.sale);
			for (int i = 0; i < temp.num; i++) {
				System.out.println("answer : " + answer);
				if(goodsQ.isEmpty())
					return answer;
				answer += goodsQ.peek().price * (100 - temp.sale) / 100;
				goodsQ.peek().num--;
				if(goodsQ.peek().num == 0)
					goodsQ.remove();
			}
		}
		
		while(!goodsQ.isEmpty()) {
			answer += goodsQ.peek().price * goodsQ.peek().num;
			goodsQ.remove();
		}
		
		return answer;
	}
	
	static class Good implements Comparable<Good>{
		int price, num;
		
		public Good(int p, int n) {
			this.price = p;
			this.num = n;
		}
		
		@Override
		public int compareTo(Good o) {
			return o.price - this.price;
		}
	}
	
	static class Coupon implements Comparable<Coupon>{
		int sale, num;
		
		public Coupon(int s, int n) {
			this.sale = s;
			this.num = n;
		}
		
		@Override
		public int compareTo(Coupon o) {
			return o.sale - this.sale;
		}
	}
}
