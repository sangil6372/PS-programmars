package string;

public class P12926 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution("z",1));
	}
	
	
	    public static String solution(String s, int n) {
	     
	        StringBuilder sb = new StringBuilder();
	        
	        
	        
	        for (char c : s.toCharArray()) {
	        	
	        	int offset = Character.isUpperCase(c)?'A':'a';    	
	        	int position = c - offset;
	        	
	        	if (!Character.isAlphabetic(c)) sb.append(c);
	        	else {
	        		position = (position+n)%('z'-'a'+1);
	        		sb.append((char)(offset+position));
	        	}
	        	
	        }
	        
	        
	        
	        return sb.toString();
	    }
	
	
	
}
