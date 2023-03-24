package domain.player.dto;

public class playerStatusDto {
    private String name;
    private HandsStatusDto handsStatusDto;

    public playerStatusDto(String name, HandsStatusDto handsStatusDto) {
        this.name = name;
        this.handsStatusDto = handsStatusDto;
    }
}
