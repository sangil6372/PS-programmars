package stack;

import java.util.Stack;

public class P76502 {
	private boolean isCollect(StringBuilder str) {
		Stack<Character> stack = new Stack<>(); // 짝을 판별할 Stack

		for (int i = 0; i < str.length(); i++) { // 0번째 문자부터 차례대로 순회
			char c = str.charAt(i);
			switch (c) {
			case '(':
				stack.push(')');
				break;
			case '{':
				stack.push('}');
				break;
			case '[':
				stack.push(']');
				break;
			case ')', ']', '}': // 자바12부터 가능한 문법
				if (stack.isEmpty()) // 비교할 게 없으면 false
					return false;
				if (stack.pop() != c) // 짝이 안 맞으면 false
					return false;
				break;
			}
		}
		return stack.isEmpty(); // 비어있지 않으면 짝이 안 맞는다는 것
	}

	public int solution(String s) {
		StringBuilder str = new StringBuilder(s); // StringBuilder 타입으로 뮨자열을 회전(변경)시키기 위함 / String은 immutable한 객체라서
		int count = 0; // 횟수 저장할 변수

		for (int i = 0; i < str.length(); i++) { // 단순히 반복횟수 용됴의 for문
			char firstChar = str.charAt(0); // 첫 번째 문자 저장
			str.deleteCharAt(0); // 첫 번째 문자 삭제
			str.append(firstChar); // 첫 번째 문자를 맨 뒤에 추가
			if (isCollect(str))
				count++;
		}
		return count;
	}

}
