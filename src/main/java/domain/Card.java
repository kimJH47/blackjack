package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum Card {
    ACE_CLOVER(1, "클로버"),
    TWO_CLOVER(2, "클로버"),
    THREE_CLOVER(3, "클로버"),
    FOUR_CLOVER(4, "클로버"),
    FIVE_CLOVER(5, "클로버"),
    SIX_CLOVER(6, "클로버"),
    SEVEN_CLOVER(7, "클로버"),
    EIGHT_CLOVER(8, "클로버"),
    NINE_CLOVER(9, "클로버"),
    TEN_CLOVER(10, "클로버"),
    JACK_CLOVER(10, "클로버"),
    QUEEN_CLOVER(10, "클로버"),
    KING_CLOVER(10, "클로버");
    private final Integer number;
    private final String symbol;

    Card(Integer number, String symbol) {
        this.number = number;
        this.symbol = symbol;
    }

    public static List<Card> create() {
        List<Card> cards = Arrays.stream(Card.values())
                .collect(Collectors.toList());
        Collections.shuffle(cards);
        return cards;
    }
}
