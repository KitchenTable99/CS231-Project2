import java.util.Random;

public class LifeSimulation {
	
	public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(100,100);
        Random gen = new Random();
        double density = 0.3;

        if (args.length == 0) {
        	System.out.println("usage: you must pass one command-line argument of either \"glider gun\" or \"random\".");
        	return;
        } else if (args[0].charAt(0) == 'g' | args[0].charAt(0) == 'G') {
        	scape.getCell(5, 1).setAlive(true);
        	scape.getCell(5, 2).setAlive(true);
        	scape.getCell(6, 1).setAlive(true);
        	scape.getCell(6, 2).setAlive(true);
        	// semi-circle
        	scape.getCell(3, 13).setAlive(true);
        	scape.getCell(3, 14).setAlive(true);
        	scape.getCell(4, 12).setAlive(true);
          	scape.getCell(5, 11).setAlive(true);
          	scape.getCell(6, 11).setAlive(true);
          	scape.getCell(7, 11).setAlive(true);
          	scape.getCell(8, 12).setAlive(true);
          	scape.getCell(9, 13).setAlive(true);
          	scape.getCell(9, 14).setAlive(true);
          	// pointer
          	scape.getCell(4, 16).setAlive(true);
          	scape.getCell(5, 17).setAlive(true);
          	scape.getCell(6, 15).setAlive(true);
          	scape.getCell(6, 17).setAlive(true);
          	scape.getCell(6, 18).setAlive(true);
          	scape.getCell(7, 17).setAlive(true);
          	scape.getCell(8, 16).setAlive(true);
          	// other half of gun
          	scape.getCell(1, 25).setAlive(true);
          	scape.getCell(2, 25).setAlive(true);
          	scape.getCell(2, 23).setAlive(true);
          	scape.getCell(3, 21).setAlive(true);
          	scape.getCell(3, 22).setAlive(true);
          	scape.getCell(4, 21).setAlive(true);
          	scape.getCell(4, 22).setAlive(true);
	        scape.getCell(5, 21).setAlive(true);
	        scape.getCell(5, 22).setAlive(true);
	        scape.getCell(6, 23).setAlive(true);
	        scape.getCell(6, 25).setAlive(true);
	        scape.getCell(7, 25).setAlive(true);
	        // final block
	        scape.getCell(3, 35).setAlive(true);
	        scape.getCell(3, 36).setAlive(true);
          	scape.getCell(4, 35).setAlive(true);
          	scape.getCell(4, 36).setAlive(true);       	
        }
        else if (args[0].charAt(0) == 'r' | args[0].charAt(0) == 'R') {
        	// initialize the grid to be 30% full
            for (int i = 0; i < scape.getRows(); i++) {
                for (int j = 0; j < scape.getCols(); j++ ) { 
                    scape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
                } // i disappears into the void
            } // j disappears into the void
        } else {
        	System.out.println("usage: you must pass one command-line argument of either \"glider gun\" or \"random\".");
        	return;
        }
        
        LandscapeDisplay display = new LandscapeDisplay(scape, 8);
        
        for (int i = 0; i < 300; i++) {
        	scape.advance();
        	display.repaint();
        	Thread.sleep(100);
        } // i disappears into the void
        
    } // scape, gen, density, args, display all disappear into the void

}
