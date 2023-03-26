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
    private final Deck shuffleDeck;

    public Players(Deck deck) {
        shuffleDeck = deck;
    }

    public List<PlayerStatusDto> addPlayer(List<String> playerNames) {
        validName(playerNames);
        addDealer();
        return playerNames.stream()
                .map(addPlayerFunction())
                .map(player -> player.add(shuffleDeck.drawFirst()))
                .collect(Collectors.toList());
    }

    public PlayerStatusDto addCard(String name) {
        validName(List.of(name));
        return players.stream()
                .filter(player -> player.isSameName(name))
                .limit(1)
                .map(player -> player.add(shuffleDeck.drawNormal()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당이름의 참가자가 존재하지 않습니다."));
    }

    public boolean isStayDealer() {
        return findDealer().isStay();

    }

    public List<PlayerStatusDto> getParticipantsStatusDto() {
        return players.stream()
                .filter(player -> !player.isDealer())
                .map(Player::createPlayerStatusDto)
                .collect(Collectors.toList());
    }

    public PlayerStatusDto getDealerStatusDto() {
        return players.stream()
                .filter(Player::isDealer)
                .limit(1)
                .map(Player::createPlayerStatusDto)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("딜러가 존재하지 않습니다."));
    }

    private Dealer findDealer() {
        return players.stream()
                .filter(Player::isDealer)
                .limit(1)
                .map(Dealer.class::cast)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("딜러가 존재하지 않습니다."));
    }

    private void addDealer() {
        Dealer dealer = new Dealer();
        dealer.add(shuffleDeck.drawFirst());
        players.add(dealer);
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
