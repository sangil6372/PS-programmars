package string;

public class P12932 {

	public static void main(String[] args) {
		System.out.println(solution(12345));
	}

	public static int[] solution(long n) {
		
		// 방법 1
//        int length = Long.toString(n).length();
//        
//        int[] answer = new int[length];
//        
//        
//        for (int i = 0;i<length;i++) {
//        	answer[i] = (int) (n%10);
//        	n/=10;
//        	System.out.println(answer[i]);
//        }
        
		
//		 문자열 방식 방법 2
		String str = Long.toString(n);
		StringBuilder reversed = new StringBuilder(str).reverse();
		
		
		int[] answer = new int[str.length()];
		for (int i = 0;i<str.length();i++) {
			answer[i] = reversed.charAt(i) - '0';
		}
		
        
        return answer;
    }
	
}
