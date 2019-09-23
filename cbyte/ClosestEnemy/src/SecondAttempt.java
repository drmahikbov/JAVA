import java.util.*;
import java.io.*;

	class SecondAttempt {

		public static String ClosestEnemy() {
			
			/*String[] sa = new String[] {"0000",
										"2010", 
										"0000", 
										"2002"};
			*/
			// Some other test cases
			//String[] sa = new String[] {"0000", "1000", "0002", "0002"};
			// Supposed 2
			//String[] sa = new String[] {"01200", "00020", "00000", "00002", "02002"};
			// Supposed 1
			//String[] sa = new String[] {"01000", "00000", "00000", "00000", "00000"};
			// Supposed 0
			//String[] sa = new String[] {"00000", "10020", "00000", "00002", "02002"}; 
			// Supposed 2	
			String[] sa = new String[] {"000", "100", "200"}; 
			// Supposed 2					

			// Count the amount of 2's
			int count = Arrays.toString(sa).length() - Arrays.toString(sa).replaceAll("2","").length();

			// Create an array to store the 2's and an integer to store the 1
			int[] twos = new int[count*3];
			int[] ones = new int[3];

			// First of all, let's go through each character in the array
			int k = 0;
			for (int i = 0; i < sa.length; i++) {
				for (int j = 0; j < sa[0].length(); j++) {		

					if (sa[i].charAt(j) == '2') {
						twos[k] = 100*i + j;
						k++;
						// Don't forget to mirror everything
						twos[k] = 100*(i+sa[0].length()) + j;
						k++;
						twos[k] = 100*i + j + sa[0].length();  
						k++;
					} else if (sa[i].charAt(j) == '1') {
						ones[0] =	100*i + j;
						ones[1] = 100*(i+sa[0].length())+ j;
						ones[2] = 100*i + j + sa[0].length();	
									
					}
					// If it's a 0 we don't care
					}
				}
			System.out.println("twos: " + Arrays.toString(twos));
			System.out.println("ones: " + Arrays.toString(ones));

			// Let's take the differences and store them in an array
			int[] diff = new int[twos.length*ones.length];
			//diff[0] = 10000000; // Placeholder number

			if (twos.length == 0) {
				return "0";
			} else {
			// Some math to retrieve the distance between the 1 and the 2
			int m = 0;
			for (int i = 0; i < ones.length; i++) {
				for (int j = 0; j < twos.length; j++) {
					
			 	diff[m] = Math.abs((ones[i]/100) - (twos[j]/100)) + Math.abs((ones[i]%100) - (twos[j]%100));
			 	System.out.println("The current difference is: " + Math.abs((ones[i]/100) - (twos[j]/100)) + Math.abs((ones[i]%100) - (twos[j]%100)));
			 	m++;
			 	}
			 } 

			// Sort the array so wwe only have to take the first value, corresponding to the fastest route
			Arrays.sort(diff);
			System.out.println("The differences are: " + Arrays.toString(diff));

			int ans = (ones[0] == -1) ? -1 : (ones[1] == -1) ? -1 : (ones[2] == -1) ?  -1 : diff[0];
			return Integer.toString(ans);
			}
		}


		public static void main(String[] args) {
			System.out.println(ClosestEnemy());
		}

	}