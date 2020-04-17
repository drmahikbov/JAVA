import java.util.Arrays;

public class Main {

	public static String LetterChange(String str) {

		char[] chars = str.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 97 && chars[i] <= 122) {
				chars[i] = (char) (chars[i] + 1);
				if ((chars[i] == 'a') | (chars[i] == 'e') | (chars[i] == 'i') | (chars[i] == 'o') | (chars[i] == 'u')) {
					chars[i] = (char) (chars[i] - 32);
				}
			}
		}
		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(LetterChange("a confusing /:sentence:/[ this is not!!!!!!!~"));

	}

}
