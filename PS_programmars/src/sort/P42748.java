package sort;

import java.util.Arrays;

public class P42748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int[] solution(int[] array, int[][] commands) {
	      int[] answer = new int[commands.length];
	        
	        int i = 0;
//	        array를 command의 row를 일단 보고 
	        for (int[] row : commands) {
//	        	index 0 부터 1 에 해당하는 숫자 만큼 자르고 정렬
//	        	일단 카피 배열 필요 ? 
	        	int[] subArr = Arrays.copyOfRange(array, row[0]-1 , row[1]);
	        	Arrays.sort(subArr);
	        	answer[i] = subArr[row[2]-1];
	            i++;
	        }
	       	        
	        return answer;
	    }

}
