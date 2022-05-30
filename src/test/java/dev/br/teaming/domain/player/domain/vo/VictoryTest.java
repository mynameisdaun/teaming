package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VictoryTest {

    static Stream<Arguments> wrong_victory_list() {
        return Stream.of(
                Arguments.of(-1, 1, 1),
                Arguments.of(1, -1, 1),
                Arguments.of(1, 1, -1)
        );
    }

    @DisplayName(value = "승리 정보를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final int solo = 10;
        final int duo = 10;
        final int trio = 10;
        //when
        final Victory victory = new Victory(solo, duo, trio);
        //then
        assertThat(victory).isNotNull();
        assertThat(victory.getSolo()).isEqualTo(10);
        assertThat(victory.getDuo()).isEqualTo(10);
        assertThat(victory.getTrio()).isEqualTo(10);
    }

    @DisplayName(value = "승리 정보의 각 승리 수는 이상이어야 한다")
    @MethodSource("wrong_victory_list")
    @ParameterizedTest
    void create_fail_wrong_victory(final int solo, final int duo, final int trio) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Victory(solo, duo, trio))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
