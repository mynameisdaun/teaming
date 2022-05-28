package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class YoutuberTest {

    @DisplayName(value = "유튜버를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String id = "UCoH2pCzAr6zWDG-LtUiLWRw";
        final String name = "브롤";
        //when
        final Youtuber youtuber = new Youtuber(id, name);
        //then
        assertThat(youtuber).isNotNull();
        assertThat(youtuber.getYoutuberId()).isEqualTo("UCoH2pCzAr6zWDG-LtUiLWRw");
        assertThat(youtuber.getName().getValue()).isEqualTo("브롤");
    }

    @DisplayName(value = "유튜버 ID는 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_id(final String id) throws Exception {
        //given
        final String name = "브롤";
        // when&&then
        assertThatThrownBy(() -> new Youtuber(id, name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "유튜버 이름은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_empty_name(final String name) throws Exception {
        //given
        final String id = "UCoH2pCzAr6zWDG-LtUiLWRw";
        // when&&then
        assertThatThrownBy(() -> new Youtuber(id, name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
