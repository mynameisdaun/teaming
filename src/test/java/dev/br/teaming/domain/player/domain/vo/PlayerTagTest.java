package dev.br.teaming.domain.player.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayerTagTest {

    @DisplayName(value = "회원 Tag를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String tag = "#YLUPG8PJP";
        //when
        final PlayerTag playerTag = new PlayerTag(tag);
        //then
        assertThat(playerTag).isNotNull();
        assertThat(playerTag.getPlayerTag()).isEqualTo("#YLUPG8PJP");
    }

    @DisplayName(value = "비디오 ID는 빈 값이 될 수 없고, #으로 시작해야 한다")
    @ValueSource(strings = {"", " ", "YLUPG8PJP"})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String tag) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new PlayerTag(tag))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
