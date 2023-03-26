import domain.player.dto.PlayerStatusDto;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import view.InputView;
import view.OutputView;
import view.SelectType;

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
        stayOrHit();
        result();
    }

    private void addPlayers() {
        List<PlayerStatusDto> playerStatusDtos = blackjackGame.addPlayer(inputView.inputPlayers());
        outputView.firstDrawResult(playerStatusDtos);
    }

    private void stayOrHit() {
        //하는중
        BlackJackResult blackJackResult = blackjackGame.processDealerAndResult();
        Stream<SelectType> selectTypeStream = blackJackResult.getPariticipants().stream()
                .map(PlayerStatusDto::getName)
                .map(inputStayOrHit());
    }

    private Function<String, SelectType> inputStayOrHit() {
        return inputView::inputHitOrStay;
    }

    private void result() {

    }
}

