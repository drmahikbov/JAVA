import java.util.*;
import java.io.*;


public class Main {

	public static String EightQueens() {
		String[] strArr =  new String[]{"(7,1)", "(7,2)", "(4,3)", "(6,4)", "(8,5)", "(2,6)", "(5,7)", "(3,8)"};
		String lefts = Arrays.toString(strArr).replaceFirst("\\[", "").replaceFirst("\\]", "").replaceAll("'*", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(", ", "X").replaceAll(",[\\d]", "");
		String rights = Arrays.toString(strArr).replaceFirst("\\[", "").replaceFirst("\\]", "").replaceAll("'*", "").replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(", ", "X").replaceAll("[\\d],", "");	
		
		// Store the x and y coordinates in separate arrays
		String[] x = lefts.split("X");
		String[] y = rights.split("X");
		int[] xs = new int[x.length];
		int[] ys = new int[y.length];
		int k = 0;
		for(String n : x) {
			xs[k] = Integer.valueOf(n) - 1;
			//System.out.println(xs[k]);
			k++;
		}
		k = 0;
		for(String n : y) {
			ys[k] = Integer.valueOf(n) - 1;
			//System.out.println(ys[k]);
			k++;
		}
		
		
		
		int[][] coord = new int[][] {xs, ys};
		
		int pos = 77;
		// Let's now check for any matching x's or y's 
		for(int j = 0; j < 2; j++) {
			//OUTER_LOOP: 
			for(int i = 0; i < 8; i++) {
				for(int b = i + 1; b < 8; b++) {
					System.out.println("Testing:" + coord[j][i] + "+1 " + coord[j][b] + "+1");
					if(coord[j][i] == coord[j][b]) {
						System.out.println(j + " " + i + " " + b);
						pos = i;
						System.out.print(strArr[i]);
						b = 7;
						i = 7;
						j = 1;
						
					}
			  }
			}
		}
		
		
		int diag = 77;
		// Let's now check if they can take each other out via diagonals
			for(int i = 0; i < 8; i++) {
				for(int b = i + 1; b < 8; b++) {
					System.out.println("Comparing diagonals of x: " + coord[0][i] + "+1 " + coord[0][b] + "+1");
					System.out.println("Comparing diagonals of y: " + coord[1][i] + "+1 " + coord[1][b] + "+1 \n");
					int diffX = (coord[0][i] > coord[0][b]) ? coord[0][i] - coord[0][b] : coord[0][b] - coord[0][i];
					int diffY = (coord[1][i] > coord[1][b]) ? coord[1][i] - coord[1][b] : coord[1][b] - coord[1][i];
					if(diffX == diffY) {
						String result = strArr[i];
						diag = i;
						System.out.println(strArr[diag]);
						b = 7;
						i = 7;
						break;
						//return strArr[i];
						//return ("(" + coord[0][b] + "," + coord[1][b] + ")");
				}		
			  }
			}
		

			
		return (pos < diag && pos != 77 ? strArr[pos] : diag < pos && diag != 77 ? strArr[diag] : pos == 77 && diag == 77 ? "true" : /* This means pos and diag are equal, therefore we could use both as indexes*/ strArr[pos]);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(EightQueens());
	}

}
