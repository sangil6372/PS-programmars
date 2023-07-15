package sort;

import java.util.Arrays;

public class P42747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[] citations) {

//	    내림차순 정렬
		Arrays.sort(citations);
		
		for (int h = citations.length;h>=1;h--) {
			if( isValid(citations, h)) return h;
		}
		
		return 0;
    }
	private boolean isValid(int[] citerations, int h) {
		int index = citerations.length - h;
		return citerations[index] >=h;
	}
	

}
