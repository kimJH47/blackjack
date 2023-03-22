package domain;

import static org.assertj.core.api.Assertions.*;

import domain.card.Card;
import domain.card.Rank;
import domain.card.Symbol;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardTest {


    @Test
    @DisplayName("create 메서드 사용시 카드 전체 list 가 섞인체 반환되어야한다.")
    public void create() {
        //given
        List<Card> expected = Arrays.stream(Rank.values())
                .flatMap(rank ->
                        Arrays.stream(Symbol.values()).map(symbol -> new Card(rank, symbol)))
                .collect(Collectors.toList());
        //when
        List<Card> actual = Card.create();
        //then
        assertThat(expected.size()).isEqualTo(actual.size());
        assertThat(expected.stream()
                .map(Card::toString)
                .allMatch(
                        str -> actual.stream()
                                .map(Card::toString)
                                .collect(Collectors.toList())
                                .contains(str)
                )).isTrue();
    }
}