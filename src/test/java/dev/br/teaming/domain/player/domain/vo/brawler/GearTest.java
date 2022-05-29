package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GearTest {

    @DisplayName(value = "기어를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final Integer gearId = 62000000;
        final Integer gearLevel = 2;
        final GearType gearType = GearType.SPEED;
        //when
        final Gear gear = new Gear(gearId, gearLevel, gearType);
        //then
        assertThat(gear).isNotNull();
        assertThat(gear.getGearId()).isEqualTo(62000000);
        assertThat(gear.getGearLevel()).isEqualTo(2);
        assertThat(gear.getGearType()).isEqualTo(GearType.SPEED);
    }

    @DisplayName(value = "기어 아이디가 없으면 기어를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_id(final Integer gearId) throws Exception {
        //given
        final Integer gearLevel = 2;
        final GearType gearType = GearType.SPEED;
        //when&then
        assertThatThrownBy(() -> new Gear(gearId, gearLevel, gearType))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "기어 타입이 없으면 기어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_type(final GearType gearType) throws Exception {
        //given
        final Integer gearId = 62000000;
        final Integer gearLevel = 2;
        //when&then
        assertThatThrownBy(() -> new Gear(gearId, gearLevel, gearType))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
