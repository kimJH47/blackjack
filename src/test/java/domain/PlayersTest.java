package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.card.ShuffleDeck;
import domain.player.Dealer;
import domain.dto.PlayerStatusDto;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("올바른 형식의 이름 리스트가 오면 예외 없이 플레이어가 생성되어야한다.")
    public void crate() throws Exception {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "poby", "glan");
        //when
        //then
        assertThatCode(() -> players.addPlayer(playerNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("player 생성시 올바르지않은 이름형식 리스트가 오면 예외가 발생해야함")
    public void create_ex() throws Exception {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "poby!@", "g.lan");
        //when
        //then
        assertThatThrownBy(() -> players.addPlayer(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("옮바른 형식의 플레이어 이름을 받아 해당 플레이어가 카드한장을 추가로 생성된다.")
    public void add() throws Exception {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "poby", "glan");
        players.addPlayer(playerNames);
        //when
        PlayerStatusDto actual = players.addCard("asd");
        //then
        assertThat(actual.getName()).isEqualTo("asd");
        assertThat(actual.getHandsStatusDto().getCards().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이름형식에 맞지않으면 예외가 발생해야한다.")
    public void add_ex1() throws Exception {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "poby", "glan");
        players.addPlayer(playerNames);
        //when
        //then
        assertThatThrownBy(() -> players.addCard("asd."))
                .isInstanceOf(IllegalArgumentException.class);


    }


    @Test
    @DisplayName("존재하지않는 이름을 받으면 예외가 발생해야한다.")
    public void add_ex2() throws Exception {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "poby", "glan");
        players.addPlayer(playerNames);
        //when
        //then
        assertThatThrownBy(() -> players.addCard("pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임에 참가하는 유저들의 상태가 리스트로 반환되어야한다.")
    public void getParticipantsStatus() {
        //given
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "tray");
        players.addPlayer(playerNames);
        //when
        List<PlayerStatusDto> actual = players.getParticipantsStatusDto();
        //then
        Assertions.assertThat(actual.size()).isEqualTo(2);
        Assertions.assertThat(actual.stream()
                .map(PlayerStatusDto::getName)
                .allMatch(playerNames::contains)).isTrue();

    }

    @Test
    @DisplayName("딜러의 현재 상태가 반환되어야한다.")
    public void getDealersStatus() {
        Players players = new Players(ShuffleDeck.create());
        List<String> playerNames = List.of("asd", "tray", "kim", "gale");
        players.addPlayer(playerNames);

        PlayerStatusDto dealerStatusDto = players.getDealerStatusDto();

        assertThat(dealerStatusDto.getName()).isEqualTo(Dealer.NAME);

    }
}