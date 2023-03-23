package domain;

import domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Hands {
    private List<Card> cards;
    public Hands(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }
}
