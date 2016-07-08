package chess_pac;

public class Piece {
	int x;
	int y;
	boolean available;

	Piece(int x, int y, boolean available) {
		this.x = x;
		this.y = y;
		this.available = available;
	}
	 public void setAvailable(boolean available) {
	        this.available = available;
	    }
	public int getx() {
		return this.x;
	}

	public int gety() {
		return this.y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isValid(Board board, int x1, int y1, int x2, int y2) {
		if (x2 == x1 && y2 == y1)
			return false; // cannot move nothing
		if (x2 < 0 || x2 > 7 || x1 < 0 || x1 > 7 || y2 < 0 || y2 > 7 || y1 < 0 || y1 > 7)
			return false;
		return true;
	}
}
