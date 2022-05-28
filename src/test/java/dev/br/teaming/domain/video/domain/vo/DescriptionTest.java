package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DescriptionTest {

    @DisplayName(value = "설명을 생성한다")
    @Test
    void create() throws Exception {
        //given
        final String str = "안녕하세요 돈안쓰고 게임을 즐길 수 있는 꿀팁들을 전해드리는 다운입니다! 여러분의 구독 & 좋아요는 영상을 만드는데 정말 큰 힘이 ...";
        //when
        final Description description = new Description(str);
        //then
        assertThat(description).isNotNull();
        assertThat(description.getValue()).isEqualTo("안녕하세요 돈안쓰고 게임을 즐길 수 있는 꿀팁들을 전해드리는 다운입니다! 여러분의 구독 & 좋아요는 영상을 만드는데 정말 큰 힘이 ...");
    }

    @DisplayName(value = "설명은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final String description) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Description(description))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
