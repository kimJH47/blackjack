package domain.player;

import util.Score;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ScoreTest {

    @ParameterizedTest
    @MethodSource("provideSumExcludeAceScoreAndsAceCount")
    @DisplayName("각 점수에 해당하는 HandStatus 가 생성되어야한다")
    public void create(int sum, int aceCount, HandsStatus expected) throws Exception {
        //given
        //when
        HandsStatus actual = Score.calc(sum, aceCount);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSumExcludeAceScoreAndsAceCount() {
        return Stream.of(
                Arguments.of(10, 1,HandsStatus.BLACK_JACK),
                Arguments.of(20, 1,HandsStatus.BLACK_JACK),
                Arguments.of(21, 0,HandsStatus.BLACK_JACK),
                Arguments.of(20, 2,HandsStatus.BUST),
                Arguments.of(22, 0,HandsStatus.BUST),
                Arguments.of(10, 2,HandsStatus.NONE),
                Arguments.of(9, 1,HandsStatus.NONE),
                Arguments.of(1, 1,HandsStatus.NONE),
                Arguments.of(5, 3,HandsStatus.NONE),
                Arguments.of(0, 4,HandsStatus.NONE),
                Arguments.of(0, 2,HandsStatus.NONE)
        );
    }

}