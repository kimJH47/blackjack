import domain.Players;
import domain.player.dto.PlayerStatusDto;
import java.util.List;

public class BlackjackGame {
    private final Players players;

    public BlackjackGame() {
        this.players = new Players();
    }
    public List<PlayerStatusDto> addPlayer(List<String> players) {
       return this.players.addPlayer(players);
    }

}
