package recursion;

public class P68936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static class Count {
		public final int zero;
		public final int one;

		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

//		합쳐서 새로운 Count 객체 반환하는 방식 
		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}

	}

	private Count count(int offsetX, int offsetY, int size, int[][] arr) {
		int half = size / 2;
		for (int x = offsetX; x < offsetX + size; x++) {
			for (int y = offsetY; y < offsetY + size; y++) {
				if (arr[y][x] != arr[offsetY][offsetX]) {
//					다르면 4분할 및 재귀
					return count(offsetX, offsetY, half, arr).add(count(offsetX + half, offsetY, half, arr))
							.add(count(offsetX, offsetY + half, half, arr))
							.add(count(offsetX + half, offsetY + half, half, arr));
				}
			}
		}

		if (arr[offsetY][offsetX] == 1) {
			return new Count(0, 1);
		}
		return new Count(1, 0);

	}

	public int[] solution(int[][] arr) {

//        재귀함수는 상태 , 종료 조건, 점화식 

//        압축 하는 영역이 S 
//        if :  S 내부가 같은 수면 S 를 해당 수 하나로 통일 시킴
//        else : 그렇지 않다면 4등분 나누고 4개 영역에 대해 같은 방식으로 수행 

//       일단 S 전체 검사

		Count count = count(0, 0, arr.length, arr);
		return new int[] { count.zero, count.one };

	}

//	재귀적으로 풀어야하는데 흠
//	일단 압축부터 하고 
//	그다음 개수를 세면 되는데 ~

}
