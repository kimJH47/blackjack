import domain.BlackJackResult;
import domain.player.dto.PlayerStatusDto;
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
        outputView.firstDrawResult(blackJackResult);
        return stayOrHit(blackJackResult.getParticipants());
    }

    private <T> T get(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return get(supplier);
        }
    }

    private BlackJackResult stayOrHit(List<PlayerStatusDto> playerStatusDtos) {
        playerStatusDtos.stream()
                .map(PlayerStatusDto::getName)
                .filter(name -> get(() -> inputView.inputHitOrStay(name).isHit()))
                .map(blackjackGame::addCard)
                .forEach(outputView::hitResult);
        return blackjackGame.processDealerAndResult();

    }

    private void result(BlackJackResult result) {
        outputView.printResult(result);
    }
}

