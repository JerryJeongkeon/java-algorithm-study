package programmers_Lv2;

import java.util.LinkedList;

public class n진수게임 {

	static int n = 2;
	static int t = 4;
	static int m = 2;
	static int p = 1;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < t*m; i++){
            sb.append(change(i, n));
        }
        
        String temp = sb.toString();
        
        int k = 0;
        for(int i = 0; i < temp.length(); i++){
            k++;
            
            if(k == p){
                answer.append(temp.charAt(i));
            }
            
            if(answer.length() >= t)
                break;
            
            if(k == m)
                k = 0;
        }
        
        System.out.println(answer.toString());
	}
	
	public static String change(int num, int jinsu){
        LinkedList stack = new LinkedList();
        StringBuilder sb = new StringBuilder();
        char ch;
        int n = num;
        
        if(num == 0)
            return "0";
        
        while(n > 0){
            if(n % jinsu > 9){
                stack.add((char)(n%jinsu+55));
            } else {
                stack.add(n%jinsu);
            }
            n /= jinsu;
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        
        return sb.toString();
    }

}
