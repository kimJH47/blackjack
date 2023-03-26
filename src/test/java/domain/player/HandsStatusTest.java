package domain.player;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandsStatusTest {

    @ParameterizedTest
    @MethodSource("providerScoreAndHandStatus")
    @DisplayName("점수에 맞는 HandStatus 가 생성 되어야한다.")
    public void create(int score, HandsStatus expected) throws Exception {
        //given
        //when
        //then
        assertThat(HandsStatus.of(score)).isEqualTo(expected);
    }

    private static Stream<Arguments> providerScoreAndHandStatus() {
        return Stream.of(
                Arguments.of(21, HandsStatus.BLACK_JACK),
                Arguments.of(20, HandsStatus.NONE),
                Arguments.of(1, HandsStatus.NONE),
                Arguments.of(10, HandsStatus.NONE),
                Arguments.of(11, HandsStatus.NONE),
                Arguments.of(22, HandsStatus.BUST),
                Arguments.of(23, HandsStatus.BUST)
        );
    }

}