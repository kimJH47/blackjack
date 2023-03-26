package domain.player;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Symbol;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DealerTest {
    @ParameterizedTest
    @MethodSource("providerCardsAndExpected")
    @DisplayName("딜러의 카드들이 17점 이상이면 ture 를 반환해야한다.")
    public void isStay(List<Card> cards,boolean expected) throws Exception {
        //given

        Dealer dealer = new Dealer();
        dealer.add(cards);
        //when
        //then
        Assertions.assertThat(dealer.isStay()).isEqualTo(expected);
    }

    private static Stream<Arguments> providerCardsAndExpected() {
        return Stream.of(
                Arguments.of(List.of(new Card(Rank.ACE, Symbol.HEART), new Card(Rank.ACE, Symbol.CLOVER)),false),
                Arguments.of(List.of(new Card(Rank.ACE, Symbol.HEART), new Card(Rank.FOUR, Symbol.CLOVER)),false),
                Arguments.of(List.of(new Card(Rank.ACE, Symbol.HEART), new Card(Rank.FIVE, Symbol.CLOVER)),false),
                Arguments.of(List.of(new Card(Rank.SEVEN, Symbol.HEART), new Card(Rank.JACK, Symbol.CLOVER)),true),
                Arguments.of(List.of(new Card(Rank.SIX, Symbol.HEART), new Card(Rank.ACE, Symbol.CLOVER)),true),
                Arguments.of(List.of(new Card(Rank.ACE, Symbol.HEART), new Card(Rank.TEN, Symbol.SPADE)),true)
        );
    }


}