import domain.BlackJackResult;
import java.util.List;
import java.util.function.Supplier;
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
        BlackJackResult result = play();
        result(result);
    }

    private BlackJackResult play() {
        BlackJackResult blackJackResult = get(() -> blackjackGame.addPlayer(inputView.inputPlayers()));
        outputView.firstDrawResult(
                blackJackResult.getParticipantNames(),
                blackJackResult.getPlayersInfo(),
                blackJackResult.getDealerInfo());
        return stayOrHit(blackJackResult.getParticipantNames());
    }

    private BlackJackResult stayOrHit(List<String> playerNames) {
        playerNames.stream()
                .filter(name -> get(() -> inputView.inputHitOrStay(name).isHitSelect()))
                .map(blackjackGame::addCard)
                .forEach(playerStatusDto -> outputView.printInfo(playerStatusDto.toInfo()));
        return blackjackGame.processDealerAndResult();
    }

    private <T> T get(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return get(supplier);
        }
    }

    private void result(BlackJackResult result) {
        outputView.printResult(result.getPlayersInfo(), result.getDealerInfo(), result.getDashBoard());
    }
}

