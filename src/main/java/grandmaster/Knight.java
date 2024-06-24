package grandmaster;

import java.lang.Math;

public class Knight extends Piece {

	public Knight(String color)
    {
        super(color);
    }

	@Override
	public boolean movePossible(Block from, Block to, Board b) {
		//check if same block
		if (from.equals(to)) {
			return false;
		}
		// check if landing block is same color
		if (to.piece != null) {
			if (to.piece.color.equals(from.piece.color)) {
				return false;
			}
		}
		return(Math.abs(from.x - to.x) * Math.abs(from.y - to.y) == 2);
		// TODO:
		// check if a piece was jumped

	}

}
