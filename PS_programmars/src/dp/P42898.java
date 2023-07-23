package dp;

public class P42898 {

	public static void main(String[] args) {
	}

	public int solution(int m, int n, int[][] puddles) {
      
        int mod = 1000000007; // 결과에 나머지 
        
        int[][] board = new int[n+1][m+1]; // 경로를 담을 board
        for (int[] p : puddles) {
        	board[p[1]][p[0]] = -1;	// 웅덩이는 -1로 표시 
        }
        
//      처음 시작
        board[1][1] = 1;
        
        for (int i = 1;i<n+1;i++) {
        	for (int j=1;j<m+1;j++) {
        		if (board[i][j] == -1) continue;	// 웅덩이는 패스
        		if (board[i-1][j] > 0) board[i][j] += board[i-1][j]%mod; // 위에서 온 경우 +
        		if (board[i][j-1] > 0) board[i][j] += board[i][j-1]%mod; // 왼쪽에서 온 경우 +
                			
        	}
        }
        return board[n][m]%mod;	// 마지막에 총 경로 수
	}
}
