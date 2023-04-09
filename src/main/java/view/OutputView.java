package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    // private static final String LINE_SEPARATOR = System.lineSeparator();

    public void firstDrawResult(List<String> playerNames, List<String> playerInfos, String dealerInfo) {
        System.out.printf("딜러와 %s 에게 카드 2장씩 나누어 주었습니다.\n", formattingPlayerNames(playerNames));
        printInfo(dealerInfo);
        playerInfos.forEach(this::printInfo);
    }

    public void printInfo(String info) {
        System.out.println(info);
    }

    public void printResult(List<String> playerInfos, String dealerInfo, Map<String, Integer> dashBoard) {
        System.out.println("결과----------------");
        printInfo(dealerInfo);
        playerInfos.forEach(this::printInfo);
        System.out.println(dashBoard);
    }

    public void printException(String massage) {
        System.out.println(massage);
    }

    private String formattingPlayerNames(List<String> participantNames) {
        return String.join(",", participantNames);
    }
}
