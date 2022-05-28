package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static dev.br.teaming.domain.fixture.Fixture.thumbnail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ThumbnailsTest {

    static Stream<Arguments> wrong_thumbnail_list() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList()))
        );
    }

    @DisplayName(value = "Thumbnails를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Thumbnails thumbnails = new Thumbnails(new ArrayList<>(Arrays.asList(thumbnail())));
        //then
        assertThat(thumbnails).isNotNull();
        assertThat(thumbnails.isEmpty()).isFalse();
        assertThat(thumbnails.size()).isOne();
    }

    @DisplayName(value = "Thumbnail List는 비어있을 수 없다")
    @MethodSource("wrong_thumbnail_list")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Thumbnail> thumbnailList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Thumbnails(thumbnailList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
