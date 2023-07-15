package bruteForce;

public class P42842 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int brown, int yellow) {
//       완전 탐색 알고리즘 가로 세로 모든 경우의 수를 탐색
		for (int width = 3; width <= 5000; width++) {
			for (int height = 3; height <= width; height++) { // 조건) 가로 길이 >= 세로 길이 
				int boundary = (width + height - 2) * 2; // 경계는 가로*2+세로*2-4(모서리)
				int center = width * height - boundary; // 가운데 네모 개수
//				입력 받은 값과 일치할 경우 가로 세로 반환
				if (brown == boundary && yellow == center)
					return new int[] { width, height };
			}
		}
		return null;
	}

}
