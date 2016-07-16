package ChessGame;

public class chessMan {
	char color;
	int r;
	int c;
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	// to check is this is captured or not
	public boolean isAvailable()
	{
		return false;
	}
}
