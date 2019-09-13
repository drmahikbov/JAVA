import java.util.*; 
import java.io.*;

class Main {  
    private static final char[] DIRECTIONS = {'u', 'd', 'l', 'r'};

    // This is "brute-force" solution testing all possible combinations
    public static String CorrectPath(String str) {

        // Return a list of the total number of combinations possible for the number using a recursive algorithm
        int unknownDirections = str.replaceAll("[^?]", "").length();
        List<List<Character>> possibleDirectionCombinations = new ArrayList<>();
        for (int i = 0; i < unknownDirections; i++) {
            List<Character> dirList = new ArrayList<>();
            for (char DIRECTION : DIRECTIONS) {
                dirList.add(DIRECTION);
            }
            possibleDirectionCombinations.add(dirList);
        }
        List<String> totalCombos = allDirectionCombinations(possibleDirectionCombinations);

        char[] path = str.toCharArray();
        for (String replacements : totalCombos) {
            String solution = checkForSolution(path, replacements.toCharArray());
            if (solution.length() > 0) {
                return solution;
            }
        }
        return "no solution";
    }

    // Determine if a solution exists for the replacement values provided
    private static String checkForSolution(char[] path, char[] replacements) {
        char[] solution = Arrays.copyOf(path, path.length);

        // Create a grid to keep track of occupied cells to make sure path crossing
        boolean[][] occupied = new boolean[5][5];
        int x = 0;
        int y = 0;
        int replacementIndex = 0;
        for (int i = 0; i < solution.length; i++) {

            // If an unknown direction is found overlay it with the next replacement direction
            if (solution[i] == '?') {
                solution[i] = replacements[replacementIndex++];
            }

            // Increment the x and y locations based on the current direction in the path
            x += (solution[i] == 'l' ? -1 : solution[i] == 'r' ? 1 : 0);
            y += (solution[i] == 'u' ? -1 : solution[i] == 'd' ? 1 : 0);

            // Check if the last direction was outside of the grid or landed on an occupied cell
            if (x < 0 || x > 4 || y < 0 || y > 4 || occupied[x][y]) {
                return "";
            }

            // Set the current cell at the x,y coordinate as occupied
            occupied[x][y] = true;
        }

        // Check if the solution ended on the lower-right corner (solution found)
        if (x == 4 && y == 4) {
            return new String(solution);
        }

        return "";
    }

    private static List<String> allDirectionCombinations(List<List<Character>> possibleDirectionSets) {
        if (possibleDirectionSets.size() == 0) {
            return new ArrayList<>();
        }
        List<Character> directionSubSet = possibleDirectionSets.remove(0);
        List<String> directionCombinations = new ArrayList<>();
        for (Character direction : directionSubSet) {
            directionCombinations.add(direction.toString());
        }

        return allDirectionCombinationsBuilder(possibleDirectionSets, directionCombinations);
    }

    private static List<String> allDirectionCombinationsBuilder(List<List<Character>> possibleDirectionSets, List<String> directionCombinations) {
        if (possibleDirectionSets.size() == 0) {
            return directionCombinations;
        }
        List<Character> directionSubset = possibleDirectionSets.remove(0);
        List<String> directionSet = new ArrayList<>();

        for (String directionCombination : directionCombinations) {
            for (Character direction : directionSubset) {
                directionSet.add(direction + directionCombination);
            }
        }

        return allDirectionCombinationsBuilder(possibleDirectionSets, directionSet);
    }
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(CorrectPath(s.nextLine())); 
  }   
  
}