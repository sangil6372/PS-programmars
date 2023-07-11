package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P68644 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] numbers) {
		int[] answer = {};

		Arrays.sort(numbers);

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {

			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

		return answer;
	}
//	핵심은 정렬이고 반복문으로 두 개수를 뽑아서 더하고 중복제거도 필요하겠네 
//	중복제거를 set자료형으로 하고 나중에 배열로 변환하면 되겠네

}
