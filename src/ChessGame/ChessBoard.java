package ChessGame;

public class ChessBoard {
	ChessBox cb[][]= new ChessBox[8][8];
	// status of the chess board
	public ChessBox[][] getCb() {
		return cb;
		
	}

	public void setCb(ChessBox[][] cb) {
		this.cb = cb; //at the start of the game set board
	}
	
	// to get value of each box
	public ChessBox getBox(int r, int c)
	{	return cb[r][c];
	
	}
	
}
