package driver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import models.Uranium235;
import models.Uranium235Factory;

public class MainLoop {
	
	static int TICKS = 100;
	static int CORE_SIZE = 100;
	static int DELAY = 0;
	static ArrayList<Uranium235> particles = new ArrayList<>();;
	
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
		
		// Initializing the size of the core
		String[][] core = new String[CORE_SIZE][CORE_SIZE];
		
		// Setting every position in the core to empty
		for (int i = 0; i < core.length; i++) {
			for (int j = 0; j < core.length; j++) {
				core[i][j] = "";
	
			}
		}
		
		// Generating uranium
		Uranium235Factory factory = new Uranium235Factory(CORE_SIZE);
		particles = factory.generateUranium(10);
		
		// Simulating the movement of particles
		for (int i = 1; i < TICKS; i++) {
			// Printing out loop number
			System.out.println("Loop number: " + i);

			// Creating random increments/decrements for x and y coordinates
			int randX = (int) (Math.random() * (1 - 0 + 1) + 0);
			int randY = (int) (Math.random() * (1 - 0 + 1) + 0);
						
			// Place particles inside core
			for (Uranium235 p : particles) {
				// Printing out the contents of p and the core position to be looked at
				System.out.println(p);
				System.out.println("Looking at: " + core[p.getX()][p.getY()] + " and comparing to " + p.getUUID());
				
				// Translating the uranium to a different location inside the core
				System.out.println("Moved " + p.getUUID() + " to " + p);
				core[p.getLastX()][p.getLastY()] = "";
				core[p.getX()][p.getY()] = core[p.getX()][p.getY()] + p.getUUID();
			}
			// Check for collisions
			checkForCollisions(core);
			
			// Sleeping for seconds
			TimeUnit.SECONDS.sleep(DELAY);
			
			// Altering positions
			for (Uranium235 p : particles) {
				p.alterX(randX);
				p.alterY(randY);
			}
		}	
	}
}
