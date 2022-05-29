package dev.br.teaming.domain.player.domain.vo.brawler;

import dev.br.teaming.domain.video.domain.vo.Thumbnail;
import dev.br.teaming.domain.video.domain.vo.Thumbnails;
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

import static dev.br.teaming.domain.fixture.Fixture.gadget;
import static dev.br.teaming.domain.fixture.Fixture.thumbnail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GadgetsTest {

    static Stream<Arguments> wrong_gadget_list() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList()))
        );
    }

    @DisplayName(value = "Gadgets를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Gadgets gadgets = new Gadgets(new ArrayList<>(Arrays.asList(gadget())));
        //then
        assertThat(gadgets).isNotNull();
        assertThat(gadgets.isEmpty()).isFalse();
        assertThat(gadgets.size()).isOne();
    }

    @DisplayName(value = "Gadget List는 null 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Gadget> gadgetList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Gadgets(gadgetList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
