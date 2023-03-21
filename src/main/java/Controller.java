import view.InputView;
import view.OutputView;

public class Controller {
    private final BlackjackGame blackjackGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(BlackjackGame blackjackGame, InputView inputView, OutputView outputView) {
        this.blackjackGame = blackjackGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        addPlayers();
    }

    private void addPlayers() {
        blackjackGame.addPlayer(inputView.inputPlayers());
    }
}
