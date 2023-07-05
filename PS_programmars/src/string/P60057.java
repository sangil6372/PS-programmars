package string;

import java.util.ArrayList;
import java.util.List;

public class P60057 {

	public static void main(String[] args) {
		
	}
	
	public static int solution(String s) {
        
        int min = Integer.MAX_VALUE;
        
        for (int length = 1;length<=s.length();length++) {
        	int compressed = compress(s,length);
        	min = Math.min(min,compressed);
        }
        
        return min;
    }

	public static int compress(String s, int length) {
		StringBuilder sb = new StringBuilder();
		
		String last = ""; // 직전 문자얄
		int count =0;
		
		for (String token : split(s,length)) {
			if (token.equals(last)) {
				count++;
			}else {
				if (count>1) sb.append(count);
				count = 1;
				sb.append(last);
				last = token;
			}
		}
		if (count>1) sb.append(count);
		sb.append(last);
		
		return sb.length();
	}
	
//	length 길이 만큼 문자열을 자르기 
	public static List<String> split (String s, int length){
		List<String> tokens = new ArrayList<>();
		
		for (int start=0; start<s.length();start+=length) {
//			end가 범위를 벗어나면 end는 끝
			int end = start+length;
			if (end>s.length()) end = s.length();
			tokens.add(s.substring(start, end));
		}
		return tokens;
	}	
}
