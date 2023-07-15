package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class P42746 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
// 문제 : 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	
	 public String solution(int[] numbers) {
	     return Arrays.stream(numbers)
//	    		 String타입으로 변경
	    		 .mapToObj(String::valueOf)
//	    		 뒤집어 붙인게 더 크면 스왑 
	    		 .sorted((s1,s2)->{
	    			 int seq = Integer.parseInt(s1+s2);
	    			 int rev = Integer.parseInt(s2 + s1);
	    			 return rev - seq;
	    		 })
//	    		 스트림을 하나의 문자열로 구성
	    		 .collect(Collectors.joining(""))
//	    		 앞에 0을 제거 
	    		 .replaceAll("^0+", "");
		 
		 
	 }
	
}
