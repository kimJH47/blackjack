package domain;

import domain.card.Card;
import java.util.List;

public class Player {
    private final String name;
    private final Hands hands;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.hands = new Hands(cards);
    }

}

