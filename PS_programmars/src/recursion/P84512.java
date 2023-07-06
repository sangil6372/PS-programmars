package recursion;

import java.util.HashMap;
import java.util.Map;

public class P84512 {
	public static void main(String[] args) {
		solution("EIO");
	}

	static Map<Character, Integer> vowelMap; // A,E,I,O,U 모음 순번 매핑
	static final int[] digitWeight = { 781, 156, 31, 6, 1 }; // 자릿수에 따른 경우의 수 가중치 1+5+5^2+5^3+5^4, 1+5+5^2+5^3, 1+5+5^2, 1+5, 1

	public static int solution(String word) {
		vowelMap = new HashMap<>();
//		모음의 순번 맵 초기화 
		vowelMap.put('A', 1);
		vowelMap.put('E', 2);
		vowelMap.put('I', 3);
		vowelMap.put('O', 4);
		vowelMap.put('U', 5);
		return checkDictionary(word);
	}

//	특정 문자의 자릿수 가중치를 고려해서 값을 구하는 함수 
	public static int getValueByDigitWeight(char vowel, int digit) {
		int num = vowelMap.get(vowel); // vowel(모음)의 순번
		return digitWeight[digit - 1] * (num - 1) + 1;	// 자릿수 가중치[자릿수 - 1] * (모음 순번 - 1) +1(다음 문자) 
	}

	public static int checkDictionary(String word) {
		int length = word.length(); // 입력받은 문자열 길이
//		문자열 길이가 1이면 자릿수1 가중치을 고려해서 return 
		if (length == 1) {
			return getValueByDigitWeight(word.charAt(0), length);
		}
//		문자열 길이가 1보다 크면
		return checkDictionary(word.substring(0, length - 1)) // 0~마지막 문자 전까지 sub String
				+ getValueByDigitWeight(word.charAt(length - 1), length); // 마지막 문자의 순번과 순번에 따른 가중치를 곱한 값
//		마지막 문자를 뺀 나머지 문자열 check 하고 마지막 문자열 자릿수 가중치&순번 고려한 값 더하기  
//		예시) 문자열이 AEIO라면 check(AEI) + 자릿수4가중치와  ;  		
	}
}
