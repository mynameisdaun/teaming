package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GadgetTest {

    @DisplayName(value = "가젯을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final int gadgetId = 23000362;
        final String gadgetName = "BREAKTHROUGH";
        //when
        final Gadget gadget = new Gadget(gadgetId, gadgetName);
        //then
        assertThat(gadget).isNotNull();
        assertThat(gadget.getGadgetId()).isEqualTo(23000362);
        assertThat(gadget.getGadgetName()).isEqualTo("BREAKTHROUGH");
    }

    @DisplayName(value = "가젯 아이디가 없으면 생성할 수 없다")
    @ValueSource(ints = {-1})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_id(final Integer gadgetId) throws Exception {
        //given
        final String gadgetName = "BREAKTHROUGH";
        //when&then
        assertThatThrownBy(() -> new Gadget(gadgetId, gadgetName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "가젯 이름이 비어있으면 생성할 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String gadgetName) throws Exception {
        //given
        final Integer gadgetId = 23000362;
        //when&then
        assertThatThrownBy(() -> new Gadget(gadgetId, gadgetName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
