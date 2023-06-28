package string;

public class P12930 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("absdfAdfas"));
	}
	
	public static String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        int i  = 0;
        for (char c  : s.toCharArray()) {
        	if (!Character.isAlphabetic(c)) {
        		sb.append(c);
        		i=0;
        		continue;
        	}
        	
        	//        	짝수면 대문자로 바꾸자
        	if (i++%2==0) {
        		if (Character.isUpperCase(c)) {
        			sb.append(c);
        			continue;
        		}
        		else {
        			sb.append((char)(c-'a'+'A'));
        		}
        	}
        	else {
        		if (!Character.isUpperCase(c)) {
        			sb.append(c);
        			continue;
        		}
        		else {
        			sb.append((char)(c-'A'+'a'));
        		}
        	}
        }
        
        
        return sb.toString();
    }
}
