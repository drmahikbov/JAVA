import java.util.*;
public class Main {
	public static String DNA() {

		String dna = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";		
		String array[][] = new String[dna.length()-9][1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < dna.length()-9; i++) {
			array[i][0] = dna.subSequence(i, i+10).toString();
		}
		
		for(int i = 0; i < dna.length()-9; i++) {
			for(int j  = i + 1; j < dna.length()-9; j++) {
				if(Objects.equals(array[i][0], array[j][0])) {
					sb.append(array[i][0] + " ");
				}
			}
		} 
		
		//System.out.print(Arrays.deepToString(array).replaceAll("], ", "], \n"));
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(DNA());
	}

}
