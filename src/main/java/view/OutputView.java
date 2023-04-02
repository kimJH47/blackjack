package view;

import domain.BlackJackResult;
import domain.player.dto.PlayerStatusDto;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    // private static final String LINE_SEPARATOR = System.lineSeparator();

    public void firstDrawResult(BlackJackResult blackJackResult) {
        List<PlayerStatusDto> participants = blackJackResult.getParticipants();
        System.out.printf("딜러와 %s 에게 카드 2장씩 나누어 주었습니다.\n", formattingPlayerNames(participants));
        PlayerStatusDto dealer = blackJackResult.getDealer();
        System.out.println(dealer.toInfo());
        participants.stream().map(PlayerStatusDto::toInfo).forEach(System.out::println);
    }

    public void hitResult(PlayerStatusDto playerStatusDto) {
        System.out.println(playerStatusDto.toInfo());
    }


    public void printResult(BlackJackResult result) {
        System.out.println(result.getDealer().toInfo());
        result.getParticipants().stream()
                .map(PlayerStatusDto::toInfo)
                .forEach(System.out::println);
        Map<String, Integer> dashBoard = result.getDashBoard();
        System.out.println(dashBoard);
    }

    public void printException(String massage) {
        System.out.println(massage);
    }

    private String formattingPlayerNames(List<PlayerStatusDto> playerStatusDtos) {
        return playerStatusDtos.stream()
                .map(PlayerStatusDto::getName)
                .collect(Collectors.joining(","));

    }
}
