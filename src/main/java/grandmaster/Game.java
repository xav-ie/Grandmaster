
package grandmaster;
import java.util.*;
public class Game {
  public Player[] plist = new Player[2];
  public Board gameboard;
  public Board hypothetical;
  public Turn hypotheticalturn;
  public Player in_turn_player;
  public List<Turn> turn_list;
  public List<Piece> pieces;
  public List<Piece> killed;
  public List<Piece> locked;
  public boolean white_check_flag = false;
  public boolean black_check_flag = false;
  public boolean white_victory = false;
  public boolean black_victory = false;
  //check
  //for pieces enemy, movepossible, from piece, to king
  //if check,
  //if any side piece can move in such a manner that it restricts for movepossible(turned.from all enemy pieces. turned.to, king square)

  //any move check if puts king in check
  //from .piece = null

  public void init_Game()
   {
      //players
			 plist[0] = new Player("W");
			 plist[1] = new Player("B");

			 this.gameboard = new Board();
       //wipe board
       gameboard.reset();
       //white moves first

       this.in_turn_player = plist[0];
       //wipe all moves on init
			 this.turn_list = new ArrayList<Turn>();

       turn_list.clear();
   }

  //move helper
   public boolean playerMove(Player player, int x, int y, int xprime, int yprime)
   {
      // for all i, j in blocks get gameboard.blocks[x][y].piece
      // piece isinstance Pawn, King, Rook, Empty
      // piece.color {"o", "W", "B"}
      Block startblock = gameboard.blocks[x][y];
      Block endblock = gameboard.blocks[xprime][yprime];
      Turn curturn = new Turn(startblock, endblock, player);
      return this.turner(curturn, player);
    }

  public String vis()
  {
    String visu = "";
    for(int y = 0; y < gameboard.blocks[0].length; y++)
    {
      for(int x = 0; x < gameboard.blocks.length; x++)
      {
        if(gameboard.blocks[x][y].piece instanceof Empty)
        {
          visu = visu.concat("X");
        } else
        if(gameboard.blocks[x][y].piece instanceof King)
        {
          visu = visu.concat("K");
        } else
        if(gameboard.blocks[x][y].piece instanceof Queen)
        {
          visu = visu.concat("Q");
        } else
        if(gameboard.blocks[x][y].piece instanceof Knight)
        {
          visu = visu.concat("k");
        } else
        if(gameboard.blocks[x][y].piece instanceof Rook)
        {
          visu = visu.concat("C");
        } else
        if(gameboard.blocks[x][y].piece instanceof Pawn)
        {
          visu = visu.concat("P");
        } else
        if(gameboard.blocks[x][y].piece instanceof Bishop)
        {
          visu = visu.concat("B");
        } else {
						System.out.println("oh noes");
				}

      }
      visu = visu.concat("\n");
    }
    return(visu);
  }

    public boolean checkifcheck(Board gb)
    {
      //System.out.println(this.vis());
      int kingx = -100;
      int kingy = -100;
      for(int y = 0; y < gb.blocks[0].length; y++)
      {
        for(int x = 0; x < gb.blocks.length; x++)
        {
          if(gb.blocks[x][y].piece.color.equals(in_turn_player.color))
          {
            if(gb.blocks[x][y].piece instanceof King)
            {
              kingx = x;
              kingy = y;
            }
          }
        }
      }

      for(int y = 0; y < gb.blocks[0].length; y++)
      {
        for(int x = 0; x < gb.blocks.length; x++)
        {
          if(gb.blocks[x][y].piece.movePossible(gb.blocks[x][y],gb.blocks[kingx][kingy],gb))
          {
            if(in_turn_player.color.equals("B"))
            {
              black_check_flag = true;
              return(true);
            }
              if(in_turn_player.color.equals("W"))
            {
              white_check_flag = true;
              return(true);
            }
          }
        }
      }
     // System.out.println(this.vis());
      return(false);
    }
    //move checks and confirmation
    private boolean turner(Turn turned, Player player)
    {
      // System.out.println(turned.from.x);
      // System.out.println(turned.from.y);
      // System.out.println(turned.to.x);
      // System.out.println(turned.to.y);
      //if someone's trying to move something that isn't even a piece
       if (turned.piece instanceof Empty)
       {
           return false;
       }
       //System.out.println("passed empty");

       // valid player?
       if (player != in_turn_player)
       {
           return false;
       }

       //System.out.println("passed empty");

       //if the player thinks they can play the other side
       if (turned.piece.color != player.color)
       {
           return false;
       }

       //System.out.println("passed empty");


       // is this move even possible
       if (!turned.piece.movePossible(turned.from, turned.to, gameboard))
       {
           return false;
       }

       //System.out.println("passed empty");

       //are you getting yourself into check ?
       Board hypothetical = new Board(gameboard);
       hypothetical.blocks[turned.to.x][turned.to.y].setPiece(turned.from.piece);
       if(checkifcheck(hypothetical)==true)
       {
         return false;
       }

       //System.out.println("passed empty");

       // kill!
       Piece victim = turned.to.piece;
       //System.out.println(turned.to.color);
       if (!(victim instanceof Empty))
       {
           killed.add(victim);
           turned.to.clearPiece();
           //if a king was just taken, game over
           if(victim instanceof King)
           {
             if(in_turn_player.color.equals("W"))
             {
               white_victory = true;
             }
             if(in_turn_player.color.equals("B"))
             {
               black_victory = true;
             }
           }
       }

       //System.out.println("passed empty");

       //castling..........


       // store the move
       turn_list.add(turned);
       // move piece from the start block to end block
       turned.to.setPiece(turned.from.piece);
       turned.from.clearPiece();

       // set the current turn to the other player
       if (this.in_turn_player == plist[0]) {
           this.in_turn_player = plist[1];
       }
       else {
           this.in_turn_player = plist[0];
       }

       return true;
   }

}
