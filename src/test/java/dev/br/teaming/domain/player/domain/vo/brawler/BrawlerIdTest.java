package dev.br.teaming.domain.player.domain.vo.brawler;

import dev.br.teaming.domain.video.domain.vo.VideoId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BrawlerIdTest {

    @DisplayName(value = "브롤러 ID를 생성한다")
    @Test
    void create() throws Exception {
        //given
        final Integer id = 1600002;
        //when
        final BrawlerId brawlerid = new BrawlerId(id);
        //then
        assertThat(brawlerid).isNotNull();
        assertThat(brawlerid.getBrawlerId()).isEqualTo(1600002);
    }

    @DisplayName(value = "브롤러 ID 반드시 양수 이어야 한다")
    @ValueSource(ints = {0, -1})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_name(final Integer id) throws Exception {
        //given&&when&&then
        assertThatThrownBy(() -> new BrawlerId(id))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
