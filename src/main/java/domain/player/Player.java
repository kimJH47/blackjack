package domain.player;

import domain.card.Card;
import domain.player.dto.playerStatusDto;
import java.util.List;

public class Player {
    private final String name;
    private final Hands hands;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.hands = new Hands(cards);
    }

    public playerStatusDto add(List<Card> cards) {
        hands.add(cards);
        return getPlayerStatusDto();
    }

    private playerStatusDto getPlayerStatusDto() {
        return new playerStatusDto(name, hands.createHandsStatus());
    }

}

