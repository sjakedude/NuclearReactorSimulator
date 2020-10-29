package models;

public class Uranium235 {
	
	int x;
	int y;
	int lastX;
	int lastY;
	String uuid;
	
	public Uranium235(int x, int y, String uuid) {
		this.x = x;
		this.y = y;
		this.lastX = x;
		this.lastY = y;
		this.uuid = uuid;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getUUID() {
		return this.uuid;
	}
	
	public int getLastX() {
		return this.lastX;
	}
	
	public int getLastY() {
		return this.lastY;
	}
	
	public void alterX(int direction) {
		if (direction == 0 && this.x > 0) {
			this.lastX = x;
			this.x = this.x - 1;
		}
		else if (direction == 1 && this.x < 99) {
			this.lastY = y;
			this.x = this.x + 1;
		}
	}
	
	public void alterY(int direction) {
		if (direction == 0 && this.y > 0) {
			this.y = this.y - 1;
		}
		else if (direction == 1 && this.y < 99) {
			this.y = this.y + 1;
		}
	}
	
	public String toString() {
		return "UUID: " + this.uuid + " Pos: (" + this.x + ", " + this.y + ")";
	}
}
