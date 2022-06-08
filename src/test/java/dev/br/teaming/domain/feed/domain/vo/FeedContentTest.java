package dev.br.teaming.domain.feed.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class FeedContentTest {

    @DisplayName(value = "피드 내용을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String str = "총 트로피 몇개 이상 팀원 구해용";
        //when
        final FeedContent feedContent = new FeedContent(str);
        //then
        assertThat(feedContent).isNotNull();
        assertThat(feedContent.getValue()).isEqualTo("총 트로피 몇개 이상 팀원 구해용");
    }

    @DisplayName(value = "피드내용은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String feedContent) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new FeedContent(feedContent))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
