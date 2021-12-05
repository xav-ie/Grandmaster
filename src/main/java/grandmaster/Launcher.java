package grandmaster;

public class Launcher {
    public static void main(String[] args) {
        Game ourGame = new Game();
				Prompt.main(args);
        ourGame.init_Game();
        System.out.println(ourGame.vis());
        //HelloFX.main(args);
    }
}
