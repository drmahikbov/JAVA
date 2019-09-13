import java.util.Arrays;
import java.util.Scanner;

/** 
 * 
 */

/** 
 * @author mahike
 *
 */
public class Main {

	/**
	 * @param args
	 */ 

		  public static void main (String[] args) {  
			    // keep this function call here     
			    Scanner s = new Scanner(System.in);
				System.out.print(KaprekarsConstant(s.nextInt())); 
				s.close();
			  } 

		  public static int KaprekarsConstant(int num) { 
			    //The number we want to return
			    int it = 1;
			    int result = Subs(num);
			  
			    while (result != 6174) {
			        result = Subs(result);
			        it++;
			    }
			 
			    return it;
			  } 
			  
			  public static int Subs(int n) {
			      
			    int number = smallNum(n);
			    //int number = n;
			    //System.out.println("The input number is " + number);
			    
			    boolean b = checkNum(number);
			    if (b) {
			        

			    //Let's take each digit separately
			    int r1 = number % 10;
			    int r2 = (number % 100 - r1) / 10;
			    int r3 = (number % 1000 - (number % 100) ) / 100;
			    int r4 = number / 1000;
			  
			    //Let's put each digit into an array
			    int arr[] = new int[4];
			    arr[0] = r1;
			    arr[1] = r2;
			    arr[2] = r3;
			    arr[3] = r4;
			    
			    //We have to sort the array from least to greatest digit and then create two numbers from it
			    Arrays.sort(arr);
			    int maximum = 1000 * arr[3] + 100 * arr[2] + 10 * arr[1] + arr[0];
			    int minimum = 1000 * arr[0] + 100 * arr[1] + 10 * arr[2] + arr[3];
			    
			    int sub = maximum - minimum;
			    return sub;
			    }
			    else {
			        System.out.println("Your input number needs to have at least one digit different from the others");
			        return number;
			    }
			  }
			  
			  public static boolean checkNum(int number) {
			      
			    int v1 = number % 10;
			    int v2 = (number % 100 - v1) / 10;
			    int v3 = (number % 1000 - (number % 100) ) / 100;
			    int v4 = number / 1000;
			    
			    if ( v1 == v2 && v1 == v3 && v1 == v4 && v2 == v3 && v2 == v4 && v3 == v4 ) {
			        return false;
			    } else {
			        return true;
			    }
			  }
			  
			  public static int smallNum(int n) {
			      if (n > 100 && n < 1000) {
			          return n*10;
			      } else if (n < 100 && n > 10) {
			          return n*100;
			      } else if (n < 10) {
			          return n*1000;
			      } else /*if (n > 999)*/ {
			          return n;
			      }
			  }
}
