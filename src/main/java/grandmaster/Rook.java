package grandmaster;

import java.lang.Math;

public class Rook extends Piece {


	public Rook(String color)
    {
        super(color);
    }

	@Override
	public boolean movePossible(Block from, Block to, Board b) {
		//bishop can move diagonally only, no jumping!

		//check if same block
		if (from.equals(to)) {
			return false;
		}

		// check if landing block is same color
		if (!(to.piece instanceof Empty)) {
			if (to.piece.color.equals(from.piece.color)) {
				return false;
			}
		}

		if (to.x == from.x) {
			return true;
		}

		if (to.y == from.y) {
			return true;
		}

		// TODO:
		// check if a piece was jumped

		return false;
	}
}
