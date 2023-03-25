package domain.player.dto;

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
}
