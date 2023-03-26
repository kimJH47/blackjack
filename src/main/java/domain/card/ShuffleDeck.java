package domain.card;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleDeck implements Deck{
    private final static int FIRST_DRAW_CARD_COUNT = 2;
    private final static int NORMAL_DRAW_CARD_COUNT = 1;
    private final Queue<Card> cards;

    private ShuffleDeck(List<Card> cards) {
        Collections.shuffle(cards);
        this.cards = new ArrayDeque<>(cards);
    }
    @Override
    public List<Card> drawFirst() {
        return draw(FIRST_DRAW_CARD_COUNT);
    }
    @Override
    public List<Card> drawNormal() {
        return draw(NORMAL_DRAW_CARD_COUNT);
    }

    private List<Card> draw(int count) {
        return IntStream.range(0, count)
                .mapToObj(operand -> cards.remove())
                .collect(Collectors.toList());
    }

    public static ShuffleDeck create() {
        return new ShuffleDeck(Card.create());
    }

}
