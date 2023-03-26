package domain.card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Card {
    private final Rank rank;
    private final Symbol symbol;

    public Card(Rank rank, Symbol symbol) {
        this.rank = rank;
        this.symbol = symbol;
    }

    public static List<Card> create() {
        return Arrays.stream(Rank.values())
                .flatMap(rank ->
                        Arrays.stream(Symbol.values()).map(symbol -> new Card(rank, symbol)))
                .collect(Collectors.toList());
    }

    public int getRankScore() {
        return rank.getRank();
    }

    public boolean isAce() {
        return rank.isAce();
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", symbol=" + symbol +
                '}';
    }
}
