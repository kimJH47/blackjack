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
    public void create(int sum, int aceCount, int expected) throws Exception {
        //given
        //when
        int actual = Score.calc(sum, aceCount);
        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSumExcludeAceScoreAndsAceCount() {
        return Stream.of(
                Arguments.of(10, 1, 21),
                Arguments.of(20, 1, 21),
                Arguments.of(21, 0, 21),
                Arguments.of(20, 2, 22),
                Arguments.of(22, 0, 22),
                Arguments.of(10, 2, 12),
                Arguments.of(9, 1, 20),
                Arguments.of(1, 1, 12),
                Arguments.of(5, 3, 18),
                Arguments.of(0, 4, 14),
                Arguments.of(0, 2, 12)
        );
    }

}