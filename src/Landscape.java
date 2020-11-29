import java.awt.Graphics;

/*
   File: Blackjack.java
   Author: Caleb Bitting
   Date: 09/12/2020
   Cell Class
*/

public class Landscape {
	
	private Cell[][] grid;
	private int rows, cols;
		
	// constructors
	public Landscape(int r, int c) {
		rows = r;
		cols = c;
		grid = new Cell[rows][cols];
		this.createCells();
	}
	
	// accessors and setters
	public Cell[][] getGrid() {
		return grid;
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	
	public Cell getCell(int r, int c) {
		return grid[r][c];
	}
	
	// create an instance for each pointer in grid
	private void createCells() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c] = new Cell();
			} // c lost to the wind
		} // r lost to the wind
	}
	
	public void reset() {
		// kill every cell
		for (Cell[] row : grid) {
			for (Cell cell : row) {
				cell.kill();
			}
		}
	}
	
	// get neighbor bounding box
	private int[] getBoundingBox(int row, int column) {
		// go one over and one under the row
		int rLower = row - 1;
		int rUpper = row + 1;
		// make sure the lower doesn't break the boundaries
		if (rLower < 0) {
			rLower = 0;
		}
		// make sure the upper doesn't break the boundaries
		if (rUpper >= grid.length) {
			rUpper = grid.length - 1;
		}
		// repeat the same steps with the column
		int cLower = column - 1;
		int cUpper = column + 1;
		if (cLower < 0) {
			cLower = 0;
		}
		if (cUpper >= grid[0].length) {
			cUpper = grid[0].length - 1;
		}
		
		// return an Array of the results
		int[] results = new int[4];
		results[0] = rLower;
		results[1] = rUpper;
		results[2] = cLower;
		results[3] = cUpper;
		
		return results;
	} // rLower, rUpper,cLower, cUpper lost to the wind 
	
	public int getNeighbors(int row, int col) {
		// get possible box
		int[] boundingBox = this.getBoundingBox(row, col);
		int counter = 0;
		
		// iterate over each cell in the box
		for (int r = boundingBox[0]; r <= boundingBox[1]; r++) {
			for (int c = boundingBox[2]; c <= boundingBox[3]; c++) {
				// if the cell isn't the target cell and the cell is alive, add one to counter
				if (!(r == row && c == col) && grid[r][c].getAlive()) {
					counter++;
				}
			}
		}
		return counter;
	} // boundingBox lost to the wind
	
	public void draw(Graphics g, int gridScale) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c].draw(g, c*gridScale, r*gridScale, gridScale);
			} // c lost to the wind
		} // r lost to the wind
	}
	
	public void advance() {
		boolean[][] nextGenStates = new boolean[rows][cols];
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int aliveNeighbors = this.getNeighbors(r, c);
				nextGenStates[r][c] = grid[r][c].updateState(aliveNeighbors);
			} // c lost to the wind
		} // r lost to the wind
		
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				grid[r][c].setAlive(nextGenStates[r][c]);
			} // c lost to the wind
		} // r lost to the wind
	} // nextGenStates lost to the wind
	
	// pretty printing
	public String toString() {
		String toReturn = "";
		for (Cell[] row : grid) {
			for (Cell cell : row) {
				toReturn += " | ";
				toReturn += cell.toString();
			}
			toReturn += " |\n";
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		Landscape landscape = new Landscape(5, 5);
		System.out.println(landscape);
	} // landscape lost to the wind 
	
}
