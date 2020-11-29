import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {

	Cell cell;
	
	@BeforeEach
	void init() {
		cell = new Cell(true);
	}
	
	@Test
	void construtorTest() {
		Cell basic = new Cell();
		assertFalse(basic.getAlive());
	} // basic and cell lost to the wind
	
	@Test
	void constructor2Test() {
		assertTrue(cell.getAlive());
	} // cell lost to the wind
	
	@Test
	void killTest() {
		cell.kill();
		assertFalse(cell.getAlive());
	} // cell lost to the wind
	
	@Test
	void setAliveTest() {
		cell.setAlive(false);
		assertFalse(cell.getAlive());
		cell.setAlive(true);
		assertTrue(cell.getAlive());
	} // cell lost to the wind
	
	@Test
	void updateTest() {
		// check a living cell
		assertFalse(cell.updateState(1));
		assertTrue(cell.updateState(2));
		assertTrue(cell.updateState(3));
		assertFalse(cell.updateState(4));
		cell.setAlive(false);
		assertTrue(cell.updateState(3));
		assertFalse(cell.updateState(5));
	} // cell lost to the wind

}
