import domain.Players;
import domain.player.dto.PlayerStatusDto;
import java.util.List;

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

}
