package grandmaster;

import java.lang.Math;

public class Pawn extends Piece {
	
	public Pawn(String color)
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
		if (to.piece != null) {
			if (to.piece.color.equals(from.piece.color)) {
				return false;
			}
		}
		
		// pawn move black case
		if (from.piece.color.equals("B")) {
			if (from.x == to.x && from.y - 1 == to.y) {
				return true;
			}
			// pawn take. bad pawn!
			if (to.piece != null) {
				if (!to.piece.color.equals(from.piece.color)) {
					if (Math.abs(to.x - from.x) == 1 && from.y - 1 == to.y) {
						return true;
					}
				}
			}
		}
		
		if(from.piece.color.equals("W")) {
			if (from.x == to.x && from.y - 1 == to.y) {
				return true;
			}
			// pawn take. bad pawn!
			if (to.piece != null) {
				if (!to.piece.color.equals(from.piece.color)) {
					if (Math.abs(to.x - from.x) == 1 && from.y + 1 == to.y) {
						return true;
					}
				}
			}
		}
		
		// TODO:
		// check if a piece was jumped
		
		return false;
	}
	
}