package domain.player.dto;

import domain.player.HandsStatus;

public class PlayerStatusDto {
    private String name;
    private HandsStatusDto handsStatusDto;

    public PlayerStatusDto(String name, HandsStatusDto handsStatusDto) {
        this.name = name;
        this.handsStatusDto = handsStatusDto;
    }

    public String getName() {
        return name;
    }

    public HandsStatusDto getHandsStatusDto() {
        return handsStatusDto;
    }

    public int getScore() {
        return handsStatusDto.getScore();
    }
    public String toInfo() {
        return String.format("%s : %s", name, handsStatusDto.getCards());
    }

    public boolean isBust() {
        return handsStatusDto.getHandsStatus().equals(HandsStatus.BUST);
    }

    public boolean isBlackJack() {
        return handsStatusDto.getHandsStatus().equals(HandsStatus.BLACK_JACK);
    }

}
