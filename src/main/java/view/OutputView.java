package view;

import domain.player.dto.PlayerStatusDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    // private static final String LINE_SEPARATOR = System.lineSeparator();

    public void firstDrawResult(List<PlayerStatusDto> playerStatusDtos) {
        System.out.printf("딜러와 %s 에게 카드 2장씩 나누어 주었습니다.", formattingPlayerNames(playerStatusDtos));
        playerStatusDtos.stream().map(PlayerStatusDto::toInfo).forEach(System.out::println);
    }

    private String formattingPlayerNames(List<PlayerStatusDto> playerStatusDtos) {
        return playerStatusDtos.stream()
                .map(PlayerStatusDto::getName)
                .collect(Collectors.joining(","));

    }

}
