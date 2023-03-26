package domain;

import domain.card.Deck;
import domain.player.Dealer;
import domain.player.Participant;
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
        addDealer();
        return playerNames.stream()
                .map(addPlayerFunction())
                .map(player -> player.add(Deck.create().drawFirst()))
                .collect(Collectors.toList());
    }

    public PlayerStatusDto addCard(String name) {
        validName(List.of(name));
        return players.stream()
                .filter(player -> player.isSameName(name))
                .limit(1)
                .map(player -> player.add(deck.drawNormal()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당이름의 참가자가 존재하지 않습니다."));
    }

    private void addDealer() {
        players.add(new Dealer());
    }

    private Function<String, Player> addPlayerFunction() {
        return name -> {
            Participant participant = new Participant(name);
            players.add(participant);
            return participant;
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
