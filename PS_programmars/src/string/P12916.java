package array;

public class P12916 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean solution(String s) {
        boolean answer = true;
        
        s = s.toLowerCase();
       
        int ps = s.length()-s.replace("p", "").length();
        int ys = s.length()-s.replace("y", "").length();

        
        if (ps==ys) answer = true;
        else answer = false;
        
        return answer;
    }
}
