import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LandscapeTest {

	Landscape landscape;
	
	@BeforeEach
	void init() {
		landscape = new Landscape(6, 5);
	}
	
	@Test
	void constructorTest() {
		int[] expected = new int[] {6, 5, 6, 5};
		int[] results = new int[4];
		results[0] = landscape.getGrid().length;
		results[1] = landscape.getGrid()[1].length;
		results[2] = landscape.getRows();
		results[3] = landscape.getCols();
		assertArrayEquals(results, expected);
		assertFalse(landscape.getCell(0, 0).getAlive());
	} // expected, results, and landscape disappear into the void
	
	@Test
	void resetTest() {
		boolean[] expected = new boolean[] {false, false, false};
		boolean[] results = new boolean[3];
		landscape.getCell(0, 0).setAlive(true);
		landscape.getCell(4, 2).setAlive(true);
		landscape.getCell(5, 4).setAlive(true);
		landscape.reset();
		results[0] = landscape.getCell(0, 0).getAlive();
		results[1] = landscape.getCell(4, 2).getAlive();
		results[2] = landscape.getCell(5, 4).getAlive();
		assertArrayEquals(results, expected);
	} // expected, results, and landscape disappear into the void
	
	@Test
	void neighborTest() {
		landscape.getCell(2, 3).setAlive(true);
		assertEquals(landscape.getNeighbors(3, 3), 1);
		assertEquals(landscape.getNeighbors(1, 2), 1);
	} // landscape disappears into the void
	
	@Test
	void advaceTest() {
		// old landscape
		landscape = new Landscape(5, 5);
		landscape.getCell(0, 0).setAlive(true);
		landscape.getCell(0, 3).setAlive(true);
		landscape.getCell(1, 1).setAlive(true);
		landscape.getCell(1, 2).setAlive(true);
		landscape.getCell(1, 3).setAlive(true);
		landscape.getCell(1, 4).setAlive(true);
		landscape.getCell(2, 3).setAlive(true);
		landscape.getCell(3, 2).setAlive(true);
		landscape.getCell(3, 3).setAlive(true);
		landscape.getCell(4, 4).setAlive(true);
		// advance it
		landscape.advance();
		Landscape expected = new Landscape(5, 5);
		expected.getCell(0, 1).setAlive(true);
		expected.getCell(0, 3).setAlive(true);
		expected.getCell(0, 4).setAlive(true);
		expected.getCell(1, 1).setAlive(true);
		expected.getCell(1, 4).setAlive(true);
		expected.getCell(2, 1).setAlive(true);
		expected.getCell(3, 2).setAlive(true);
		expected.getCell(3, 3).setAlive(true);
		expected.getCell(3, 4).setAlive(true);
		expected.getCell(4, 3).setAlive(true);
		// loop through grid
		boolean same = true;
		for (int r = 0; r < landscape.getGrid().length; r++) {
			for (int c = 0; c < landscape.getGrid()[0].length; c++) {
				// if the cells are different trip the one way switch
				if (landscape.getGrid()[r][c].getAlive() != expected.getGrid()[r][c].getAlive()) {
					same = false;
				}
			} // c disappears into the void
		} // r disappears into the void
		assertTrue(same);
	} // landscape, expected, and same disappear into the void

}
