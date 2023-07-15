package bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P67257 {

	public static void main(String[] args) {
	}

//	연산자의 6가지 우선순위
	static String[][] precedences = {
			"+-*".split(""),
			"+*-".split(""),
			"-+*".split(""),
			"-*+".split(""),
			"*+-".split(""),
			"*-+".split(""),
	};
	
	private long calculate(long lhs, long rhs, String op) {
		switch (op) {
		case "+" :
			return lhs + rhs;
		case "-" :
			return lhs - rhs;
		case "*" :
			return lhs * rhs;
		default:
			return 0;
		}
	}
	
	private long calculate(List<String> tokens, String[] precedence) {
		for (String op : precedence) {
			for (int i = 0;i<tokens.size();i++) {
//				토큰이 연산자면 좌우 연산
				if (tokens.get(i).equals(op)) {
					long lhs = Long.parseLong(tokens.get(i-1));
					long rhs = Long.parseLong(tokens.get(i+1));
					long result = calculate(lhs,rhs,op);
//					연산 후 연산 결과로 토큰 대체
					tokens.remove(i-1);
					tokens.remove(i-1);
					tokens.remove(i-1);
					tokens.add(i-1, String.valueOf(result));
					i-=2; 
				}
			}
		}
		return Long.parseLong(tokens.get(0)); // 하나 남은 최종 결과 return  
	}
	
	public long solution(String expression) {
//		expression을 "+-*"로 구분하고 구분자도 토큰으로 간주하도록 설정 
		StringTokenizer tokenizer = new StringTokenizer(expression, "+-*", true);
		List<String> tokens = new ArrayList<>();
//		리스트로 토큰들 옮겨 담음
		while(tokenizer.hasMoreTokens()) {
			tokens.add(tokenizer.nextToken());
		}
		
		long max = 0;
		for (String[] precednce : precedences) {
//			계산하면서 가장 큰 값을 구함
			long value = Math.abs(calculate(new ArrayList<>(tokens), precednce));
			max = Math.max(value,max);
		}

		return max;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
