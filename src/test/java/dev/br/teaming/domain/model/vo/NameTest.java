package dev.br.teaming.domain.model.vo;

import dev.br.teaming.domain.video.domain.vo.VideoId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NameTest {

    @DisplayName(value = "이름을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String str = "stew";
        //when
        final Name name = new Name(str);
        //then
        assertThat(name).isNotNull();
        assertThat(name.getName()).isEqualTo("stew");
    }

    @DisplayName(value = "이름은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String name) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
