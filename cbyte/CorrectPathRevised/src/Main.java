import java.util.*;
//import java.io.*;

public class Main {
	char character = ' ';
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static String createString(String str, int increment) {

		StringBuilder sb = new StringBuilder(); // ok
		int max = countChar(str, '?'); // ok
		String[] words = new String[max];
		words = str.split("\\?");
		Main objchar = new Main(); // ok
		// objchar.character = ' '; // ok
		Random rand = new Random(); // ok
		int[] n = new int[max]; // ok...?
		boolean wordsWasShort = false;

		if (words.length < max) {
			// We have to add a character and then remove it
			str += 'X';
			words = str.split("\\?");
			wordsWasShort = true;
		}

		//// System.out.println("Words array's length is: " + words.length);

		for (int i = 0; i < max; i++) {
			n[i] = rand.nextInt(4);
			n[i] += 1;
		}

		try {
			//// System.out.println("The random numbers are: " + Arrays.toString(n));
		} catch (ArrayIndexOutOfBoundsException h) {
			//// System.out.print("We're talking about final string here heh");
		}
		int m = 0;
		for (String word : words) {
			try {
				objchar.character = convertToChar(n[m]);
				m++;
			} catch (ArrayIndexOutOfBoundsException e) {
				objchar.character = ' ';
			}
			sb.append(word + Character.toString(objchar.character));
			//// System.out.println(sb);
		}

		//// System.out.println("TEST");
		String finalString = new String();
		finalString = sb.toString();
		char[] replace = finalString.toCharArray();
		int k = replace.length - 1;

		// System.out.println("" + replace[k]);

		if (replace[k] == 'X') {
			// System.out.println("HELlo");
			char[] scndreplace = new char[k - 1];
			for (int i = 0; i < k - 1; i++) {
				scndreplace[i] = replace[i];
			}
			String fuckoff = new String(scndreplace);
			finalString = fuckoff;
		}

		// System.out.println("The final string is: " + finalString);

		if (finalString.charAt(finalString.length() - 1) == ' ') {
			String temp2 = charRemoveAt(finalString, finalString.length() - 1);
			finalString = temp2;
			// System.out.println("The AFTER string is: " + finalString);
		}

		// System.out.println("The final string is: " + finalString);

		// These two represent the amount of r's and d's needed in the //System
		// The last two represent
		int r = 4 - countChar(str, 'r') + countChar(str, 'l');
		int d = 4 - countChar(str, 'd') + countChar(str, 'u');
		;
		int realCountRight = 4 - countChar(finalString, 'r') + countChar(finalString, 'l');
		int realCountDown = 4 - countChar(finalString, 'd') + countChar(finalString, 'u');

		// System.out.println("The string " + str + " and the final one" + finalString +
		// "of the equation needs: " + r + " rights and " + d + " downs");
		// System.out.println("There is: " + realCountRight + " rights " + " and " +
		// realCountDown + " downs" + "\n");

		return finalString;
		/*
		 * if(realCountRight == 0 && realCountDown == 0) {
		 * ////System.out.println("We're on the right track");
		 * if(CorrectPath(finalString, increment)) {
		 * //System.out.println("What is this huh: " + finalString);
		 * ////System.out.println(createString(finalString, 0)); return
		 * true;//finalString; } else { return "we failed"; } } else { // Start again
		 * because it failed increment++; //createString(str, increment);
		 * //System.out.print(increment + " "); return false; }
		 */
	}

	public static boolean CorrectPath(String str, int increment) {
		// We'll create a method which checks if the path is correct
		// for a given string

		// First, let's create a path array as a map of 5x5
		int[][] map = new int[][] { { 0, 7, 7, 7, 7 }, { 7, 7, 7, 7, 7 }, { 7, 7, 7, 7, 7 }, { 7, 7, 7, 7, 7 },
				{ 7, 7, 7, 7, 0 } };

		// Let's recall that each digit represents a different movement
		// inside the map:
		// R = [][+1] L = [][-1] D = [+1][] U = [-1][]

		// Let's check each char of the string
		// and store the position of the last char
		boolean truth = false;
		for (int s = 0, i = 0, j = 0; s < str.length(); s++) {
			// System.out.println(str.charAt(s) + " and the position is: " + s);
			try {
				if (str.charAt(s) == 'r' && map[j][i + 1] != 1) {
					i++;
					map[j][i] = 1;
					System.out.println(Arrays.deepToString(map).replace("], ", "]\n")
							.replace("0", ANSI_RED + "0" + ANSI_RESET).replace(" 1", ANSI_GREEN + " 1" + ANSI_RESET));

				} else if (str.charAt(s) == 'l' && map[j][i - 1] != 1) {
					i--;
					map[j][i] = 1;
					System.out.println(Arrays.deepToString(map).replace("], ", "]\n")
							.replace("0", ANSI_RED + "0" + ANSI_RESET).replace(" 1", ANSI_GREEN + " 1" + ANSI_RESET));

				} else if (str.charAt(s) == 'd' && map[j + 1][i] != 1) {
					j++;
					map[j][i] = 1;
					System.out.println(Arrays.deepToString(map).replace("], ", "]\n")
							.replace("0", ANSI_RED + "0" + ANSI_RESET).replace(" 1", ANSI_GREEN + " 1" + ANSI_RESET));

				} else if (str.charAt(s) == 'u' && map[j - 1][i] != 1) {
					j--;
					map[j][i] = 1;
					System.out.println(Arrays.deepToString(map).replace("], ", "]\n")
							.replace("0", ANSI_RED + "0" + ANSI_RESET).replace(" 1", ANSI_GREEN + " 1" + ANSI_RESET));

				} else if (str.charAt(s) == 'X') {
					// Do nth
					if (s == str.length() - 1) {
						if (str.charAt(0) == 'd' || str.charAt(0) == 'r') {
							truth = checkWin(i, j);
						}
					}
				} else {
					// This means we stepped on the same tile twice
					// truth = false;
					return false;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// System.out.println("There's been an ArrayOutOfBounds error");
				// truth = false;
				return false;
			}
			if (s == str.length() - 1) {

				if (str.charAt(str.length() - 1) == 'd' || str.charAt(str.length() - 1) == 'r') {
					if (str.charAt(0) == 'd' || str.charAt(0) == 'r') {
						truth = checkWin(i, j);
						// System.out.println(i + " " + j + " " + truth);
					}
				}
			}
			// This is meant as a line break
			System.out.println("");
		}
		return truth;
	}

	public static boolean checkWin(int i, int j) {
		return (i == 4 && j == 4 ? true : false);
	}

	public static int countChar(String str, char c) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static String charRemoveAt(String str, int p) {
		return str.substring(0, p) + str.substring(p + 1);
	}

	public static char convertToChar(int n) {
		char[] arr = new char[] { 'r', 'l', 'd', 'u' };
		switch (n) {
		case 1:
			return arr[0];

		case 2:
			return arr[1];

		case 3:
			return arr[2];

		case 4:
			return arr[3];

		default:
			return arr[new Random().nextInt(arr.length) + 1];
		}
	}

	public static boolean getTruth(String finalString) {

		int increment = 0;
		int r = 4 - countChar(finalString, 'r') + countChar(finalString, 'l');
		int d = 4 - countChar(finalString, 'd') + countChar(finalString, 'u');
		;

		if (r == 0 && d == 0) {
			// System.out.println("We're on the right track");
			if (CorrectPath(finalString, increment)) {

				// LAST RETURN
				System.out.println(finalString.replaceFirst("[X]$", ""));
				//// System.out.println(createString(finalString, 0));
				return true;// finalString;
			} else {
				return false;
			}
		} else {
			// Start again because it failed
			// increment++;
			// createString(str, increment);
			//// System.out.println("Increment is worth: " + increment + " ");
			return false;
		}
	}

	public static String saver(String string) {
		boolean response = getTruth(createString(string, 0));
		if (response) {
			return "";
		} else {
			// my_string = "";
			// stringy = createString(string, 0);
			saver(string);
			return "";
		}
	}

	public static void main(String[] args) {
		// keep this function call here
		Scanner scanner = new Scanner(System.in);
		System.out.println("For performance purposes, please run this in a terminal.");
		System.out.println("Please enter string path. It must be of length 8 with ?'s: ");
		System.out.print(saver(scanner.nextLine()));
		scanner.close();
	}
}

//drdr??rrddd?
//???rrurdr?
//r?d?drdd				rrdrdrdd
//ddd?uru??ddd			dddrururrddd
//rd?u??dld?ddrr		rdrurrdldlddrr
//ddr?rdrrd?dr			ddrurdrrdldr
//rdrdr??rddd?dr		rdrdruurdddldr
//rrrr????				rrrrdddd
//dddd?uuuurrr????		ddddruuuurrrdddd
