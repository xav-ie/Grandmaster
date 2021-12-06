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
		//System.out.println("passed empty");
		

		// check if landing block is same color
		if(!(to.piece instanceof Empty)) {
			if (to.piece.color.equals(from.piece.color)) {
				//System.out.println(to.piece.color);
				return false;
			}
		}

		//System.out.println("passed empty");
		// pawn move black case
		if (from.piece.color.equals("B")) {
			if (from.x == to.x -1 && from.y== to.y) {
				return true;
			}
			if (from.x == 6 && to.x == 4 && from.y == to.y)
			{
				return true;
			}
			// pawn take. bad pawn!
			if(!(to.piece instanceof Empty)) {
				if (!to.piece.color.equals(from.piece.color)) {
					if (Math.abs(to.y - from.y) == 1 && from.x - 1 == to.x) {
						return true;
					}
				}
			}
		}
		//System.out.println("passed empty");
		if(from.piece.color.equals("W")) {
			// System.out.println("is white");
			// System.out.println(from.x);
			// System.out.println(from.y);
			// System.out.println(to.x);
			// System.out.println(to.y);
			if ((from.x == to.x - 1) && (from.y == to.y)) {
				return true;
			}
			if ((from.x == 1 && to.x == 3) && (from.y == to.y))
			{
				return true;
			}
			// pawn take. bad pawn!
			if(!(to.piece instanceof Empty)) {
				if (!to.piece.color.equals(from.piece.color)) {
					if ((Math.abs(to.y - from.y) == 1) && (from.x + 1 == to.x)) {
						return true;
					}
				}
			}
		}
		//System.out.println("passed empty");
		// TODO:
		// check if a piece was jumped
		
		return false;
	}
	
}
