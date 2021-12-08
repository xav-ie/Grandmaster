package grandmaster;

public abstract class Piece {
//	this class represents a piece, it will be the parent
//	class of all pieces.

	public String color;

	public Piece(String color) {
		this.color = color;
	}

	//check if a move is possible, defined by the piece

	public abstract boolean movePossible(Block from, Block to, Board b);

	public abstract String toString();

}
