package domain;

import domain.dto.PlayerStatusDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BlackJackResult {

    private final PlayerStatusDto dealer;
    private final List<PlayerStatusDto> participants;
    private final Map<String, Integer> dashBoard;
    public BlackJackResult(PlayerStatusDto dealer, List<PlayerStatusDto> participants, Map<String,Integer> dashBoard) {
        this.dealer = dealer;
        this.participants = new ArrayList<>(participants);
        this.dashBoard = dashBoard;
    }

    public PlayerStatusDto getDealer() {
        return dealer;
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                .map(PlayerStatusDto::getName)
                .collect(Collectors.toList());
    }

    public List<String> getPlayersInfo() {
    return participants.stream()
            .map(PlayerStatusDto::toInfo)
            .collect(Collectors.toList());

    }

    public String getDealerInfo() {
        return dealer.toInfo();
    }

    public Map<String, Integer> getDashBoard() {
        return dashBoard;
    }
}
