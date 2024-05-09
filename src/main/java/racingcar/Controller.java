package racingcar;

public class Controller {

    public Controller() {
    }

    public void start() {
        Game game = new Game();
        game.init();
        game.progress();
    }
}