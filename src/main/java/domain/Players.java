package domain;

import domain.card.Deck;
import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players = new ArrayList<>();
    private final Deck deck;

    public Players() {
        deck = Deck.create();
    }

    public void add(List<String> playerNames) {
        validName(playerNames);
        playerNames.forEach(name ->
                this.players.add(
                        new Player(name, deck.drawFirst()))
        );
    }

    private void validName(List<String> players) {
        for (String player : players) {
            if (!player.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException("이름은 영어만 입력가능합니다.");
            }
        }
    }
}
