package domain.player.dto;

import domain.player.HandsStatus;
import java.util.List;

public class HandsStatusDto {
    private List<String> cards;
    private HandsStatus handsStatus;
    private int score;

    public HandsStatusDto(List<String> cards, HandsStatus handsStatus, int score) {
        this.cards = cards;
        this.handsStatus = handsStatus;
        this.score = score;
    }

    public List<String> getCards() {
        return cards;
    }

    public HandsStatus getHandsStatus() {
        return handsStatus;
    }

    public int getScore() {
        return score;
    }
}
