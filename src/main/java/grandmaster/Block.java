package grandmaster;

public class Block{
//	this class will represent a piece on the chess board
//	it needs to keep track of its position and its occupation status
//	
	
	public int x;
	public int y;
	public Piece piece;
	
	public Block(int x, int y, Piece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	
	public void setPiece(Piece p) {
		// return true if piece was set
		// return false if piece cannot be set
		// check that 0 <= x < 8 and 0 <= y < 8
		this.piece = p;
	}
	
	public void clearPiece() {
		this.piece = new Empty("o");
	}

		
		public String toString() 
		{
				return this.piece.toString();

		}
	
}
