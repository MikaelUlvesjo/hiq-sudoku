package com.ulvesjo;
/**
 * The main class to run the sudoku board.
 * @author Mikael Ulvesjö
 *
 */
public class Sudoku {
	/**
	 * main function that accepts two arguments where both are int,
	 * the first one is nr of times to shuffle the board 
	 * and the second it nr of values to keep in the striped version of the board. 
	 * @param args
	 */
public static void main(String[] args){
	//Set default values
	int shuffleBoardTimes=10+Tools.randInt(10); 
	int nrsToKeep=6;
	
	//Do we have an argument that defines nr of times to shuffle the board. 
	if (args.length>0){
		try{
			shuffleBoardTimes=Integer.parseInt(args[0]);
		}catch(NumberFormatException nrformatEx){
			System.out.println("Failed to parse nr of times to shufle board");
		}
	}
	//Do we have an argument that defines nr of values to keep in the striped version of the board
	if (args.length>1){
		try{
			nrsToKeep=Integer.parseInt(args[1]);
		}catch(NumberFormatException nrformatEx){
			System.out.println("Failed to parse nr values to keep");
		}
	}
	
	//Create the board
	SudokuBoard myBoard=new SudokuBoard();
	
	//shuffle it
	myBoard.shuffleBoard(shuffleBoardTimes);
	
	//print the shuffled board
	System.out.println("Board");
	myBoard.printBoard(myBoard.getStrippedBoard(nrsToKeep));
	
	//Print the solution
	System.out.println("Solution");
	myBoard.printBoard();
	}
}
