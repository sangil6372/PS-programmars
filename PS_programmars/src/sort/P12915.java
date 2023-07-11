package sort;

import java.util.Arrays;

public class P12915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String[] solution(String[] strings, int n) {
       
//		Comparator 객체를 생성하지 않고 람다식으로 처리하자 
        Arrays.sort(strings, 
		(s1,s2)-> {
//			문자열의 특정 번재에 있는 문자를 서로 비교해서 같지 않을 경우 비교해서 재배치 ㄱ
			if (s1.charAt(n) != s2.charAt(n)) {
				return s1.charAt(n)-s2.charAt(n);
			}
//			같을 경우엔 사전 순으로 정렬하는 방식 String의 compareTo를 이용하자 
			return s1.compareTo(s2);
        
        
        });
        
        
        return strings;
    }
//	문자열 배열을 어떤 특정 방식으로 정렬하는데 Comparator 를 사용하면 된다.

}
