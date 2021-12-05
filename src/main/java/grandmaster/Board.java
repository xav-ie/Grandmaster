package grandmaster;



public class Board {
		public Block[][] blocks = new Block[8][8];

	public Board() {
		this.reset();
	}

	public void reset() {
		// empty blocks
		for (int i=0; i < 8; i++) {
			for (int j=2; j < 6; j++) {
				blocks[i][j] = new Block(i, j, new Empty("o"));
			}
		}

		// set pawns
		for (int i=0; i < 8; i ++) {
			blocks[i][1] = new Block(i, 1, new Pawn("W"));
			blocks[i][6] = new Block(i, 6, new Pawn("B"));
		}

		// set rooks
		blocks[0][0] = new Block(0, 0, new Rook("W"));
		blocks[0][7] = new Block(0, 7, new Rook("W"));
		blocks[7][0] = new Block(7, 0, new Rook("B"));
		blocks[7][7] = new Block(7, 7, new Rook("B"));

		// set knights
		blocks[0][1] = new Block(0, 1, new Knight("W"));
		blocks[0][6] = new Block(0, 6, new Knight("W"));
		blocks[7][1] = new Block(7, 1, new Knight("B"));
		blocks[7][6] = new Block(7, 6, new Knight("B"));

		// set bishops
		blocks[0][2] = new Block(0, 2, new Bishop("W"));
		blocks[0][5] = new Block(0, 5, new Bishop("W"));
		blocks[7][2] = new Block(7, 2, new Bishop("B"));
		blocks[7][5] = new Block(7, 5, new Bishop("B"));

		// set queens
		blocks[0][3] = new Block(0, 3, new Queen("W"));
		blocks[7][3] = new Block(7, 3, new Queen("B"));

		//set kings
		blocks[0][4] = new Block(0, 4, new King("W"));
		blocks[7][4] = new Block(7, 4, new King("B"));

	}
}
