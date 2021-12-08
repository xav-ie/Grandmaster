package grandmaster;



public class Test {
    // This class represents a simple unit test for a chess game

    public static void main(String[] args){
        // SET UP A TESTING ENV
        Game ourGame = new Game();
        ourGame.init_Game();
        System.out.println(ourGame.vis());
        System.out.println("TESTING GAME. Status:");
        System.out.println(testGame(ourGame));
    }
    public static boolean testGame(Game ourGame){
        //KINGS GAMBIT OPENING:
        ourGame.playerMove(ourGame.in_turn_player, 1, 4, 3, 4);
        ourGame.playerMove(ourGame.in_turn_player, 6, 3, 4, 3);

        //TEST TAKING OF PIECE:
        ourGame.playerMove(ourGame.in_turn_player, 3, 4, 4, 3); // white pawn takes black pawn

        //TEST ILLEGAL MOVE
        String c = ourGame.in_turn_player.color;
        ourGame.playerMove(ourGame.in_turn_player, 1, 1, 5, 1);
        if (c.equals(ourGame.in_turn_player.color)){
            return true;
        }
        return false;


    }
}