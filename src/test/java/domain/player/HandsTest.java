package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Symbol;
import domain.player.dto.HandsStatusDto;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandsTest {


    @Test
    @DisplayName("Hand 객체 생성 시 2개의 카드 리스트를 인자로 받고 생성되어야한다.")
    public void create() throws Exception {
        //given
        List<Card> cards = List.of(new Card(Rank.ACE, Symbol.CLOVER), new Card(Rank.TWO, Symbol.CLOVER));
        //when
        //then
        Hands hands = new Hands(cards);
        HandsStatusDto handsStatus = hands.createHandsStatus();
        assertThat(handsStatus.getCards().size()).isEqualTo(2);
        assertThat(handsStatus.getHandsStatus()).isEqualTo(HandsStatus.NONE);

    }

    @Test
    @DisplayName("add 메서드로 카드 추가시 추가된 카드리스트 상태가 반환되어야함")
    void add() {
        //given
        List<Card> cards = List.of(new Card(Rank.ACE, Symbol.CLOVER), new Card(Rank.TWO, Symbol.CLOVER));
        Hands hands = new Hands(cards);
        //when
        Card card = new Card(Rank.TEN, Symbol.SPADE);
        HandsStatusDto actual = hands.add(List.of(card));
        //then
        assertThat(actual.getHandsStatus()).isEqualTo(HandsStatus.NONE);
        assertThat(actual.getCards().size()).isEqualTo(3);
        assertThat(actual.getCards()).contains(card.toString());

    }


}