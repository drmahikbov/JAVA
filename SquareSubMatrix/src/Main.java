import java.util.*; 
//import java.io.*;

public class Main {

		/* For some reason, this program only works on www.coderbyte.com due to a problem with the input string array
		and is also meant to work with a matrix of 16 elements max */




	public static String MaximalSquare(String strArr[]) { 
		  
		char[][] normArr = new char[strArr.length][];
		int response = 1;
		int reg = 0;
		boolean response2_1 = false, response2_2 = false, response2_3 = false;
		boolean response3_1 = false, response3_2 = false;
		boolean response4 = false;

    	for(int i = 0; i < strArr.length; i++) {
    		normArr[i] = strArr[i].toCharArray();
    	}

    	if(reg + 1 < strArr.length) {
    	response2_1 = twobytwo(normArr[reg], normArr[reg + 1]);
    	reg++;
    	} else if(reg < strArr.length) {
    	response2_2 = twobytwo(normArr[reg], normArr[reg + 1]);
    	reg++;
    	} else if(reg - 1 < strArr.length) {
    	response2_3 = twobytwo(normArr[reg], normArr[reg + 1]);
    	reg = 0;
    	}

    	reg = 0;

    	if(reg + 2 < strArr.length) { // Here 3 numbers are enough
    	response3_1 = threebythree(normArr[reg], normArr[reg + 1], normArr[reg + 2]);
    	reg++;
    	System.out.println(response3_1);
    	} else if(reg + 2 < strArr.length) { // Here we need 4 numbers
    	response3_2 = threebythree(normArr[reg], normArr[reg + 1], normArr[reg + 2]);
    	reg = 0;
    	}

    	reg = 0;

    	if(reg + 3 < strArr.length) {
    	response4 = fourbyfour(normArr[reg], normArr[reg + 1], normArr[reg + 2], normArr[reg + 3]);
    	reg = 0;
    	}

    	if(response2_2 || response2_1 || response2_3) {
    		response = 4;
    	}

    	if(response3_2 || response3_1) {

    		response = 9;
    	}

        if(response4) {
            response = 16;
        }

    	return Integer.toString(response);
	} 
		  
	public static boolean twobytwo(char[] a, char[] b) {
     
     	int pos;
     	boolean r1 = false, r2 = false;
     	int area = 0;
     
     	for(int i = 0; i < 4; i ++) {
         	//We're checking for a square of side 2
         	//System.out.println("The digit being examined is: " + a[i]);
         	if(i < 3) {
              if (a[i] == 49 && a[i + 1] == 49) {
            //    System.out.println("We found two consecutives 1's at position: " + i + " and " + i + " plus one");
                pos = i;
                r1 = true;
                		if (b[pos] == 49 && b[pos + 1] == 49) {
                		//System.out.println("The second array has to 1's at the same position: " + i + " and " + i + " plus one");
                		r2 = true;
            			} 
            	} 

         	}
     	}
     	if (r1 && r2) {
     		area = 4;
     		return true;
     	} else {
     		return false;
     	}
 
  	}

  	public static boolean threebythree(char[] a, char[] b, char[] c) {
  		int pos;
     	boolean r1 = false, r2 = false, r3 = false;
     	int area = 0;

     	    for(int i = 0; i < 4; i ++) {
         	 //We're checking for a square of side 3
         	 //System.out.println("The digit being examined is: " + a[i]);
         	 if(i < 2) {
              	if (a[i] == 49 && a[i + 1] == 49 && a[i + 2] == 49) {
                //System.out.println("We found three consecutives 1's starting at position: " + i);
                pos = i;
                r1 = true;
                		if (b[pos] == 49 && b[pos + 1] == 49 && b[i + 2] == 49) {	
                		//System.out.println("The second array has three 1's at the same position: " + i);
                		r2 = true;
                			   if (c[pos] == 49 && c[pos + 1] == 49 && c[i + 2] == 49) {
                				//System.out.println("The third array has three 1's at the same position: " + i);
                				r3 = true;
            					} 
            			} 

         		}
     		 }
  			}

				if (r1 && r2 && r3) {
     				area = 9;
     				return true;
     				} else {
     				return false;
     				}

  	}

  	public static boolean fourbyfour(char[] a, char[] b, char[] c, char[] d) {

  		int area = 0;

  			StringBuilder sb = new StringBuilder();
  			for(int i = 0; i < a.length; i++) {
  				sb.append(a[i]);
  				sb.append(b[i]);
  				sb.append(c[i]);
  				sb.append(d[i]);
  			}
  			String str = sb.toString();

  		if (containsOnly(str, "1")) {
  			area = 16;
  	     	return true;
     	} else {
     		return false;
     	}

  	}


  	public static boolean containsOnly(String str, String certain){

     return str.matches("[" + certain + "]*");
    }

	public static void main (String[] args) {  
		    // keep this function call here     
			  
			  Scanner s = new Scanner(System.in);
			  s.close();
			  String elements[] = new String[4];
			  
			  for(int i = 0; i < 4; i++){
			      System.out.println("Please enter an element");
			      elements[i] += s.next() + " ";
			  }
		     System.out.print(MaximalSquare(elements));    
	}   
		  

}
