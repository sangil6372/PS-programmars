package array;

public class P12949 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr1 = {{1,4},{3,2},{4,1}};
		int[][] arr2 = {{3,3},{3,3}};
		System.out.println(solution(arr1,arr2));
		
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr = new int[arr1.length][arr2[0].length];
        
        for (int i =0;i<arr.length;i++) {
        	for (int j = 0;j<arr[0].length;j++) {
        		int sum = 0;
        		for (int k=0;k<arr2.length;k++) {
        			sum += arr1[i][k]*arr2[k][j];
        		}
        		arr[i][j] = sum;
        	}
        }
        
        
        
        return arr;
    }
	
}
