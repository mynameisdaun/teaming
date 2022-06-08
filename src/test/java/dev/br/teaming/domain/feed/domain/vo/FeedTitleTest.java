package dev.br.teaming.domain.feed.domain.vo;

import dev.br.teaming.domain.video.domain.vo.VideoTitle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FeedTitleTest {

    @DisplayName(value = "피드 제목을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String title = "팀원구해요";
        //when
        final FeedTitle feedTitle = new FeedTitle(title);
        //then
        assertThat(feedTitle).isNotNull();
        assertThat(feedTitle.getValue()).isEqualTo("팀원구해요");
    }

    @DisplayName(value = "피드 제목은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String title) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new FeedTitle(title))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
