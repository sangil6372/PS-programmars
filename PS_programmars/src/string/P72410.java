package string;

public class P72410 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String solution(String new_id) {
        
//      소문자로 변경
        new_id = new_id.toLowerCase();
//      소문자 숫자 _ . 제외하고 다 제거 
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
//      마침표 2번 이상 연속된 부분을 하나로 치환
        new_id = new_id.replaceAll("\\.+", ".");
//      마침표가 처음이나 끝에 위치하면 제거 
        new_id = new_id.replaceAll("^\\.+|\\.+$", "");
//      빈 문자열이면 a대입
        if (new_id.isEmpty()) new_id = "a";
//      16자 이상이면 처음 15개 제외한 나머지 제거 제거하고 마침표가 마지막이면 마침표 제거
        if (new_id.length()>=16) {
        	new_id = new_id.substring(0,15);
        	new_id = new_id.replaceAll("\\.+$","");
        }
//      2자 이하면 3이 될때까지 마지막 문자 반복해서 붙임
        while(new_id.length()<=2) {
        	new_id += new_id.charAt(new_id.length()-1);
        }
        
        return new_id;
    }
	
}
