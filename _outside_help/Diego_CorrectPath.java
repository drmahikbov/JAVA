import java.util.*; 
import java.io.*;

class Diego_CorrectPath {
	static final int GRID_W = 5;
	static final int GRID_H = 5;
	// Available moves
	static final Map<Character, Integer> directions = new HashMap<Character, Integer>();
	static final Character[] dirs = {'r', 'd', 'l', 'u'};
	// The moves attempted
	static ArrayList<String> moves = new ArrayList<String>();
	// Number of combinations possible
	static int maxMoves;

	public static String CorrectPath(String str) {
		// Current position
		int pos = 0;
		// Destination cell
		int destination = GRID_W * GRID_H - 1;
		// The cells I step on
		ArrayList path = new ArrayList();
		path.add(0);

		// Sanitize input string
		String sanitizedString = str.replaceAll("[^lrud?]", "");
		maxMoves = (int) Math.pow(substr_count(str, "?"), 4);

		// From start to destination cell.
		// In a 5x5 grid, it means from 0 to 24.
		while (pos < destination) {
			for (char dir : sanitizedString.toCharArray()) {
				pos = tryMove(dir, pos, path, sanitizedString);
				if (pos == -1) {
					// Fail
					break;
				}
				if (path.contains(pos)) {
					// Repeated cell
					System.out.println("\u001B[0;31mRepeated cell pos\u001B[0m");
					break;
				}
				path.add(pos);
			}
			if (pos < destination) {
				// Restart
				System.out.println("\u001B[0;32mRestart\u001B[0m");
				pos = 0;
				path = new ArrayList();
				path.add(0);
				moves.add("");
			}
		}

		if (pos == destination) {
			System.out.println("\u001B[0;32mCorrect path is: " + moves.get(moves.size() - 1) + "\u001B[0m");
			return moves.get(moves.size() - 1);
		}
		
		return str;
		
	}

	public static int tryMove(char dir, int pos, ArrayList path, String str) {
		int currentAttempt = 0;
		int movesSoFar = moves.size();
		String currentMove = "";
		if (movesSoFar > 0) {
			currentMove = moves.get(movesSoFar - 1);
			currentAttempt = movesSoFar - 1;
		}
		if (dir != '?') {
			// Not a question mark
			currentMove += dir;
			System.out.println(currentAttempt + ":" + currentMove + " = " + (pos + directions.get(dir)));
			if (moves.contains(currentMove)) {
				System.out.println("\u001B[31mAlready tried " + currentMove + "\u001B[0m");
				if (currentAttempt > 1 && currentMove.equals(moves.get(currentAttempt-2))) {
					// Already tried this twice
					System.out.println("\u001B[31mDead end :(\u001B[0m");
					System.exit(0);
				}
				return -1;
			}
			if (moves.size() > 0) {
				moves.set(currentAttempt, currentMove);
			} else {
				moves.add(currentMove);
			}
			if (!moveIsLegal(dir, pos)) {
				System.out.println("\u001B[31m" + pos + " + " + dir + ": Illegal move\u001B[0m");
				return -1;
			}
			int destination = GRID_W * GRID_H - 1;
			if (pos + directions.get(dir) == destination && currentMove.length() < str.length() ) {
				// Reached the destination cell before time
				System.out.println("\u001B[31mReached the destination cell before time\u001B[0m");
				return -1;
			}
			return pos + directions.get(dir);
		} else {
			// Loop through all possible directions
			for (char d : dirs) {
				dir = d;
				if (!moves.contains(currentMove + d)) {
					// Stop at the first combination that hasn't been tried
					break;
				}
			}
			if (currentAttempt == maxMoves) {
				// Tried all possible combinations
				System.out.println("\u001B[31mDead end: Tried all possible combinations (" + maxMoves + ") :(\u001B[0m");
				System.exit(0); 
			}
			System.gc();
			return tryMove(dir, pos, path, str);
		}
	}

	public static int substr_count(String s, String sub) {
		String temp = s.replace(sub, "");
		int occ = (s.length() - temp.length()) / sub.length();
		return occ;
	}
	
	public static boolean moveIsLegal(char dir, int pos) {
		if (dir == 'r') {
			return (pos + 1) % GRID_W != 0;
		}
		if (dir == 'l') {
			return pos > 0 && pos % GRID_W != 0;
		}
		if (dir == 'd') {
			return pos < (GRID_W * GRID_H) - GRID_W;
		}
		if (dir == 'u') {
			return pos >= GRID_W;
		}
		return false;
	}
	
	public static void main (String[] args) {
		directions.put('r' , 1);
		directions.put('d' , GRID_W);
		directions.put('l' , -1);
		directions.put('u' , -GRID_W);
		// keep this function call here
		Scanner s = new Scanner(System.in);
		System.out.print(CorrectPath(s.nextLine()));
		s.close();
	}
  
}
