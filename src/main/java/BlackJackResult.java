import domain.player.dto.PlayerStatusDto;
import java.util.ArrayList;
import java.util.List;

public class BlackJackResult {

    private final PlayerStatusDto dealer;
    private final List<PlayerStatusDto> pariticipants;

    public BlackJackResult(PlayerStatusDto dealer, List<PlayerStatusDto> participants) {
        this.dealer = dealer;
        this.pariticipants = new ArrayList<>(participants);
    }
}
