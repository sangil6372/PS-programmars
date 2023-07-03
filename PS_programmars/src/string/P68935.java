package string;

public class P68935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public static  int solution(int n) {
	        int answer = 0;
//	        3진법을 문자열로 바꾼다음 뒤집기
	        
	        String str = Integer.toString(n, 3);
	        
	        String reversed = new StringBuilder(str).reverse().toString();

	        
	        answer = Integer.parseInt(reversed, 3);
//	        parseInt와 valueOf의 차이는? -> Int 반환 / Integer 반환
//	  		NumberFormatException시 null객체 반환 여부가 좀 큰 듯
	        
	        
	        return answer;
	    }
	
}
