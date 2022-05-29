package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.br.teaming.domain.fixture.Fixture.brawler;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BrawlersTest {

    @DisplayName(value = "Brawlers 를 생성한다")
    @Test
    void create() throws Exception {
        //given&&when
        Brawlers brawlers = new Brawlers(new ArrayList<>(Arrays.asList(brawler())));
        //then
        assertThat(brawlers).isNotNull();
        assertThat(brawlers.isEmpty()).isFalse();
        assertThat(brawlers.size()).isOne();
    }

    @DisplayName(value = "Brawler List는 null 값이 될 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail(final List<Brawler> brawlerList) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new Brawlers(brawlerList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
