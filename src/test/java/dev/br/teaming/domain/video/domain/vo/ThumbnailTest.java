package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ThumbnailTest {

    @DisplayName(value = "썸네일을 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        final Thumbnail thumbnail = new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
        //then
        assertThat(thumbnail).isNotNull();
        assertThat(thumbnail.isDefault()).isTrue();
        assertThat(thumbnail.getUrl()).isEqualTo("https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg");
        assertThat(thumbnail.getWidth()).isEqualTo(120.0);
        assertThat(thumbnail.getHeight()).isEqualTo(90.0);
    }

    @DisplayName(value = "썸네일 타입은 빈 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_thumbnail_type(final ThumbnailType type) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Thumbnail(type, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "썸네일 url은 빈 값이 될 수 없다")
    @ValueSource(strings = {"", " "})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_url(final String url) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Thumbnail(ThumbnailType.DEFAULT, url, 120.0, 90.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "width는 0 이상이어야 한다")
    @ValueSource(strings = {"-1", "0"})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_width(final Double width) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", width, 90.0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "height는 0 이상이어야 한다")
    @ValueSource(strings = {"-1", "0"})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_height(final Double height) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, height))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "기본 타입의 썸네일인지 확인한다")
    @EnumSource(value = ThumbnailType.class, names = {"MEDIUM", "HIGH"})
    @ParameterizedTest
    void isDefault(final ThumbnailType type) {
        //given
        final Thumbnail thumbnail = new Thumbnail(type, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
        //when&&then
        assertThat(thumbnail.isDefault()).isFalse();
    }

    @DisplayName(value = "중간 타입의 썸네일인지 확인한다")
    @EnumSource(value = ThumbnailType.class, names = {"DEFAULT", "HIGH"})
    @ParameterizedTest
    void isMedium(final ThumbnailType type) {
        //given
        final Thumbnail thumbnail = new Thumbnail(type, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
        //when&&then
        assertThat(thumbnail.isMedium()).isFalse();
    }

    @DisplayName(value = "큰 타입의 썸네일인지 확인한다")
    @EnumSource(value = ThumbnailType.class, names = {"MEDIUM", "DEFAULT"})
    @ParameterizedTest
    void isHigh(final ThumbnailType type) {
        //given
        final Thumbnail thumbnail = new Thumbnail(type, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
        //when&&then
        assertThat(thumbnail.isHigh()).isFalse();
    }
}
