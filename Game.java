import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Game {
	static int ROWS = 5;
	static int COLS = 6;
	static int[] board = new int[ROWS * COLS]; 

	private int find(int number) {
		for (int i = 0; i < board.length; i++) {
			if (number == board[i]) {
				return i;
			}
		}
		return -1;
	}

	private void generate() {

		for (int i = 0; i < board.length; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 100);
			while( find(randomNum) != -1) { // random found; generate another one.
				randomNum = ThreadLocalRandom.current().nextInt(1, 100);
			}	
			board[i] = randomNum;
		}
	}

	private int[][] copyBoard() {
		int[][] result = new int[ROWS][COLS];

		for (int i = 0; i < ROWS; i++) {
			System.arraycopy(board, i * result[i].length, result[i], 0, result[i].length);
		}

		return result;
	}

	private void display(int[][] theBoard) {
		for (int x = 0; x < ROWS ; x++) {
			for (int y = 0; y < COLS; y++) {
				System.out.print(theBoard[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void display() {
		int[][] twoDimBoard = copyBoard();
		display(twoDimBoard);
	}

	public void generateBoard() {
		/* TODO: This method generates and display a board of unique random numbers
		 *
		 *		56  81  99  45  33  12
		 *		15  02  01  32  11  62
		 *		10  22  25  31  77  55
		 *		41  30  53  64  17  19
		 *		70  91  23  44  18  29
		 */
		generate();
		display();
	}

	public void swap(int num1, int num2) {
		/* TODO: This method swap the numbers on the checkboard. 
		 *       For example, swap(25, 56) will place the number 25 on location (0,0) 
		 *       and number 56 on location (2,2) on the checkboard.
		 *
		 *		25* 81  99  45  33  12
		 *		15  02  01  32  11  62
		 *		10  22  56* 31  77  55
		 *		41  30  53  64  17  19
		 *		70  91  23  44  18  29
		 */
		int indexSource = find(num1);
		int indexTarget = find(num2);

		if (indexSource != -1 && indexTarget != -1) {
			int tmp = board[indexSource];
			board[indexSource] = board[indexTarget];
			board[indexTarget] = tmp;
		} else {
			if (indexSource == -1) {
				System.err.printf("%d not found.\n", num1);
			} else {
				System.err.printf("%d not found.\n", num2);
			}
		}
	}

	public boolean isComplete() {
		/* TODO: This method returns true if the checkboard is completely sorted. 
		 *
		 *		01  02  10  11  12  15
		 *		17  18  19  22  23  25
		 *		30  31  32  33  41  44
		 *		45  53  55  56  62  64
		 *		70  77  77  81  91  99
		 */

		// TODO: check if complete is true and set variable here
		for (int i = 0; i < board.length - 1; i++) {
			if (board[i] > board[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Game g = new Game();

		Scanner in = new Scanner(System.in);

		g.generateBoard();

		while(!g.isComplete()) {
			System.out.print("List two numbers to swap (separated by comma) (q to exit): ");
			String numbers = in.nextLine();
			if (numbers.toLowerCase().equals("q")) {
				System.out.println("Thanks for playing.");
				System.exit(0);
			}
			try {
				int num1 = Integer.parseInt(numbers.split(",")[0].trim());
				int num2 = Integer.parseInt(numbers.split(",")[1].trim());
				System.out.printf("Swapping %d and %d\n", num1, num2);
				g.swap(num1, num2);
				g.display();
			} catch (Exception e) {
				System.err.println("Invalid input.");	
			}
		}
		System.out.println("Game complete. Well done!");
	}
}
