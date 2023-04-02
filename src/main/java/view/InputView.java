package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public List<String> inputPlayers() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine(), ",");
        ArrayList<String> playNames = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            playNames.add(stringTokenizer.nextToken());
        }
        return playNames;
    }

    public SelectType inputHitOrStay(String name) {
        System.out.printf("%s 는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", name);
        return SelectType.of(sc.nextLine());
    }
}
