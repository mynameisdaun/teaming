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

import static dev.br.teaming.domain.fixture.Fixture.youtuber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YoutubersTest {

    static Stream<Arguments> wrong_youtuber_list() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList()))
        );
    }

    @DisplayName(value = "Youtubers를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Youtubers youtubers = new Youtubers(Arrays.asList(youtuber()));
        //then
        assertThat(youtubers).isNotNull();
        assertThat(youtubers.isEmpty()).isFalse();
        assertThat(youtubers.size()).isOne();
    }

    @DisplayName(value = "Youtuber List는 비어있을 수 없다")
    @MethodSource("wrong_youtuber_list")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Youtuber> youtuberList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Youtubers(youtuberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
