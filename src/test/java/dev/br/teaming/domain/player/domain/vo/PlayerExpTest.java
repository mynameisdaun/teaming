package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerExpTest {

    static Stream<Arguments> wrong_exp_list() {
        return Stream.of(
                Arguments.of(1, -1),
                Arguments.of(-1, 1)
        );
    }

    @DisplayName(value = "플레이어 경험치를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final int expLevel = 10;
        final int expPoints = 100;
        //when
        final PlayerExp playerExp = new PlayerExp(expLevel, expPoints);
        //then
        assertThat(playerExp).isNotNull();
        assertThat(playerExp.getExpLevel()).isEqualTo(10);
        assertThat(playerExp.getExpPoints()).isEqualTo(100);
    }

    @DisplayName(value = "플레이어 경험치 레벨과 포인트는 각 0이상이어야 한다")
    @MethodSource("wrong_exp_list")
    @ParameterizedTest
    void create_fail_wrong_trophy(final int expLevel, final int expPoints) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new PlayerExp(expLevel, expPoints))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
