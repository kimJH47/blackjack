package domain.card;

import java.util.List;

public interface Deck {
    List<Card> drawFirst();

    List<Card> drawNormal();
}
