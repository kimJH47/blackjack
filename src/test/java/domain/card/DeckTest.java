package domain.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    @DisplayName("덱 생성 후 drawFirst 시 카드 2장을 담은 리스트가 반환되어야한다.")
    public void draw_first() throws Exception{
        //given
        Deck deck = Deck.create();
        //when
        List<Card> cards = deck.drawFirst();
        //then
        assertThat(cards.size()).isEqualTo(2);
        assertThat(cards.get(0).toString()).isNotEqualTo(cards.get(1).toString());
    }
}