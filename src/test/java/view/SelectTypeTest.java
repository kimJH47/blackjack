package view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SelectTypeTest {

    @Test
    @DisplayName("대소문자 상관없이 y, n 을 받으면 Hit 또는 Stay 타입이 만들어져야한다.")
    public void create() throws Exception{
        //given
        //when
        SelectType lowerCaseYes = SelectType.of("y");
        SelectType upperCaseYes = SelectType.of("Y");
        SelectType lowerCaseNo = SelectType.of("n");
        SelectType upperCaseNO = SelectType.of("N");
        //then
        assertThat(lowerCaseYes).isEqualTo(SelectType.HIT);
        assertThat(upperCaseYes).isEqualTo(SelectType.HIT);
        assertThat(lowerCaseNo).isEqualTo(SelectType.STAY);
        assertThat(upperCaseNO).isEqualTo(SelectType.STAY);
    }

    @Test
    @DisplayName("y 또는 n 이 아닌 다른 문자열을 받으면 예외가 발생한다.")
    public void create_ex() throws Exception{
        //given
        //when
        //then
        assertThatThrownBy(() -> SelectType.of("d"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}