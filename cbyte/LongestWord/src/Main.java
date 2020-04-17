
import java.util.*;
import java.io.*;

class Main {
	public static String LongestWord(String sen) {

		String[] words = sen.split("\\s+");

		int longest = 0;
		String big = "";

		for (int i = 0; i < words.length; i++) {

			words[i] = words[i].replaceAll("[^\\w]", "");
		}

		for (int j = 0; j < words.length; j++) {
			if (words[j].length() > longest) {
				longest = words[j].length();
				big = words[j];
			}
		}

		// Math.max.apply(null, s.split(' ').map(w => w.length));

		return big;

	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(LongestWord(s.nextLine()));
	}

}
