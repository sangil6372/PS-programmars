package array;


public class P68645 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(4).toString());
	}

	public static int[] solution(int n) {
//		  정수 n이 매개변수로 주어집니다


//		  행 개수만큼 열 개수가 있는 재열 만든다음
//		  값으 순서대로 새로운 배열에 넣고 그 배열을 return 한다고 생각했음
//		  어떤 규칙이란게 있지 않을까?

		int[][] arr = new int[n][n];
		
		int[] dy = {1,0,-1};
		int[] dx = {0,1,-1};
		
//		현재 위치 y행 x열
		int x = 0;
		int y = 0;
		int d = 0;
		int value = 1;
		
		while(true) {
//			값을 채우고 1을 올림
			arr[y][x] = value++;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
//			진행 불가할 때
			if (nx==n||ny==n||nx==-1||ny==-1||arr[ny][nx]!=0) {
//				방향 전환하고 방향대로 한 걸음
				d = (d+1)%3; 
				nx = x + dx[d];
				ny = y + dy[d];

				
				if (nx==n||ny==n||nx==-1||ny==-1||arr[ny][nx]!=0) 
					break;
				
				
			}
			
			x = nx;
			y = ny;
			
		
			
		}
		
		int[] answer = new int [value-1];
//		값 복사
		int index = 0;
		for (int i = 0 ;i< n ;i++) {
			for (int j = 0;j<=i;j++) {				
				answer[index] = arr[i][j];
				index++;
			}
		}
		
		
		return answer;

	}

}
