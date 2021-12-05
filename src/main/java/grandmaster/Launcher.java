package grandmaster;

public class Launcher {
    public static void main(String[] args) {
        Game ourGame = new Game();
        ourGame.init_Game();
        System.out.println(ourGame.vis());
    }
}
