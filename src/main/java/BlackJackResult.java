import domain.player.dto.PlayerStatusDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlackJackResult {

    private final PlayerStatusDto dealer;
    private final List<PlayerStatusDto> pariticipants;
    private final Map<String, Integer> dashBoard;
    public BlackJackResult(PlayerStatusDto dealer, List<PlayerStatusDto> participants, Map<String,Integer> dashBoard) {
        this.dealer = dealer;
        this.pariticipants = new ArrayList<>(participants);
        this.dashBoard = dashBoard;
    }

    public PlayerStatusDto getDealer() {
        return dealer;
    }

    public List<PlayerStatusDto> getPariticipants() {
        return pariticipants;
    }

    public Map<String, Integer> getDashBoard() {
        return dashBoard;
    }
}
