package graph;


public class P49191 {
	private final static int INF = (int) 1e9; // 무한대로 충분히 큰 값 저장

	public int solution(int n, int[][] results) {
		int[][] graph = new int[n + 1][n + 1];
//		그래프 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = INF;
			}
		}

		for (int[] result : results) {
			int u = result[0];
			int v = result[1];
			graph[u][v] = 1; // u가 v를 이겼음을 표시
		}

		for (int i = 1; i <= n; i++) {
			graph[i][i] = 0; // 자기 자신과의 거리는 0으로 초기화
		}

		// 플로이드-와샬 알고리즘 적용
		for (int k = 1; k <= n; k++) { // k는 거쳐가는 노드
			for (int i = 1; i <= n; i++) { // i은 출발 노드
				for (int j = 1; j <= n; j++) { // j는 도착 노드
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		int answer = 0; // 순위 체크할 수 있는 노드(연결된 노드) 카운트
		
		for (int i = 1; i <= n; i++) {
			int count = 0;	// 
			for (int j = 1; j <= n; j++) {
				if (graph[i][j] < INF || graph[j][i] < INF)
					count++;	// 연결 된거면 카운트
			}
			if (count == n)	// 연결된 노드가 총 노드 수와 같으면 answer++
				answer++;
		}
		return answer;
	}

}
