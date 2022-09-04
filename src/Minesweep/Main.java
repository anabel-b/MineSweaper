package Minesweep;

public class Main  implements Runnable{
	
	public static void main(String[] args) {
		GUI gui = new GUI();
//		Grid grid = new Grid();
		new Thread (new Main()).start();
		
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
//		for(int i = 0; i <= grid.getNumRows() -1; i++) {
//			for(int j = 0; j <= grid.getNumColumns()-1; j++) {
//				
//				System.out.print(grid.getCountGrid()[i][j] + " ");
//				if(j == 9) {
//					System.out.println();
//				}
//			}			
//		}
//	//}
	}

	@Override
	public void run() {
		
	}
}
