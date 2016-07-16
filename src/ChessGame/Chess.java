package ChessGame;

public class Chess {
	ChessBoard cb=new ChessBoard();
	ChessPlayer cp1= new ChessPlayer('w');
	ChessPlayer cp2= new ChessPlayer('b');
	void move()
	{}
	void checkmate()
	{}
	void draw()
	{}
	public ChessBoard getCb() {
		return cb;
	}
	public void setCb(ChessBoard cb) {
		this.cb = cb;
	}
	public ChessPlayer getCp1() {
		return cp1;
	}
	public void setCp1(ChessPlayer cp1) {
		this.cp1 = cp1;
	}
	public ChessPlayer getCp2() {
		return cp2;
	}
	public void setCp2(ChessPlayer cp2) {
		this.cp2 = cp2;
	}
	
	
	
}
