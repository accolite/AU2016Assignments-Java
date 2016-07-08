package chess_pac;

public class King extends Piece{
	public King(boolean available, int x, int y) {
        super( x, y,available);
        // TODO Auto-generated constructor stub
    }
	
	    public boolean isValid(Board board, int x1, int y1, int x2, int y2) {
	        if(super.isValid(board, x1, y1, x2, y2) == false)
	            return false;

	    if(x1==x2&&(y1==y2-1||y1==y2+1))return true;
	    else if(y1==y2&&(x1==x2-1||x1==x2+1))return true;
	    else if(x2==x1+1&&(y2==y1+1||y2==y1-1))return true;
	    else if(x2==x1-1&&(y2==y1+1||y2==y1-1))return true;
	    else return false;
	    }
}
