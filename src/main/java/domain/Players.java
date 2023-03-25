package domain;

import domain.card.Deck;
import domain.player.Player;
import domain.player.dto.PlayerStatusDto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players = new ArrayList<>();
    private final Deck deck;

    public Players() {
        deck = Deck.create();
    }

    public List<PlayerStatusDto> addPlayer(List<String> playerNames) {
        validName(playerNames);
        return playerNames.stream()
                .map(addPlayerFunction())
                .map(player -> player.add(Deck.create().drawFirst()))
                .collect(Collectors.toList());
    }

    private Function<String, Player> addPlayerFunction() {
        return name -> {
            Player player = new Player(name);
            players.add(player);
            return player;
        };
    }

    private void validName(List<String> players) {
        for (String player : players) {
            if (!player.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException("이름은 영어만 입력가능합니다.");
            }
        }
    }
}
