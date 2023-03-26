package domain.player;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Symbol;
import domain.player.dto.PlayerStatusDto;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    @DisplayName("add 시 추가된 카드와함깨 플레이어의 상태가 반환되어야 함")
    public void add() throws Exception {
        //given
        String name = "kim";
        Participant player = new Participant(name);
        //when
        PlayerStatusDto actual = player.add(
                List.of(new Card(Rank.ACE, Symbol.HEART), new Card(Rank.SEVEN, Symbol.SPADE)));
        //then
        Assertions.assertThat(actual.getName()).isEqualTo(name);
        Assertions.assertThat(actual.getHandsStatusDto().getScore()).isEqualTo(18);
        Assertions.assertThat(actual.getHandsStatusDto().getHandsStatus()).isEqualTo(HandsStatus.NONE);
    }
}