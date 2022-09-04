package Minesweep;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPanel;


public class GUI extends JFrame {
	private JPanel jpMain;
	private Board boardJPanel;
	
	
	Grid grid = new Grid();
	
	public GUI() {
	boardJPanel = new Board();
	boardJPanel.setBackground(Color.pink);
	this.add(boardJPanel);
	this.setTitle("Minesweeper");
	this.setSize(500,500);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setResizable(false);
	}
	public Grid getGrid() {
		return this.grid;
	}
	public class Board extends JPanel implements ActionListener{
		private JButton[][] board;
		private static final int numRows = 10;
		private static final int numColumns = 10;
		private int max_amount_false = 75;
		private int false_clicked;
		
		public Board(){
			setLayout(new GridLayout(numRows,numColumns));
			displayBoard();
		}
		public void populateBoard() {
			
		}
	public void displayBoard() {
		board = new JButton[numRows][numColumns];
		for(int row=0; row<board.length; row++){
			for(int col=0; col < board[row].length; col++){
				board[row][col] = new JButton();
//				Font bigFont = new Font(Font.SANS_SERIF, Font.BOLD, 36);
				board[row][col].setForeground(Color.PINK);
//				board[row][col].setFont(bigFont);
				board[row][col].addActionListener(this);
				board[row][col].setEnabled(true);
				this.add(board[row][col]);//add to the TicTacToeBoard JPanel
			}
		}
	}
	public void clearBoard() {
		for(int i=0; i<board.length; i++){
			for(int j=0; j < board[i].length; j++){
				board[i][j].setText("");
//				board[row][col].setEnabled(true);
			}
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JButton butnClick = (JButton) e.getSource();
		int row = 0;
		int column = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[j].length; j++) {
				if (board[i][j] == butnClick) {
					row = i;
					column = j;
				}
			}
		}
		if(grid.isBombAtLocation(row, column)){
			JOptionPane.showMessageDialog(null, "You lose :( take that L");
			promptPlayAgain();
		}else {
			if(false_clicked < max_amount_false && board[row][column].getText().equals("")) {
				false_clicked++;
			}
			String s = "";
			s += grid.getCountAtLocation(row, column);
			board[row][column].setText(s);
		}
		if(!(board[row][column].getText().equals(""))) {
			
		}
		if(false_clicked == max_amount_false){	
			JOptionPane.showMessageDialog(null, "You win!  stinky");
			promptPlayAgain();
		}
	}
	public void promptPlayAgain(){
		int yesNo = JOptionPane.showConfirmDialog(null,  "Play Again?", "Yes or No",JOptionPane.YES_NO_OPTION);
		if(yesNo == JOptionPane.YES_OPTION){
			clearBoard();
			grid.createBombGrid();
			grid.createCountGrid();
			false_clicked = 0;
			
			String bomba = "Bomb";
			String no_bomb = "False";

			for (int i = 0; i < grid.getNumRows(); i++) {
				for (int j = 0; j < grid.getNumColumns(); j++) {
					if (grid.isBombAtLocation(i,j)) {
						System.out.print(bomba + " ");
					}

					else {
						System.out.print(no_bomb + " ");
					}

					if (j == 9) {
						System.out.println("");
					}

				}

			}

			for (int i = 0; i < grid.getNumRows(); i++) {
				for (int j = 0; j < grid.getNumColumns(); j++) {
					System.out.print(grid.getCountAtLocation(i, j) + " ");

					if (j == 9) {
						System.out.println("");
					}
				}

			}
		}
		else{
			System.exit(EXIT_ON_CLOSE);
		}
	}
}
}

