package dev.br.teaming.domain.player.domain.vo;

import dev.br.teaming.domain.video.domain.vo.VideoTitle;
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
        //when
        final PlayerName playerN = new PlayerName(name);
        //then
        assertThat(playerN).isNotNull();
        assertThat(playerN.getValue()).isEqualTo("stew");
    }

    @DisplayName(value = "회원 이름은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String name) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new VideoTitle(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
