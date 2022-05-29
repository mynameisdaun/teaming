package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static dev.br.teaming.domain.fixture.Fixture.gadget;
import static dev.br.teaming.domain.fixture.Fixture.gear;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GearsTest {

    @DisplayName(value = "Gears를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Gears gears = new Gears(new ArrayList<>(Arrays.asList(gear())));
        //then
        assertThat(gears).isNotNull();
        assertThat(gears.isEmpty()).isFalse();
        assertThat(gears.size()).isOne();
    }

    @DisplayName(value = "Gear List는 null 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Gear> gearsList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Gears(gearsList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
