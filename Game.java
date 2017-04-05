import java.util.Random;
import java.util.Scanner;
//import java.util.Random;

class Game {
	public	final int rowWidth = 5;
	public final int colHeigth = 6;
	public int [][] board =new int[rowWidth][colHeigth];
	
	
	
	
	public boolean checkIfCopy(int n, int[][] a)
	{
		//Random rand = new Random();
		for(int row = 0; row < board.length; row++)
			{
			for(int col = 0; col < board[row].length; col++)
			{
				if(n == a[row][col]) { 
					//System.out.println("Print the number position:" + col + "," + row);
					return true;
					
				
				}
				
				
			}
			
		}
		return false;
	}
	
	
	
	
	
	
	public void generateBoard() {
		/* TODO: This method generates and display a board of unique random numbers
		 *                               
		 *	row 1:	56  81  99  45  33  12
		 *	    	15  02  01  32  11  62
		 *      	10  22  25  31  77  55
		 *	    	41  30  53  64  17  19
		 *	    	70  91  23  44  18  29
		 *            col  3 ^
		 */
		
		// 1x1
		
		

			
			
			
			Random rand =  new Random();
			
			
			for(int row = 0; row < board.length; row++) {
				for(int col = 0; col < board[row].length; col++){
					int k = rand.nextInt(100);
					while(checkIfCopy(k, board))
						k = rand.nextInt(100);
					board[row][col] = k;
				}
			}
			for(int row = 0; row < board.length; row++){
			
				
				for(int col = 0; col < board[row].length; col++)
					{
					System.out.print(board[row][col] + " ");
					}
				System.out.println();

			
			}
			
			
//			for(int i = 0; i < board.length; i ++) {
//				for(int j = 0; j < board[i].length; j++)
//				{
//					for(int k= i+1; k < board.length; k++){
//						if (board[i][j] == board [k][j]);
//							System.out.println(board[i][j] + "is the same as " + board[k][j]);
//					}
//					System.out.print(board[i][j] + " ");
//					
//					
//				}	
//				System.out.println();
//			}
	
				System.out.println();
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
		boolean complete = false;

		// TODO: check if complete is true and set variable here

		return complete;
	}
	
	public static void main(String[] args) {
		
		Game g = new Game();

		Scanner in = new Scanner(System.in);

		g.generateBoard();

		while(!g.isComplete()) {
			System.out.print("List two numbers to swap (separated by comma): ");
			String numbers = in.nextLine();
			int num1 = Integer.parseInt(numbers.split(",")[0].trim());
			int num2 = Integer.parseInt(numbers.split(",")[1].trim());
			System.out.printf("Swapping %d and %d\n", num1, num2);
			g.swap(num1, num2);
		}
		System.out.println("Game complete. Well done!");
	}
}
