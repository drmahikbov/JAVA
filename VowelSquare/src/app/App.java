package app;

import java.util.Arrays;

public class App {
    public static String VowelSquare() {
        String[] strArr = new String[] {"gg", "ff"};
        char[][] matrix  = new char[strArr.length][1];
        String temp = "";
        for (int i = 0; i < strArr.length; i ++) {
            temp = strArr[i];
            matrix[i] = temp.toCharArray();
        }

        //System.out.println(Arrays.deepToString(matrix).replaceAll("],", "] \n")); 

        for (int j = 0; j < matrix.length; j++) {    
            for (int i = 0; i < matrix[j].length; i++) {
                if (isVowel(matrix[j][i]) && i + 1 < matrix[j].length) {
                    //System.out.println("Last letter was a vowel and next one exists: " + i + " : " + j);
                    if (isVowel(matrix[j][i + 1]) && j + 1 < matrix.length) {
                        //System.out.println("Last letter was a vowel and one down exists: " + i + " : " + j);
                        if (isVowel(matrix[j + 1][i])) {
                            //System.out.println("One down is a vowel: " + i + " : " + j);
                            if (isVowel(matrix[j + 1][i + 1])) {
                                //System.out.println("There is a square: " + i + " : " + j);
                                return String.valueOf(j) + "-" + String.valueOf(i);
                            }
                        }
                    }
                }
                //System.out.println("Values for i and j are:  " + i + " : " + j);
                //System.out.println("");
            }  
        }

        return "not found"; 
    }
    public static void main(String[] args) throws Exception {
        System.out.println(VowelSquare());
    }

    public static boolean isVowel(char c) {
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (c == vowels[i]) {
                return true;
            }
        }
        return false;
    }
}