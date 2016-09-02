

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Sudoku game
 * This program is a program that takes an array from a constants class. this array
 * is the start to a sudoku game. It then has a seirs of methods that check if the 
 * array is complete and allows the user to play the game. As the user plays if the cell
 * can not be reset it tells the user this. If able to be reset it takes the users
 * values for that element and resets it. As the user plays the game constenlty checks
 * the game completion, once correct, it dispays correct.
 *  
 * @author Brian Shrawder
 * 
 * @R01 Azarmi,Mehdi
 * 
 * @ October, 19, 2012
 *
 */

public class Sudoku{
	int[][] puzzle = new int [9][9];

	/**
	 * this method checks if any cell is empty in the grid if it is 
	 * it returns false.
	 * @param x
	 * @return
	 */
	public boolean isEmpty(int puzzle[][]){
		for (int i=0; i<9;i++){
			for (int j=0; j<9; j++){
				if(puzzle[i][j] <=0)
					return false;
			}
		}
		return true;

	}

	/**
	 * This method checks each three by three sub arra
	 * y to make sure it has one 
	 * through nine
	 * 
	 * @param x
	 * @return
	 */
	public boolean threeCheck(int puzzle[][]){
		int[] marking_array;
		for(int y=0;y<3; y++){
			for(int z=0;z<3;z++){   
				marking_array= new int [9];
				for(int i=3*y;i<3*(y+1);i++){
					for(int j=3*z;j<3*(z+1);j++){
						marking_array[puzzle[i][j]-1]=1;

					}
				}
				for(int k=0;k<3;k++){
					if(marking_array[k]==0)
						return false;
				}
			}
		}
		return true;
	}

	/**
	 * This method checks each row in the game array to make sure it has the numbers one 
	 * through nine if it does not it returns false
	 * @param x
	 * @return
	 */
	public boolean rowCheck(int puzzle[][]){
		int[] marking_array;
		marking_array = new int [9];
		for (int i =0; i<9; i++){
			for(int j=0; j<9; j++){
				marking_array[puzzle[i][j]-1]=1; 
			}
			for(int k=0;k<9;k++)
				if(marking_array[k]==0)
					return false;
			marking_array = new int [9];
		}
		return true;
	}

	/**
	 * This method checks each colloum in the game array to make sure it has the numbers
	 * one though nine if it does not it returns false
	 * @param x
	 * @return
	 */
	public boolean colCheck(int puzzle[][]){
		int[] colCheck_array = new int [9];
		for (int j =0; j<9; j++){
			for(int i=0; i<9;i++){
				colCheck_array[puzzle[i][j]-1]=1;
			}
			for(int k=0;k<9;k++)
				if(colCheck_array[k]==0)
					return false;
			colCheck_array = new int[9];
		}
		return true;

	}

	/**
	 * This method takes all of the previous check methods ie. empty collome row and three
	 * if any of these is false ie. wrong it returns false
	 * @param x
	 * @return
	 */
	public boolean isPuzzleComplete(int puzzle[][]){
		if(isEmpty(puzzle)==false)
			return false;
		if(rowCheck(puzzle)==false)
			return false;
		if(colCheck(puzzle)==false)
			return false;
		if(threeCheck(puzzle)==false)
			return false;
		return true;

	}


	/**
	 * this method will print the puzzle with the -1's as underscores
	 * and put a bar next to each grid point to separate the elements
	 * for easier playing. also it puts the letters a-i along the top 
	 * and side for the user to use as guides.
	 * @param x
	 */
	public void printPuzzle(int puzzle[][]){

		System.out.print("  ");

		for (int i=0;i<9;i++){

			System.out.print(" | ");
			System.out.format( "%c",'a'+(i));

		}
		System.out.println(" ");
		for(int i=0; i <9;i++){
			System.out.format( " %c",'a'+(i));

			for(int j=0; j<9;j++){
				if(puzzle[i][j] <=0)
					System.out.print(" | _");

				else{
					System.out.print(" | "+puzzle[i][j]);

				}


			}
			System.out.println(" "); 
		}

	}

	/**
	 * This is the main method, this method takes user input and calls t
	 * the methods of print puzzle which prints the puzzle and 
	 * is puzzle compete which checks if the puzzle is complete. 
	 * @param args
	 */
	public static void main(String [] args){
		int [][] array = Constants.game;


		Sudoku s = new Sudoku();{
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)

					s.puzzle[i][j] = Constants.game[i][j];


		}
		s.printPuzzle(s.puzzle);




		if(s.isPuzzleComplete(s.puzzle)==true){
			System.out.println("Puzzle Complete!");

		}


		Scanner scanner = new Scanner(System.in);

		//this while loop takes user input while the puzzle is incomplete and sets the
		//new value of the element unless it is locked. When the game is complete it displays 
		//complete
		while(s.isPuzzleComplete(s.puzzle)==false){

			System.out.println("Puzzle Incomplete!");
			System.out.println("Enter new value <row col val> :");
			String x = scanner.nextLine();
			char a = x.charAt(0);
			char b = x.charAt(2);
			char num =x.charAt(4);
			int first = (int) a - 97;
			int second = (int)b - 97;
			int val=num-48;

			if(Constants.game[first][second]!=-1)
				System.out.println("Fixed location. Cannot change value!");
			else
				s.puzzle[first][second]= val;
			s.printPuzzle(s.puzzle);


		}

		if(s.isPuzzleComplete(s.puzzle)==true){
			System.out.println("Puzzle Complete!");

		}


	}
}





