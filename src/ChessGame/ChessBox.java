package ChessGame;

public class ChessBox {
	char color;
	int r;
	int c;
	chessMan cm;
	public ChessBox(int r, int c, char color)
	{	this.r=r;
		this.c=c;
		this.color=color;
	}
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
	public chessMan getCm() {
		return cm;
	}
	public void setCm(chessMan cm) {
		this.cm = cm;
	}
	public boolean isFree()
	{
		// return if empty or not
		return false;
	} 
	
}
