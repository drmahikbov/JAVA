import java.util.*;
//import java.io.*;
public class Main {
 public static String ScaleBalancing(String thisStringIsUseless) { 
 	   // Unfortunately, we have to manually type in the input data
 	   String strArr[] = new String[2];
 	   strArr[0] = "[13, 4]";//[6, 1]
 	   strArr[1] = "[1, 2, 3, 6, 14]";//[6, 11, 1, 4]
       // Store the weights and the available ones as integers
       int sSum = Integer.valueOf(strArr[0].replaceAll("^[\\[]\\d+, ", "").replaceFirst("\\]$", ""));
       int fSum = Integer.valueOf(strArr[0].replaceAll(", \\d+[\\]]$", "").replaceFirst("\\[", ""));
       if(fSum == sSum){
       return "not possible";
       }
       //System.out.println("First number is: " + fSum);
       //System.out.println("First number is: " + sSum);
       String[] words = strArr[1].split("[^\\d]");
       int numbers[] = new int[1 + words.length/2];
       for(int i = 1, j = 0; i < words.length; i += 2) {
           numbers[j + 1] = Integer.parseInt(words[i]);
           j++;
       }
        int fArrAdded[][] = new int[numbers.length][numbers.length - 1];
        int sArrAdded[][] = new int[numbers.length][numbers.length - 1];
        for(int i = 0, j = 0; j < numbers.length; i++) {
       fArrAdded[j][i] = fSum + numbers[j] + numbers[i + 1];
       sArrAdded[j][i] = sSum + numbers[j] + numbers[i + 1];
       if(i == numbers.length - 2) {
           i = 0;
           j++;
       }
   }
   System.out.println(Arrays.deepToString(fArrAdded).replace("], ", "]\n"));
   System.out.println("");
   System.out.println(Arrays.deepToString(sArrAdded).replace("], ", "]\n"));
   System.out.println(""); 
   System.out.println(fArrAdded[0]);
   int frow = 0, srow = 0, fcol = 0, scol = 0;
   boolean truthAboutSrows = false, srowMoving = true;
   while(fArrAdded[fcol][frow] != sArrAdded[scol][srow]) {
   // As long as we're dealing with one weight per array, only increment the first one
       frow = (scol == 0) ? frow + 1 : 0;
       if(srowMoving == false) {
       srow = 0;
       } else {
         srow = (fcol > 0 || truthAboutSrows) ? srow + 1 : srow;        
       }
       // Debugging purposes
       //System.out.println(frow + " : " + srow);
       //System.out.println(fcol + " : " + scol);
       // If the first array with one weight has been scanned, then do it again with another value of the second array with one weight
       if(frow == fArrAdded[0].length && fcol < 1) {
           frow = 0;
           fcol = 0; 
           scol = 0;
           srow++;
       }
       // When both one weight arrays have been completely scanned, start scanning the whole second array with the first number, as the two weights are used in the second array
       if(srow == sArrAdded[0].length) {
           frow = 0;
           srow = 0;
           fcol = 0;
           scol++;
           truthAboutSrows = true;
           if(fArrAdded[0][0] == 0) {
        	   srow = 1;
           }
           
       }
       // When the second array has been completely scanned, compare the first array to the second number
       if(scol == sArrAdded.length) {
    	   System.out.print("TEST");
       scol = 0;
       srow = 0;
       frow = 0;
       fcol++;
       srowMoving = false;
       	if(sArrAdded[0][0] == 0) {
       		frow = 1;
       	}
       }
       // Compare each row of the first array
       if(fcol > 0 && frow == fArrAdded[0].length) {
       srow = 0;
       frow = 1;
       scol = 0;
       fcol++;
       }
       // If everything has been scanned, then there is no possible outcome
       if(fcol == fArrAdded.length) {
       return "not possible";
       }
       System.out.println("Trying:  " + fArrAdded[fcol][frow] + " : " + sArrAdded[scol][srow]);
   }
   //System.out.println("The coordinates to match back are: " + fcol + " : " + frow + "\t" + scol + " : " + srow);
   ////System.out.println(numbers[fcol] + numbers[frow]);
    int results[] = new int[] {numbers[fcol] + 1, numbers[scol] + 1, numbers[frow] + 1, numbers[srow] + 1};
    int newresults[] = new int[2];
    Arrays.sort(results);
    for(int i = 0; i < 2; i++) {
        newresults[i] = results[i + 2] - 1;
    }
	StringBuilder sb = new StringBuilder();
        if(newresults[0] != 0 && newresults[1] != 0) {
        	System.out.println("Both are 0");
            sb.append(newresults[0] + "," + newresults[1]);
        } else {
        sb.append(newresults[1]);
        System.out.println("only 1 is 0");
        }
    String aANSWEEER = new String(sb);
    return aANSWEEER;
 }
 public static void main (String[] args) {  
   // keep this function call here    
   Scanner s = new Scanner(System.in);
   System.out.print(ScaleBalancing(s.nextLine())); 
   s.close();
 }  
}