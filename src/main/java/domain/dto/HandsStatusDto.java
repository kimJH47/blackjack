package domain.dto;

import domain.player.HandsStatus;
import java.util.List;

public class HandsStatusDto {
    private final List<String> cards;
    private final int score;

    public HandsStatusDto(List<String> cards, int score) {
        this.cards = cards;
        this.score = score;
    }

    public List<String> getCards() {
        return cards;
    }

    public HandsStatus getHandsStatus() {
        return HandsStatus.of(score);
    }

    public int getScore() {
        return score;
    }
}
