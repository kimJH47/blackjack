import domain.Players;
import domain.player.dto.PlayerStatusDto;
import java.util.List;

public class BlackjackGame {
    private final Players players;

    public BlackjackGame(Players players) {
        this.players = players;
    }
    public List<PlayerStatusDto> addPlayer(List<String> players) {
        this.players.addPlayer(players);
        return null;

    }

}
