package string;

public class P81301 {

	private static final String[] words = {
			"zero", "one", "two", "three", "four", "five","six"
			, "seven", "eight","nine"
	};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}

	 public static int solution(String s) {
	        int answer = 0;

	        for (int i =0;i<words.length;i++) {
	        	s=s.replace(words[i], Integer.toString(i));
	        }
	        answer = Integer.parseInt(s);
	        
	        return answer;
	    }
	
}
