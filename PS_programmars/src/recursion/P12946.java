package recursion;

import java.util.ArrayList;
import java.util.List;

public class P12946 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	public static List<int[]> process;
	
	public int[][] solution(int n) {
		process = new ArrayList<>();
		hanoi(n, 1, 3);

//		List를 Array로 바꾸는 함수 
		return process.toArray(new int[0][]);
    }
	
//	 start mid end  
	
//	hanoi(n) = hanoi(n-1)*2 + 1
	
	public static void hanoi(int n, int start, int end) {
		if (n==1) {
			process.add(new int[] {start, end});
			return;
		}
		
		int mid = 6 - (start + end);
		
		hanoi(n-1, start, mid);
//		start에서 end로 1 이동 
		hanoi(1, start, end);
		hanoi(n-1, mid, end);
	}
	
	
}
