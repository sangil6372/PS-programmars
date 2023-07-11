package sort;

public class P12917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String solution(String s) {
        return s.chars()	// Int스트림으로 변환한다
        		.boxed()	// Integer로 타입을 변경한다
        		.sorted((v1,v2)->v2-v1)	// 내림차순으로 정렬
        		.collect(StringBuilder::new,	// StringBuilder의 생성자를 참고해서 반환 객체를 명시한다
        				StringBuilder::appendCodePoint, // Stream원소를 어떻게 누적할지 정의한다 문자로 누적하기 위해서 append가 아닌 저것을 썼다
        				StringBuilder::append)	// 반환할 객체가 여러개 있을 때 합치는 방식을 명시한다 멀티쓰레드 환경에서 의미가 있다
        		.toString();
    }
	
}
