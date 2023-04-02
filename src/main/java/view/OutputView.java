package view;

import domain.BlackJackResult;
import domain.dto.PlayerStatusDto;
import java.util.List;
import java.util.Map;

public class OutputView {

    // private static final String LINE_SEPARATOR = System.lineSeparator();

    public void firstDrawResult(BlackJackResult blackJackResult) {
        System.out.printf("딜러와 %s 에게 카드 2장씩 나누어 주었습니다.\n",
                formattingPlayerNames(blackJackResult.getParticipantNames()));
        System.out.println(blackJackResult.getDealerInfo());
        List<String> playersInfo = blackJackResult.getPlayersInfo();
        playersInfo.forEach(System.out::println);
    }

    public void hitResult(PlayerStatusDto playerStatusDto) {
        System.out.println(playerStatusDto.toInfo());
    }

    public void printResult(BlackJackResult result) {
        System.out.println(result.getDealer().toInfo());
        result.getParticipantNames().forEach(System.out::println);
        Map<String, Integer> dashBoard = result.getDashBoard();
        System.out.println(dashBoard);
    }

    public void printException(String massage) {
        System.out.println(massage);
    }

    private String formattingPlayerNames(List<String> participantNames) {
        return String.join(",", participantNames);
    }
}
