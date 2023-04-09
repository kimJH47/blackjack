import domain.BlackJackResult;
import domain.Players;
import domain.card.Deck;
import domain.player.Dealer;
import domain.dto.PlayerStatusDto;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import util.Result;
import util.Score;

public class BlackjackGame {

    private final Players players;
    private final DashBoard dashBoard;

    public BlackjackGame(Deck deck) {
        players = new Players(deck);
        dashBoard = new DashBoard();
    }

    public BlackJackResult addPlayer(List<String> players) {
        List<PlayerStatusDto> playerStatusDtos = this.players.addPlayer(players);
        playerStatusDtos.forEach(playerStatusDto -> dashBoard.put(playerStatusDto.getName()));
        return new BlackJackResult(this.players.getDealerStatusDto(), playerStatusDtos, dashBoard.toMap());
    }

    public PlayerStatusDto addCard(String name) {
        return players.addCard(name);
    }

    public BlackJackResult processDealerAndResult() {
        if (!players.isStayDealer()) {
            drawDealerCardAndUpdate();
        }
        PlayerStatusDto dealer = players.getDealerStatusDto();
        List<PlayerStatusDto> participants = players.getParticipantsStatusDto();
        List<PlayerStatusDto> collect = participants.stream()
                .map(participant -> createResult().apply(dealer, participant))
                .collect(Collectors.toList());

        return new BlackJackResult(dealer, collect, dashBoard.toMap());
    }

    private BiFunction<PlayerStatusDto, PlayerStatusDto, PlayerStatusDto> createResult() {
        return (dealer, playerStatusDto) -> {
            Result result = Score.getResult(dealer.getScore(), playerStatusDto.getScore());
            dashBoard.updateResult(playerStatusDto.getName(), result);
            return playerStatusDto;
        };
    }

    private void drawDealerCardAndUpdate() {
        PlayerStatusDto playerStatusDto = players.addCard(Dealer.NAME);
        //refactoring
        if (playerStatusDto.getScore() < 16) {
            drawDealerCardAndUpdate();
        }
    }
}
