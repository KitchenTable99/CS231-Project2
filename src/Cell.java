import java.awt.Color;
import java.awt.Graphics;

/*
   File: Blackjack.java
   Author: Caleb Bitting
   Date: 09/12/2020
   Cell Class
*/

public class Cell {
	
	private boolean alive;

	// constructors
	public Cell() {
		alive = false;
	}
	
	public Cell(boolean alive) {
		this.alive = alive;
	}
	
	// accessor and setter methods
	public boolean getAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	// kill a cell
	public void kill() {
		alive = false;
	}
	
	public void draw(Graphics g, int x, int y, int scale) {
		if (this.alive) {
			g.setColor(Color.darkGray);
		} else {
			g.setColor(Color.white);
		}
		g.fillRect(x, y, scale, scale);
	}
	
	public boolean updateState(int aliveNeighbors) {
		if (alive) {
			if (aliveNeighbors == 2 | aliveNeighbors == 3) {
				return true;
			} else {
				return false;
			}
		} else {
			if (aliveNeighbors == 3) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	// pretty printing
	public String toString() {
		if (alive) {
			return "1";
		} else {
			return "0";
		}
	}
	
}
