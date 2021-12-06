package grandmaster;

import java.lang.Math;

public class King extends Piece {

	public King(String color)
    {
        super(color);
    }


	@Override
	public boolean movePossible(Block from, Block to, Board b) {
		// any move will not result in check
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
		//if same x

		if(Math.abs(from.x - to.x) == Math.abs(from.y - to.y) && Math.abs(from.x - to.x)==1 && Math.abs(from.y - to.y)==1)
		{
	    return true;
		}
		// TODO:
		// check if a piece was jumped

		return false;
	}

		public String toString() 
		{
				return this.color + "k";

		}
}
