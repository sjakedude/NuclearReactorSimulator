package models;

import java.util.ArrayList;

public class Uranium235Factory {
	
	int nextUUID = 0000001;
	static ArrayList<Uranium235> uranium = new ArrayList<>();
	int maxDimension;
	
	public Uranium235Factory(int maxDimension) {
		this.maxDimension = maxDimension;
	}
	
	public ArrayList<Uranium235> generateUranium(int quantity) {
		if (uranium.isEmpty()) {
			if (quantity > 20) {
				System.out.println("Sorry that is too much for the core to handle");
			} else {
				uranium.add(new Uranium235(getRandomCoordinate(), getRandomCoordinate(), Integer.toString(nextUUID)));
				nextUUID++;
			}
			return uranium;

		} else {
			return uranium;
		}
	}
	
	public int getRandomCoordinate() {
		return (int) (Math.random() * (1 - 0 + maxDimension) + 0);
	}

}
