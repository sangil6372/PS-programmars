package array;

public class P81302 {

	public static void main(String[] args) {

		String[][] str = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}		
		};
		
		int[] arr = solution(str);
		for (int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[places.length];

//		places의 각 row 는 대기실의 정보를 담고 있다
		for (int i = 0; i < places.length; i++) {
			char[][] place = new char[places.length][];
//			place의 row를 char[][] place에 담는 코드
			for (int j = 0; j < places[i].length; j++) {
				place[j] = places[i][j].toCharArray();
			}

			
			
			
			
//			각 대기실이 거리두기를 준수했는지 판단
			if (checkPlaceDist(place)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}

		return answer;
	}

	static boolean checkPlaceDist(char[][] place) {
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place[i].length; j++) {
				if (place[i][j] == 'P') {
					
//					모든 사람에 대해서 거리두기 준수여부 검사
					if (!checkPersonDist(place, i, j)) 
						return false;
				}
			}
		}
		return true;
	}

	static boolean checkPersonDist(char[][] place, int y, int x) {
//		 y와 x는 Person의 위치 y행 x열 
//		 각 사람 마다 
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };

//		시계방향으로 검사 
		for (int i = 0; i < 4; i++) {
			int nowY = y + dy[i];
			int nowX = x + dx[i];
			
			
			
//			범위를 초과할 경우 
			if (nowY<0||nowX<0||nowY>=place.length||nowX>=place[nowY].length)
				continue;
			
			
			if (place[nowY][nowX]=='X') continue;
			
			else if (place[nowY][nowX] == 'P')
				return false;
			else if (place[nowY][nowX] == 'O') {
//				각 방향 마다 검사 
				for (int j = 0; j < 4; j++) {
//					반대 방향일 경우 continue
					if (j==(i+2)%4) continue;
					
					int nextY = nowY + dy[j];
					int nextX = nowX + dx[j];
									
//					반대 방향과 범위를 초과할 경우 검사 안함
					if (nextY<0||nextX<0||nextY>=place.length||nextX>=place[nextY].length) {
						continue;
					}
					
//					검사 하기 					
					if (place[nextY][nextX] == 'P') {
						return false;	
					}
				}
			}
		}
		return true;

	}

}
