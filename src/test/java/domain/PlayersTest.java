package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {
    @Test
    @DisplayName("올바른 형식의 이름 리스트가 오면 예외 없이 플레이어가 생성되어야한다.")
    public void crate() throws Exception{
        //given
        Players players = new Players();
        List<String> playerNames = List.of("asd", "poby", "glan");
        //when
        //then
        assertThatCode(() -> players.add(playerNames))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("player 생성시 올바르지않은 이름형식 리스트가 오면 예외가 발생해야함")
    public void create_ex() throws Exception{
        //given
        Players players = new Players();
        List<String> playerNames = List.of("asd", "poby!@", "g.lan");
        //when
        //then
        assertThatThrownBy(() -> players.add(playerNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}