import domain.Players;
import domain.player.Dealer;
import domain.player.dto.PlayerStatusDto;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import util.Result;
import util.Score;

public class BlackjackGame {

    private final Players players;
    private final DashBoard dashBoard;

    public BlackjackGame() {
        players = new Players();
        dashBoard = new DashBoard();
    }

    public List<PlayerStatusDto> addPlayer(List<String> players) {
        List<PlayerStatusDto> playerStatusDtos = this.players.addPlayer(players);
        playerStatusDtos.forEach(playerStatusDto -> dashBoard.put(playerStatusDto.getName()));
        return playerStatusDtos;
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
                .map(playerStatusDto -> createResult().apply(playerStatusDto, dealer))
                .collect(Collectors.toList());

        return new BlackJackResult(dealer, collect, dashBoard.toMap());
    }

    private BiFunction<PlayerStatusDto, PlayerStatusDto, PlayerStatusDto> createResult() {
        return (dealer, playerStatusDto) -> {
            Result result = Score.getResult(dealer, playerStatusDto);
            dashBoard.updateResult(playerStatusDto.getName(), result);
            return playerStatusDto;
        };
    }

    private void drawDealerCardAndUpdate() {
        players.addCard(Dealer.NAME);
    }

}
