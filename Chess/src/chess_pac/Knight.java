package chess_pac;

public class Knight extends Piece {
	public Knight(boolean available, int x, int y) {
		super(x, y, available);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValid(Board board, int x1, int y1, int x2, int y2) {
		if (super.isValid(board, x1, y1, x2, y2) == false)
			return false;

		else if (x1 + 2 == x2 && (y1 + 1 == y2 || y1 - 1 == y2))
			return true;
		else if (x1 - 2 == x2 && (y1 + 1 == y2 || y1 - 1 == y2))
			return true;
		else if (x1 - 1 == x2 && (y1 + 2 == y2 || y1 - 2 == y2))
			return true;
		else if (x1 + 1 == x2 && (y1 + 2 == y2 || y1 - 2 == y2))
			return true;

		else
			return false;

	}

}
