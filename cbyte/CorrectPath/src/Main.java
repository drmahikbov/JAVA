import java.util.*; 
//import java.io.*;



class Main {  
  public static String CorrectPath(String str) { 

    // Let's extract some useful data from the string
    int length = str.length();
    int rights = countChar(str, 'r');
    int lefts = countChar(str, 'l');
    int ups = countChar(str, 'u');
    int downs = countChar(str, 'd');
    int qm = countChar(str, '?');


      String[] poss = new String[qm];
      		for(int i = 0; i < qm; i++) {
      			poss[i] = "rldu";
      		}   

          if(str.charAt(length - 1) == '?') {
            poss[qm - 1] = "rd";
          } 

          if(str.charAt(0) == '?') {
            poss[0] = "rd";
          }

    // Let's check the values of the possibility chars to make sure they're correct
    //  for(int i = 0; i < qm; i++) {
    //    print(poss[i] + " ");
    //  }

      char before;
      char after;
      for(int iterator = 1, j = 1; iterator < length - 1; iterator++, j++) {
        if(str.charAt(iterator) == 63) {
          // Store the characters before and after each ?
          before = str.charAt(iterator - 1);
          after = str.charAt(iterator + 1);

          //print("Before and after values: " + before + " and then " + after);
          // and replace them in the array with the replacements
          //print("test 1 " + poss[j] + " and j: " + j);
          String b = Character.toString(forbidden(before));
          String a = Character.toString(forbidden(after));

          //print("test 2 " + poss[j] + " and j: " + j);
          String superd = poss[j].replace(b, "");  
          superd = superd.replace(a, "");
          //print("test 3 " + poss[j] + " and j: " + j);
          poss[j] = superd;
          //print("test 4 " + poss[j] + " and j: " + j);
        } else {
        }
      }

    // Let's check the values of the possibility chars to make sure they're correct
    //  for(int i = 0; i < qm; i++) {
    //    print(poss[i] + " for the 2nd time");
    //  }



    // The amount of rights and downs must be equal to 4
    // We'll set here the amount of r's and d's to add
    int r = 4 - rights + lefts;
    int d = 4 - downs + ups;
    print("rights: " + r);
    print("downs: " + d);
    print("question marks: " + qm);

    // There is now two possibilities:
    // 1. q = r + d
    // In this case, we'll only have to fill in the blanks left 
    // by the ? signs. To do so, we'll need to try every permutation
    // of the letters
    // 2. q > r + d
    // In this case, we'll have to try every permutation while
    // evening out the equation with (rl)'s and (du)'s

    // Case 1.: answer is only made up of r's and/or d's
    
    /*if(!answer.contains("d")) {

    }*/
    int min_num = 1000;
    int max_num = 4444;
    String[] perms = new String[max_num];

    if(r + d == qm) {
      String answer = convert(r, d);
      print("The possible characters are: " + answer + " with its corresponding sequence: " + match(answer));      

      // This array will store all the number permutations      
      // THIS IS WRONG!!!!!!




      int[] numbers = new int[max_num];
      for(int i = min_num, j = 0; i < max_num; i++){
        if(check(i, answer)) {
        print("This value validated the check() method: " + answer + " with i as: " + i);
        numbers[j] = i;
        perms[j] = matchNum(numbers[j]);
        System.out.println(numbers[j] + " : " + perms[j]);
        j++;
        } else {
      //  numbers[i] = 77777;
       } 
      }
















      print("The first permutation is: " + perms[0]);
      int counter = qm;
      for(int i = qm - 1, j = 0; i >= 0 && j < max_num; i--) {
        char[] characters = perms[j].toCharArray();
        print("PERM: " + perms[j] + " j AND COUNTER: " + j + " AND " + counter);
        print("POSS : " + poss[i] + " AND i: " + i);
        //String container = Character.toString(characters[j]);
        if(poss[i].contains(Character.toString(characters[i]))) {
          print("SOMETHING " + Character.toString(characters[i]));
          counter--;
        }

        if(i == 0) {
          if(counter == 0) {
            print("We wonn!!!$$ with score: " + qm);
          }
          j++;
          i = qm;
          counter = 0;
        }
        

       }



/*
      int counter = 0;
      for(String word : words) {
        newsb.append(word + charset[counter]);
      }*/

      //String finalstring = newsb.toString();

      return "finalstring";
    } // Here ends case 1. ...ouff

    else if (r + d != qm) {
      String answerDU = convertWithDU(r, d);
      String answerRL = convertWithRL(r, d);
      print("The possible characters are: " + answerDU + " and " + answerRL + " with its corresponding sequence: " + match(answerDU) + " and " + match(answerRL));
    
      int[] numbers = new int[max_num];
      for(int i = 0, j = 0; i < max_num; i++){
        if(check(i, null)) {
        numbers[j] = i;
        perms[j] = matchNum(numbers[j]);
        System.out.println(numbers[j] + " : " + perms[j]);
        j++;
        } else {
      //  numbers[i] = 77777;
       } 
      }
    }


    return "The whole thing failed";
    
  } 
  
  public static int countChar(String str, char c) {
    int count = 0;
    for(int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == c) {
        count++;
      }
    }
    return count;
  }

  public static boolean check(long n, String answer) {
    String s = Long.toString(n);
    boolean exit = true;

    String regex1 = ".*[1].*";
    String regex2 = ".*[2].*";
    String regex3 = ".*[3].*";
    String regex4 = ".*[4].*";




  if(!answer.contains("r")) {
    // We have to use regex1
    print("answer has no r: " + answer + " and current number is: " + s);
    if(s.matches(".*[5-9].*") && s.matches(".*[0].*") && s.matches(regex1)){
    exit = false;
    print("i is: " + s + " which is in letters: " + matchNum((int)n));
     } else {
      exit = true;
     }

  }

  if(!answer.contains("l")) {
    // We have to use regex2
    print("answer has no l: " + answer);
        if(s.matches(".*[5-9].*") && s.matches(".*[0].*") && s.matches(regex2)){
    exit = false;
    print("i is: " + s + " which is in letters: " + matchNum((int)n));
     } else {
     exit = true;
     }
  }

  if(!answer.contains("d" + answer)) {
    // We have to use regex3
    print("answer has no d: ");
        if(s.matches(".*[5-9].*") && s.matches(".*[0].*") && s.matches(regex3)){
    exit = false;
    print("i is: " + s + " which is in letters: " + matchNum((int)n));
     } else {
    exit = true;
     }
  }

  if(!answer.contains("u")) {
    // We have to use regex4
    print("answer has no u: " + answer);
        if(s.matches(".*[5-9].*") && s.matches(".*[0].*") && s.matches(regex4)){
    exit = false;
    print("i is: " + s + " which is in letters: " + matchNum((int)n));
     } else {
     exit = true;
     }
  }




  // Lookout for any number which contains a 0 or at least one digit between 5 and 9
  if(s.matches(".*[5-9].*") || s.matches(".*[0].*")){
	  exit = false;
  }
  else exit = true;

  return (exit == true ? true : false);

}

  public static char forbidden(char c) {
    switch(c) {
      case 'r':
      return 'l';

      case 'l':
      return 'r';

      case 'd':
      return 'u';

      case 'u':
      return 'd';

      default:
      return '*';
    }
  }

  public static String convert(int r, int d) {
    StringBuilder sb = new StringBuilder();
    if(r > 0) {
          for(int i = 0; i < r; i++) {
            sb.append('r'); 
          }
        } else if(d > 0) {
          for(int j = 0; j < d; j++) {
            sb.append('d');
          }
      } else if(r < 0) {
          for(int i = 0; i > r; i--) {
            sb.append('l'); 
          }
      } else if(d < 0) {
          for(int j = 0; j > d; j--) {
            sb.append('u');
          }
      }

     return sb.toString();
      }

  public static String convertWithRL(int r, int d) {
    StringBuilder sb = new StringBuilder();
    if(r > 0) {
          for(int i = 0; i < r; i++) {
            sb.append('r'); 
          }
        } else if(d > 0) {
          for(int j = 0; j < d; j++) {
            sb.append('d');
          }
      } else if(r < 0) {
          for(int i = 0; i > r; i--) {
            sb.append('l'); 
          }
      } else if(d < 0) {
          for(int j = 0; j > d; j--) {
            sb.append('u');
          }
      }
      sb.append("rl");

     return sb.toString();
      }

  public static String convertWithDU(int r, int d) {
    StringBuilder sb = new StringBuilder();
    if(r > 0) {
          for(int i = 0; i < r; i++) {
            sb.append('r'); 
          }
        } else if(d > 0) {
          for(int j = 0; j < d; j++) {
            sb.append('d');
          }
      } else if(r < 0) {
          for(int i = 0; i > r; i--) {
            sb.append('l'); 
          }
      } else if(d < 0) {
          for(int j = 0; j > d; j--) {
            sb.append('u');
          }
      }
      sb.append("du");

     return sb.toString();
      }     


  public static int match(String str) {
    StringBuilder sb = new StringBuilder();
    char[] chars = str.toCharArray();
    for(int i = 0; i < chars.length; i++) {
      switch(chars[i]) {
        case 'r':
        sb.append("1");
        break;
        case 'l':
        sb.append("2");
        break;
        case 'd':
        sb.append("3");
        break;
        case 'u':
        sb.append("4");
      }
    }
    String string = sb.toString();
    return Integer.parseInt(string);
  }

  public static String matchNum(int n) {
    StringBuilder sb = new StringBuilder();
    String s = Integer.toString(n);
    char[] chars = s.toCharArray();
    for(int i = 0; i < chars.length; i++) {
      switch(chars[i]) {
        case '1':
        sb.append("r");
        break;
        case '2':
        sb.append("l");
        break;
        case '3':
        sb.append("d");
        break;
        case '4':
        sb.append("u");
      }
    }
    String string = sb.toString();
    return string;
  }


  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(CorrectPath(s.nextLine())); 
    s.close();
    }  
  
  public static void print(String string) {
    System.out.println(string);
    return;
  }
  
  public static void print(StringBuilder string) {
	    System.out.println(string);
	    return;
	}
  
  public static void print(int n) {
      System.out.println(n);
      return;
  }
  
  public static void print(float f) {
      System.out.println(f);
      return;
  }

  public static void print(char c) {
      System.out.println(c);
      return;
  }
}

    //char character = '*';
    //character = setChar(str, rights, lefts, ups, downs, qm, '&');

    // We'll now have to split it at the different 
    // question mark sections and rebuild the string
    // with the correct set of characters
    /*
    String[] word = str.split("\\?");
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < qm + 1; i++) {
      if(i != qm) {
       sb.append(word[i] + character);
       print(sb); 
      } else {
         sb.append(word[i]);
         print(sb);
      }

      */

    /*
    int nr = 0;
    int nl = 0;
    int nd = 0;
    int nu = 0;
    int remainder = qm % 2;
    if(rights == 4 && remainder == 1) { // The amount of r's will be the same as l's
      nr = 0;
      nl = 0;
      
    }
    */
