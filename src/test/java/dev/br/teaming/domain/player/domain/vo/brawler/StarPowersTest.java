package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.br.teaming.domain.fixture.Fixture.starPower;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StarPowersTest {

    @DisplayName(value = "StarPowers를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        StarPowers starPowers = new StarPowers(new ArrayList<>(Arrays.asList(starPower())));
        //then
        assertThat(starPowers).isNotNull();
        assertThat(starPowers.isEmpty()).isFalse();
        assertThat(starPowers.size()).isOne();
    }

    @DisplayName(value = "StarPower List는 null 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<StarPower> starPowerList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new StarPowers(starPowerList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
