package domain.player;


import domain.card.Card;
import domain.player.dto.HandsStatusDto;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;


public class Hands {
    private List<Card> cards;

    public Hands() {
        this.cards = new ArrayList<>();
    }

    public HandsStatusDto add(List<Card> cards) {
        this.cards.addAll(cards);
        return createHandsStatus();
    }

    public HandsStatusDto createHandsStatus() {
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        strings -> new HandsStatusDto(strings, createScore())));
    }

    private HandsStatus createScore() {
        return Score.calc(sumExcludeAceScore(), sumAceCount());
    }

    private int sumExcludeAceScore() {
        return cards.stream()
                .filter(card -> !card.isAce())
                .mapToInt(Card::getRankScore)
                .sum();
    }

    private int sumAceCount() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }
}
