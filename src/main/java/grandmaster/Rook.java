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
			// direction is moving in y
			if (to.y > from.y){
				// check if it jumped in that direction
				for (int i=from.y+1; i<to.y; i++){
					if (!(b.getBlocks()[from.x][i].piece instanceof Empty)){
						//System.out.println("move on y, positive");
						//System.out.println(b.getBlocks()[i][from.y].piece);
						return false;
					}
				}
			} else {
				for (int i=from.y-1; i>to.y; i--){
					if (!(b.getBlocks()[from.x][i].piece instanceof Empty)){
						//System.out.println("move on y, neg");
						//System.out.println(b.getBlocks()[i][from.y].piece);
						return false;
					}
				}
			}
			return true;
		}

		if (to.y == from.y) {
			if (to.x > from.x){
				// check if it jumped in that direction
				for (int i=from.x+1; i<to.x; i++){
					if (!(b.getBlocks()[i][from.y].piece instanceof Empty)){
						//System.out.println("move on x, positive");
						//System.out.println(b.getBlocks()[i][from.y].piece);
						return false;
					}
				}
			} else {
				for (int i=from.x-1; i>to.x; i--){
					if (!(b.getBlocks()[i][from.y].piece instanceof Empty)){
						//System.out.println("move on x, neg");
						//System.out.println(b.getBlocks()[i][from.y].piece);
						return false;
					}
				}
			}
			return true;
		}

		// TODO:
		// check if a piece was jumped


		return false;
	}


		public String toString() 
		{
				return this.color + "r";

		}
	
}
