package bruteForce;

import java.util.stream.IntStream;

public class P42840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static final int[][] RULES = {
			{1,2,3,4,5},
			{2,1,2,3,2,4,2,5},
			{3,3,1,1,2,2,4,4,5,5}
	};
	
	public int getPicked(int person, int problem) {
		int[] rule = RULES[person];
		int index = problem%rule.length;
		return rule[index];
		
	}
	
	
	 public int[] solution(int[] answers) {
	     
		 int[] corrects = new int[3];
		 int max= 0;
		 
		 for (int problem = 0;problem<answers.length;problem++) {
			 int answer = answers[problem];
//			 세 유형의 사람 
			 for(int person = 0; person < 3;person++) {
				 int picked = getPicked(person, problem); // 고른 답
				 if(answer == picked) { 	// 맞으면 
					 if(++corrects[person]>max) {	
						 max = corrects[person];	// 가장 많이 맞힌 사람의 정답 개수 = max
					 }
				 } 
			 }
		 }
		 
		 final int maxCorrects = max;
		 return IntStream.range(0,3)
				 .filter(i -> corrects[i]==maxCorrects)	// 가장 많이 많은 사람의 인덱스 
				 .map(i->i+1)
				 .toArray();
		 
		 
	 }

}
