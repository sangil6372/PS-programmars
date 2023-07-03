package string;

public class P70129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("01110").toString()
);
	}
	
//	제거한 0의 개수도 저장해야 함
	
	public static int[] solution(String s) {       
        int cnt = 0;	// 시행 횟수
        int zeros = 0;	// 0 개수 
        while(!s.equals("1")) {
        	cnt++;
        	int newLength = s.replace("0", "").length();	// 0을 제거한 갯수
        	zeros += s.length() - newLength;		// 0 개수 = 전체 - 0제거한 갯수
        	s =  Integer.toBinaryString(newLength);		// 남은 개수 이진법으로 String
        }
        
        return new int[] {cnt,zeros};
    }
}
