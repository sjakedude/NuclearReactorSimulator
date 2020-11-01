package driver;

import gui.Display;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import models.Uranium235;
import models.Uranium235Factory;


public class MainLoop {

	// Logger for main
	private static final Logger logger = LogManager.getLogger("Main");

	// Number of times movement is altered
	static int TICKS = 10;
	
	// Max x and y coords of particles
	static int CORE_SIZE = 430;
	
	// Milliseconds delay between movement
	static int DELAY = 10;
	
	// List of uranium particles to be simulated
	static ArrayList<Uranium235> particles = new ArrayList<>();
	
	/**
	 * Method that scans every element of the array and checks
	 * for collisions. Every time a collision is found it is
	 * printed, then set to empty
	 * @param core
	 */
	public static void checkForCollisions(String[][] core) {
		for (int i = 0; i < core.length; i++) {
			for (int j = 0; j < core.length; j++) {
				if (core[i][j].length() > 7) {
					// Printing out the collision coordinates
					System.out.println("COLLISION AT (" + i + ", " + j + ")");
					// Setting the position to empty
					core[i][j] = "";
				}
			}
		}
	}
	
	/**
	 * Main method for simulating the nuclear reactor core
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		// Initializing the display window
		Display gui = new Display();

		// Initializing the size of the core
		String[][] core = new String[CORE_SIZE][CORE_SIZE];
		
		// Setting every position in the core to empty
		for (int i = 0; i < core.length; i++) {
			for (int j = 0; j < core.length; j++) {
				core[i][j] = "";
			}
		}
		
		// Generating uranium and drawing in window
		Uranium235Factory factory = new Uranium235Factory(CORE_SIZE);
		particles = factory.generateUranium(20);
		gui.draw(particles);
		logger.debug("# of U235: " + particles.size());
						
		// Simulating the movement of particles
		for (int i = 1; i < TICKS; i++) {
			// Printing out loop number
			logger.debug("Loop number: " + i);

			// Creating random increments/decrements for x and y coordinates
			int randX = (int) (Math.random() * (1 - 0 + 1) + 0);
			int randY = (int) (Math.random() * (1 - 0 + 1) + 0);
						
			// Place particles inside core
			for (Uranium235 p : particles) {
				// Printing out the contents of p and the core position to be looked at
				logger.debug(p);
				logger.debug("Looking at: " + core[p.getX()][p.getY()] + " and comparing to " + p.getUUID());
				
				// Translating the uranium to a different location inside the core
				logger.debug("Moved " + p.getUUID() + " to " + p);
				core[p.getLastX()][p.getLastY()] = "";
				core[p.getX()][p.getY()] = core[p.getX()][p.getY()] + p.getUUID();
			}
			// Check for collisions
			checkForCollisions(core);
			
			// Sleeping for seconds
			logger.debug("Sleeping for " + DELAY);
			TimeUnit.MILLISECONDS.sleep(DELAY);
			
			// Altering positions
			for (Uranium235 p : particles) {
				p.alterX(randX);
				p.alterY(randY);
			}
			
			// Updating the display window
			gui.draw(particles);
		}	
	}
}
