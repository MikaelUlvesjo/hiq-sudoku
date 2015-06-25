package com.ulvesjo;

/**
 * A class that holds the sudoku board and functions to manipulate it
 * @author Mikael Ulvesjö
 *
 */
public class SudokuBoard {
	/** 
	 * The int array that holds all values and defaults to a valid board.
	 */
	private int[][] board={
		   {1,2,3,4},
		   {3,4,1,2},
		   {2,3,4,1},
		   {4,1,2,3}
		   };
		   
   /**
    * Initiate the board
    */
	public SudokuBoard(){
		
	}
	/**
	 * Function to get a row from the sukoku board
	 * @param row
	 * @return a row from the board
	 */
	public int[] getRow(int row){
		return board[row];
	}
	
	/**
	 * Function to set data on a row
	 * @param row
	 * @param rowData
	 */
	public void setRow(int row, int[] rowData){
		board[row]=rowData;
	}
	
	/**
	 * Function to get a column from the sudoku board
	 * @param col
	 * @return
	 */
	public int[] getCol(int col){
		int[] colData=new int[board.length];
		for(int i=0;i<board.length;i++){
			colData[i]=board[i][col];
		}
		return colData;
	}
	/**
	 * Function to set data on a column
	 * @param col
	 * @return
	 */
	public void setCol(int col, int[] colData){
		for(int i=0;i<board.length;i++){
			board[i][col]=colData[i];
		}
	}
	/**
	 * Function to swap one row with an other
	 * @param firstRow
	 * @param secondRow
	 */
	public void swapRow(int firstRow, int secondRow){
		int[] firstRowData=getRow(firstRow);
		setRow(firstRow,getRow(secondRow));
		setRow(secondRow,firstRowData);
	}
	/**
	 * Function to swap one column with an other
	 * @param firstCol
	 * @param secondCol
	 */
	public void swapCol(int firstCol, int secondCol){
		int[] firstColData=getRow(firstCol);
		setRow(firstCol,getRow(secondCol));
		setRow(secondCol,firstColData);
	}
	/**
	 * gets the entire board
	 * @return
	 */
	public int[][] getBoard()
	{
		return board;
	}
	
	/**
	 * sets the entire board
	 * @param newBoard
	 */
	public void setBoard(int[][] newBoard)
	{
		board=newBoard;
	}
	/**
	 * prints the full board to stdout.
	 * Only works correct with a 4x4 board.
	 */
	public void printBoard(){
		printBoard(board);
	}
	
	/**
	 * prints a full board to stdout.
	 */
	public void printBoard(int[][] inBoard){
		StringBuffer rowSeparator =new StringBuffer(), rowString;
		for(int row=0;row<inBoard.length;row++){
			rowSeparator=new StringBuffer();
			rowString=new StringBuffer();
			for(int col=0;col<inBoard[row].length;col++){
				rowSeparator.append("+-");
				rowString.append("|"+(inBoard[row][col]==0?" ":inBoard[row][col]));
			}
			rowSeparator.append("+");
			rowString.append("|");
			System.out.println(rowSeparator.toString());
			System.out.println(rowString.toString());
		}
		System.out.println(rowSeparator.toString());
		
	}
	/**
	 * This function shuffles the board randomly a nr of times   
	 * Only works correct with a 4x4 board
	 */
	public void shuffleBoard(int nrOfTimes){
		for(int i=0;i<nrOfTimes;i++){
			shuffleBoard();
		}
	}
	
	/**
	 * This function shuffles the board randomly one time  
	 * Only works correct with a 4x4 board
	 */
	public void shuffleBoard(){
		//We can only swap within a section and we have two sections 
		//first section is row/column 0 and 1
		//second section is row/column 2 and 3
		
		//Default to first section
		int firstIndex=0;
		
		//50% chance to use second section 
		if(Tools.randInt(1)==0){firstIndex=2;}
		//is it row or column to shuffle 0=row?
		switch (Tools.randInt(4)){
				case 0:
					//Swap rows
					swapRow(firstIndex, firstIndex+1);
					break;
				case 1:
					//Swap cols
					swapCol(firstIndex, firstIndex+1);
					break;
				case 2:
					//swap rows and columns
					swapRow(firstIndex, firstIndex+1);
					swapCol(firstIndex, firstIndex+1);
					break;
				case 3:
					//invert rows
					swapRow(0, 3);
					swapRow(1, 2);
					break;
				case 4:
					//invert columns
					swapCol(0, 3);
					swapCol(1, 2);
					break;
		}
	}
	/**
	 * get a Stripped version of the Board (0=empty cell)
	 * @param keepCells
	 * @return the striped board
	 */
	public int[][] getStrippedBoard(int keepCells){
		//Create an empty board where only some values are copied to
		int[][] strippedBoard=new int[board.length][board.length];
		
		//Copy values to the stripped board
		for (int i=0;i<keepCells;i++){
			int row=Tools.randInt(board.length-1);
			int col=Tools.randInt(board.length-1);
			if(strippedBoard[row][col]==0){
				//copy a value to the stripped board
				strippedBoard[row][col]=board[row][col];
			}else{
				//We already set this cell so do not count this. 
				i--;
			}
		}
		return strippedBoard;
	}
	
	
}
