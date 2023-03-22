package domain;

import java.util.List;

public class Deck {
    private final static int FIRST_DRAW_CARD_COUNT = 2;
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> drawFirst() {
        return draw(FIRST_DRAW_CARD_COUNT);
    }

    private List<Card> draw(int count) {
        return cards.subList(0, count);
    }

    public static Deck create() {
        return new Deck(Card.create());
    }

}
