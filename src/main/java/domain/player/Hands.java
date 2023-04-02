package domain.player;


import domain.card.Card;
경import domain.dto.HandsStatusDto;
import util.Score;
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
        int score = calcScore();
        return cards.stream()
                .map(Card::toString)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        cards -> new HandsStatusDto(cards, score)));
    }

    private int calcScore() {
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
