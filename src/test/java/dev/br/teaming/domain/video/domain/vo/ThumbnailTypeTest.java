package dev.br.teaming.domain.video.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ThumbnailTypeTest {

    @DisplayName(value = "썸네일타입 ENUM을 생성한다")
    @ParameterizedTest
    @EnumSource(ThumbnailType.class)
    void create_ThumbnailType(ThumbnailType type) throws Exception {
        //given//when//then
        assertThat(type).isNotNull();
    }

    @DisplayName(value = "기본 썸네일 타입인지 확인한다")
    @Test
    void isDefault() throws Exception {
        //given
        ThumbnailType type = ThumbnailType.DEFAULT;
        //when//then
        assertThat(type.isDefault()).isTrue();
    }

    @DisplayName(value = "중간 썸네일 타입인지 확인한다")
    @Test
    void isMedium() throws Exception {
        //given
        ThumbnailType type = ThumbnailType.MEDIUM;
        //when//then
        assertThat(type.isMedium()).isTrue();
    }

    @DisplayName(value = "큰 썸네일 타입인지 확인한다")
    @Test
    void isHigh() throws Exception {
        //given
        ThumbnailType type = ThumbnailType.HIGH;
        //when//then
        assertThat(type.isHigh()).isTrue();
    }
}
