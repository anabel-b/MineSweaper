package Minesweep;

import java.util.Random;
//import java.awt.Color;
////import java.util.Scanner;
//import javax.swing.JFrame;
//import javax.swing.JPanel;

public class  Grid{
	private boolean [][] bombGrid ;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	public Grid() {
		numRows = 10;
		numColumns = 10;
		numBombs = 25;
		countGrid = new int [numRows][numColumns];
		bombGrid = new boolean [numRows][numColumns];
		createBombGrid();
		createCountGrid();
		
	}
	public Grid(int rows, int columns){
		numRows = rows;
		numColumns = columns;
		numBombs = 25;
		countGrid = new int [numRows][numColumns];
		bombGrid = new boolean [numRows][numColumns];
		createBombGrid();
		createCountGrid();
	}
	public Grid(int rows, int columns, int numBombs) {
		if(rows<0) {
			numRows = 10;
		}
		else {
		numRows = rows;
		}
		if(columns <0) {
			numRows = 10; 
		}else {
		numColumns = columns;}
		if(numBombs <0) {
			numBombs = 25;
		}else {
			this.numBombs = numBombs;
		}
		countGrid = new int [numRows][numColumns];
		bombGrid = new boolean [numRows][numColumns];
		createBombGrid();
		createCountGrid();
	}
	public int getNumRows() {
		return numRows;
	}
	public int getNumColumns() {
		return numColumns;
	}
	public int getNumBombs() {
	return numBombs;	
	}
	public boolean [][] getBombGrid(){
		boolean [][] copy = new boolean [numRows][numColumns];
		for (int i=0;i<=numRows-1; i++) {
			for(int j=0; j<=numColumns-1;j++) {
			 copy [i][j] = bombGrid [i][j];
			}
		}
		return copy;
	}
	public int [][] getCountGrid(){
		//Implement getCountGrid(), which returns a copy of the 2 dimensional int array.
		int [][] copy = new int [numRows][numColumns];
		for (int i=0;i<=numRows-1; i++) {
			for(int j=0; j<=numColumns-1;j++) {
			 copy [i][j] = countGrid [i][j];
			}
		}
		return copy;
	}
	public boolean isBombAtLocation(int row, int column) {
		//Implement isBombAtLocation(int row, int column) so that it returns true if a 
		//bomb is in the cell, false otherwise.
		if(row<0) {
			row = 0;
		}
		if(column<0) {
			column = 0;
		}
		if (bombGrid [row][column]) {
			return true;
		}
		return false;
	}
	
	public int getCountAtLocation(int row, int column) {
		//Implement getCountAtLocation(int row, int column) so that it returns 
		//the sum of the surrounding adjacent bombs counted by retrieving it from the countGrid.
		return countGrid[row][column];
	}
	public void createBombGrid() {// 25 random true of false
		Random random = new Random();
		int column;
		int row;
		for(int i = 0;i < this.numBombs;i++) {
		do {
			column = random.nextInt(this.numColumns);
			row = random.nextInt(this.numRows);
		}while(bombGrid [row][column]);
		bombGrid [row][column] = true;
		
	}
	}
	public void createCountGrid() {
		//createCountGrid() Creates the int 10 x 10 countGrid shown on the right based on the 
		//bomb placement in the bombGrid.
		int counter = 0;
		for(int i=0;i<=this.numRows-1;i++) {
			for (int j=0; j<=this.numColumns-1;j++) {
				
				//top lfet corner
				if(i==0&&j==0) {
					if(bombGrid [i][j]) {
						counter++;
						}
					if(bombGrid[0][1]) {
						counter++;
						}
					if(bombGrid [1][0]) {
						counter++;
						}
					if(bombGrid [1][1]) {
						counter++;
						}
				}
				//right bottom corner
				else if(i==numRows-1 && j==numColumns-1) {
					if(bombGrid [i][j]) { // if bombGrid is true at tha location
						counter++;
						}
					if(bombGrid [i-1][j]) {
						counter++;
						}
					if(bombGrid [i][j-1]) {
						counter++;
						}
					if(bombGrid [i-1][j-1]) {
						counter++;
						}
				}
				//corner on the top right 
				else if(i==0 && j==numColumns-1) {
					if(bombGrid [i][j]) {
						counter++;
					}
					if(bombGrid [i+1][j]) {
						counter++;
					}
					if(bombGrid[i+1][j-1]){
	                    counter++;
	                }
					if(bombGrid[i][j-1]){
	                    counter++;
	                }
				}
				//bottom left corner
				else if(i==numRows-1&&j==0){
					if(bombGrid [i][j]) {
						counter++;
					}
					if(bombGrid [i-1][j]) {
						counter++;
					}
					if(bombGrid [i][j+1]) {
						counter++;
					}
					if(bombGrid [i-1][j+1]) {
						counter++;
					}
				}
				//bottom row of the grid
				else if(i==numRows-1 && (j >= 1 && j <= numRows - 2)){
                    if(bombGrid[i][j]){
                        counter++;
                    }
                    if(bombGrid[i-1][j]){
                        counter++;
                    }
                    if(bombGrid[i][j-1]){
                        counter++;
                    }
                    if(bombGrid[i][j+1]){
                        counter++;
                    }

                    if(bombGrid[i-1][j-1]){
                        counter++;
                    }

                    if(bombGrid[i-1][j+1]){
                        counter++;
                    }
				}
				//right column of the grid
			else if((i >= 1 && i <= numRows - 2) && j==numColumns-1){
					if(bombGrid[i][j]){
                    counter++;
					}
					if(bombGrid[i-1][j]){
                    counter++;
                	}
					if(bombGrid[i+1][j]){
                    counter++;
					}	
					if(bombGrid[i][j-1]){
                    counter++;
					}
					if(bombGrid[i-1][j-1]){
                    counter++;
					}
					if(bombGrid[i+1][j-1]){
                    counter++;
					}
				}
				//top row
			else if(i==0&&(j>=1 && j<=numRows-2)){
                    if(bombGrid[i][j]){
                        counter++;
                    }
                    if(bombGrid[i+1][j]){
                        counter++;
                    }
                    if(bombGrid[i][j-1]){
                        counter++;
                    }
                    if(bombGrid[i][j+1]){
                        counter++;
                    }
                    if(bombGrid[i+1][j+1]){
                        counter++;
                    }
                    if(bombGrid[i+1][j-1]){
                        counter++;
                    }
				}
				//left column of the grid
			else if((i>=1 && i<=numRows-2) && j==0){
                    if(bombGrid[i][j]){
                        counter++;
                    }
                    if(bombGrid[i-1][j]){
                        counter++;
                    }
                    if(bombGrid[i+1][j]){
                        counter++;
                    }
                    if(bombGrid[i][j+1]){
                        counter++;
                    }
                    if(bombGrid[i+1][j+1]){
                        counter++;
                    }
                    if(bombGrid[i-1][j+1]){
                        counter++;
                    }

                }
				else {
					
					//if(i >= 1 && i <= numRows -2    &&   j >= 1 && j <= numColumns -2 
					if(bombGrid[i][j]){
                        counter++;
                    }
					if(bombGrid[i][j+1]){
                        counter++;
                    }
					if(bombGrid[i+1][j+1]){
                        counter++;
                    }
					if(bombGrid[i+1][j]){
                        counter++;
                    }
					if(bombGrid[i+1][j-1]){
                        counter++;
                    }
					if(bombGrid[i][j-1]){
                        counter++;
                    }
					if(bombGrid[i-1][j-1]){
                        counter++;
                    }
					if(bombGrid[i-1][j]){
                        counter++;
                    }
					if(bombGrid[i-1][j+1]){
                        counter++;
                    }
				}
				countGrid[i][j] = counter;
				counter = 0;
			}
		}
				
			
		
		
		
		
	}
	
//	public static void main(String[] args ) {
//		Grid grid = new Grid();
//		
//		int counter = 0;
//		
//		for(int i = 0; i <= grid.getNumRows() -1; i++) {
//			for(int j = 0; j <= grid.getNumColumns()-1; j++) {
//				  
//				if(grid.getBombGrid()[i][j]) {
//					System.out.print("Bombb ");
//				}
//				
//				else {
//					System.out.print("Clear ");
//					}
//				if(grid.getBombGrid()[i][j]) {
//					counter++;
//				}
//				if(j == 9) {
//					System.out.println("");
//				}
//			}
//		}		
//		
//		System.out.println("");
//		
//		System.out.print(counter +"\n\n");
//		
//		
//		for(int i = 0; i <= grid.getNumRows() -1; i++) {
//			for(int j = 0; j <= grid.getNumColumns()-1; j++) {
//				
//				System.out.print(grid.getCountGrid()[i][j] + " ");
//				if(j == 9) {
//					System.out.println();
//				}
//				
//			}
//				
	//		}
//		
		
		
		
	//}
}