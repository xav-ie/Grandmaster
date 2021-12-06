package grandmaster;

import java.lang.Math;

public class Empty extends Piece {

	public Empty(String color)
  {
    super(color);
  }


	@Override
	public boolean movePossible(Block from, Block to, Board b) {
		return false;
	}

}
