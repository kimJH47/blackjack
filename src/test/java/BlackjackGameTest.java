import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.card.ShuffleDeck;
import domain.player.dto.PlayerStatusDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BlackjackGameTest {


    @Test
    @DisplayName("향식에 맞는 플레이어의 이름 리스트를 넘기면 플레이어의 상태 리스트가 반환되어야한다.")
    public void add() throws Exception {
        //given
        BlackjackGame blackjackGame = new BlackjackGame(ShuffleDeck.create());
        List<String> playerNames = List.of("kim", "jae", "tray");
        //when
        List<PlayerStatusDto> actual = blackjackGame.addPlayer(playerNames);
        //then
        assertThat(actual.stream()
                .map(PlayerStatusDto::getName)
                .allMatch(playerNames::contains))
                .isTrue();

    }

    @Test
    @DisplayName("형식에 맞지 않는 플레이어의 이름 리스트를 넘기면 예외가 발생한다.")
    public void add_ex() throws Exception {
        //given
        BlackjackGame blackjackGame = new BlackjackGame(ShuffleDeck.create());
        List<String> playerNames = List.of("kim", "jae", "tray.");
        //when
        //then
        assertThatThrownBy(() -> blackjackGame.addPlayer(playerNames))
                .isInstanceOf(IllegalArgumentException.class);

    }
}