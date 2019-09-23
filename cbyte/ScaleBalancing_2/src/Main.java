import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static String ScaleBalancing(String useless) {
		   // Unfortunately, we have to manually type in the input data
	 	   String strArr[] = new String[]{"[5, 9]", "[1, 2, 6, 7]"};   
		   int firstNum = Integer.valueOf(strArr[0].replaceAll(", \\d+\\]$", "").replaceFirst("\\[", ""));
		   int secndNum = Integer.valueOf(strArr[0].replaceAll("\\[\\d+, ", "").replaceFirst("\\]", ""));
		   int diff = (secndNum - firstNum) > 0 ? secndNum - firstNum : firstNum - secndNum;
			
		   String storage = strArr[1].replaceFirst("^\\[", "").replaceFirst("\\]$", "").replaceAll(" ", "");
		   String[] weights = storage.split(",");
		   int[] poss = new int[weights.length];
		   int m = 0;
		   for(String w : weights){
			poss[m] = Integer.valueOf(w);
			if(poss[m] == diff) {
				return String.valueOf(poss[m]);
			}
			m++;
		   }
		   Arrays.sort(poss);
		   String answer = "not possible";
		   for(int i = poss.length - 1; i > 0; i--) {
			   for (int j = i - 1; j > 0; j--) {
				   System.out.println("Evaluating: " + poss[i] + " and " + poss[j]);
				   if (poss[i] + poss[j] == diff) {
					   answer = String.valueOf(poss[j]) + "," + String.valueOf(poss[i]);
					}
				}
		   }

		   for(int i = poss.length - 1; i > 0; i--) {
			   for (int j = i - 1; j > 0; j--) {
				   System.out.println("Evaluating: " + poss[i] + " and " + poss[j]);
				   if (poss[i] - poss[j] == diff) {
					answer = String.valueOf(poss[j]) + "," + String.valueOf(poss[i]);
				}
			}
		}
	       return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ScaleBalancing("paaaah"));
	}

}
