package dev.br.teaming.domain.video.domain.vo;

import dev.br.teaming.domain.model.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VideoTitleTest {

    @DisplayName(value = "비디오 제목을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String title = "stew";
        //when
        final VideoTitle videoTitle = new VideoTitle(title);
        //then
        assertThat(videoTitle).isNotNull();
        assertThat(videoTitle.getValue()).isEqualTo("stew");
    }

    @DisplayName(value = "비디오 제목은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String title) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new VideoTitle(title))
                .isInstanceOf(IllegalArgumentException.class);
    }

}