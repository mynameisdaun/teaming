package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerNameTest {

    @DisplayName(value = "회원 이름을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String name = "stew";
        final String color = "0xffffffff";
        //when
        final PlayerName player = new PlayerName(name, color);
        //then
        assertThat(player).isNotNull();
        assertThat(player.getName()).isEqualTo("stew");
        assertThat(player.getColor()).isEqualTo("0xffffffff");
    }

    @DisplayName(value = "회원 이름은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_invalid_name(final String name) throws Exception {
        //given
        final String color = "0xffffffff";
        // when&&then
        assertThatThrownBy(() -> new PlayerName(name, color))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "닉네임 칼라는 16진수 숫자의 문자열이어야 한다")
    @ValueSource(strings = {"", " ", "0x3dkdkd"})
    @NullSource
    @ParameterizedTest
    void create_fail_invalid_color(final String color) throws Exception {
        //given
        final String name = "stew";
        // when&&then
        assertThatThrownBy(() -> new PlayerName(name, color))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
