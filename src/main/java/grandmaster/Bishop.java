package grandmaster;

import java.lang.Math;

public class Bishop extends Piece {
	
	public Bishop(String color)
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
		
		// check if the piece can move that direction
		// CITATION:
		// https://math.stackexchange.com/questions/1566115/formula-that-describes-the-movement-of-a-bishop-in-chess
		
		int n = Math.abs(to.x - from.x);
		
		if (n != Math.abs(to.y - from.y)) {
			return false;
		}
		
		if (n <= 0) {
			return false;
		}
		
		// TODO:
		// check if a piece was jumped
		
		return true;
	}
	
}
