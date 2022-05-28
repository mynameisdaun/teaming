package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class VideoIdTest {

    @DisplayName(value = "비디오 ID를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String id = "jYMrymKeJY0";
        //when
        final VideoId videoId = new VideoId(id);
        //then
        assertThat(videoId).isNotNull();
        assertThat(videoId.getVideoId()).isEqualTo("jYMrymKeJY0");
    }

    @DisplayName(value = "비디오 ID는 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String id) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new VideoId(id))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
