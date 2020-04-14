
public class Main {

	public static String BinaryReversal(String int_str) {
		// code goes here

		// Store the binary version of the integer
		String bin_str = Integer.toBinaryString(Integer.parseInt(int_str));

		// In order to reverse it, we need to convert it into a StringBuilder
		StringBuilder sb = new StringBuilder(bin_str);
		int strlength = sb.length();
		sb.reverse();

		// Add the necessary 0's to the end so that the string has a length of 8
		// characters
		for (int i = 1; i < 100; i++) {
			for (int j = strlength; j < 8 * i; j++) {
				sb.append('0');
			}
			if (sb.length() == 8 * i) {
				break;
			}
		}
		// Convert the StringBuilder back to a binary string, then decimal integer, then
		// decimal string
		return Integer.toString(Integer.parseInt(sb.toString(), 2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num_string = "15487793"; // Provide int as a string
		System.out.println(BinaryReversal(num_string));
	}

}
