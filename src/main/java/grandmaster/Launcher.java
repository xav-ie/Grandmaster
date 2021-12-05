package grandmaster;

public class Launcher {
    public static void main(String[] args) {
        Game ourGame = new Game();
        ourGame.init_Game();
        System.out.println(ourGame.vis());
        ourGame.playerMove(ourGame.in_turn_player, 1, 0, 2, 0);
        System.out.println(ourGame.vis());
    }
}
