package string;

public class P12918 {

	public static void main(String[] args) {

	}

	public boolean solution(String s) {

//	        정규식을 통해서 매치하는지 판단
//	        answer = s.matches("[0-9]{4}|[0-9]{6}");

		if (s.length() != 4 && s.length() != 6)
			return false;

		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}

		return true;
	}

}
