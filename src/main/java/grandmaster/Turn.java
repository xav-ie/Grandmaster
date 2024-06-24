package grandmaster;

public class Turn {
	public Player player;
	public Piece piece;
	public Block from;
	public Block to;
	public boolean castling;

	public Turn(Block from, Block to, Player player) {
		this.from = from;
		this.to = to;
		this.piece = from.piece;
		this.player = player;
		this.castling = false;
	}
}
