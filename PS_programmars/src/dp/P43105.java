package dp;

public class P43105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	동적프로그래밍 문제가 메모이제이션을 꼭 사용해야 되는 건 아니다.

	public int solution(int[][] triangle) {
//		 삼각형 위에서 아래로 한 줄씩 갱신해나가는 거임
		for (int i = 1; i < triangle.length; i++) {
//			 맨 왼쪽 
			triangle[i][0] += triangle[i - 1][0];
//		  	 가운데 
			for (int j = 1; j < i; j++) {
				triangle[i][j] += +Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
			}
//			 맨 오른 쪽
			triangle[i][i] += triangle[i - 1][i - 1];

		}

//		 마지막 줄에서 최댓값 
		int answer = 0;
		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(answer, triangle[triangle.length - 1][i]);
		}
		return answer;
	}

}
