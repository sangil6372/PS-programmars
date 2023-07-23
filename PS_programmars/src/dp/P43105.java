package dp;


public class P43105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

//	
	
	
	public int solution(int[][] triangle) {
			
		 for (int i = 1; i < triangle.length; i++) {
//			 맨 왼쪽 
			 triangle[i][0] += triangle[i-1][0];
			 
//		  	 가운데 
			 for(int j = 1;j<i;j++) {
				 triangle[i][j] +=  + Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
			 }
			 
//			 맨 오른 쪽
			 triangle[i][i] += triangle[i-1][i-1]; 
			 
		 }
		 
//		 마지막 줄 최댓값 
		 int answer = 0;
	        
	        for (int i = 0; i < triangle.length; i++) {
	            answer = Math.max(answer, triangle[triangle.length - 1][i]);
	        }
	        
	     return answer;
	}
	
}
