package chess_pac;

public class Bishop extends Piece{

    public Bishop(boolean available, int x, int y) {
        super( x, y,available);
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean isValid(Board board, int x1, int y1, int x2, int y2) {
		if (super.isValid(board, x1, y1, x2, y2) == false)
			return false;

        if(x2 - x1 == y2 - y1)
            return true;

        return false;
    }

}
