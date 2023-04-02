import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.BlackJackResult;
import domain.card.Card;
import domain.card.Deck;
import domain.card.Rank;
import domain.card.ShuffleDeck;
import domain.card.Symbol;
import domain.player.Dealer;
import domain.dto.PlayerStatusDto;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        BlackJackResult actual = blackjackGame.addPlayer(playerNames);
        //then
        assertThat(playerNames.containsAll(actual.getParticipantNames())).isTrue();

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

    @Test
    @DisplayName("플레이어 이름을 인자로 받아 해당하는 이름의 플레이어의 카드를 추가시켜야한다.")
    public void addCard() throws Exception {
        //given
        BlackjackGame blackjackGame = new BlackjackGame(ShuffleDeck.create());
        String actual = "asd";
        List<String> playerNames = List.of("kim", "jae", "tray", actual);
        blackjackGame.addPlayer(playerNames);
        //when
        PlayerStatusDto expected = blackjackGame.addCard(actual);
        //then
        assertThat(expected.getName()).isEqualTo(actual);
        assertThat(expected.getHandsStatusDto().getCards().size()).isEqualTo(3);

    }

    @Test
    @DisplayName("딜러와 참가자의 카드를 확인하여 게임결과를 반환해야한다.")
    public void processDealerAndResult() throws Exception {
        //given
        List<Card> cards = List.of(
                new Card(Rank.ACE, Symbol.CLOVER), new Card(Rank.FIVE, Symbol.CLOVER),

                new Card(Rank.ACE, Symbol.HEART), new Card(Rank.JACK, Symbol.HEART),

                new Card(Rank.ACE, Symbol.CLOVER)

        );

        String actual = "kim";
        List<String> playerNames = List.of(actual);

        BlackjackGame blackjackGame = new BlackjackGame(new TestDeck(cards));
        blackjackGame.addPlayer(playerNames);
        //when
        BlackJackResult blackJackResult = blackjackGame.processDealerAndResult();
        PlayerStatusDto dealer = blackJackResult.getDealer();
        List<String> participantNames = blackJackResult.getParticipantNames();
        //then
        assertThat(dealer.getName()).isEqualTo(Dealer.NAME);
        assertThat(dealer.getScore()).isEqualTo(17);
        assertThat(dealer.getHandsStatusDto().getCards().size()).isEqualTo(3);
        assertThat(participantNames.get(0)).isEqualTo("kim");

//        assertThat(pariticipants.get(0)).isEqualTo(21);
//        assertThat(pariticipants.get(0).getName()).isEqualTo(actual);

    }

    static class TestDeck implements Deck {
        private final Queue<Card> cards;

        public TestDeck(List<Card> cards) {
            this.cards = new ArrayDeque<>(cards);
        }

        @Override
        public List<Card> drawFirst() {
            return draw(2);
        }

        @Override
        public List<Card> drawNormal() {
            return draw(1);
        }

        private List<Card> draw(int count) {
            return IntStream.range(0, count)
                    .mapToObj(operand -> cards.remove())
                    .collect(Collectors.toList());
        }

    }
}