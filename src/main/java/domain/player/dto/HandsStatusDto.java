package domain.player.dto;

import domain.player.HandsStatus;
import java.util.List;

public class HandsStatusDto {
    private List<String> cards;
    private HandsStatus handsStatus;

    public HandsStatusDto(List<String> cards, HandsStatus handsStatus) {
        this.cards = cards;
        this.handsStatus = handsStatus;
    }

    public List<String> getCards() {
        return cards;
    }

    public HandsStatus getHandsStatus() {
        return handsStatus;
    }
}
