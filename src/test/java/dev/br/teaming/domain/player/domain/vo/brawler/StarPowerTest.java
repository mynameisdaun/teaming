package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StarPowerTest {

    @DisplayName(value = "스타파워를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final Integer startPowerId = 23000362;
        final String starPowerName = "ZERO DRAG";
        //when
        final StarPower starPower = new StarPower(startPowerId, starPowerName);
        //then
        assertThat(starPower).isNotNull();
        assertThat(starPower.getStarPowerId()).isEqualTo(23000362);
        assertThat(starPower.getStarPowerName()).isEqualTo("ZERO DRAG");
    }

    @DisplayName(value = "스타파워 아이디가 올바르지 않으면 생성할 수 없다")
    @ValueSource(ints = {-1})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_id(final Integer starPowerId) throws Exception {
        //given
        final String starPowerName = "ZERO DRAG";
        //when&then
        assertThatThrownBy(() -> new StarPower(starPowerId, starPowerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "가젯 이름이 비어있으면 생성할 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String starPowerName) throws Exception {
        //given
        final Integer starPowerId = 23000362;
        //when&then
        assertThatThrownBy(() -> new Gadget(starPowerId, starPowerName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
