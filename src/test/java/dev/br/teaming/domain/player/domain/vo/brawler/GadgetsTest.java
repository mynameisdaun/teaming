package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.br.teaming.domain.fixture.Fixture.gadget;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GadgetsTest {

    @DisplayName(value = "Gadgets를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Gadgets gadgets = new Gadgets(new ArrayList<>(Arrays.asList(gadget())));
        //then
        assertThat(gadgets).isNotNull();
        assertThat(gadgets.isEmpty()).isFalse();
        assertThat(gadgets.size()).isOne();
    }

    @DisplayName(value = "Gadget List는 null 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Gadget> gadgetList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Gadgets(gadgetList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
