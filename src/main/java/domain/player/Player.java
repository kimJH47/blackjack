package domain.player;

import domain.card.Card;
import domain.player.dto.PlayerStatusDto;
import java.util.List;

public abstract class Player {
    private final String name;
    private final Hands hands;

    public Player(String name) {
        this.name = name;
        this.hands = new Hands();
    }

    public PlayerStatusDto add(List<Card> cards) {
        hands.add(cards);
        return createPlayerStatusDto();
    }

    private PlayerStatusDto createPlayerStatusDto() {
        return new PlayerStatusDto(name, hands.createHandsStatus());
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public abstract boolean isDealer();
}

