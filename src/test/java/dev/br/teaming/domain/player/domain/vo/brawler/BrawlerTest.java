package dev.br.teaming.domain.player.domain.vo.brawler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static dev.br.teaming.domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BrawlerTest {
    private BrawlerId brawlerId;
    private String brawlerName;
    private Integer power;
    private Integer rank;
    private Integer trophies;
    private Integer highestTrophies;
    private Gears gears;
    private Gadgets gadgets;
    private StarPowers starPowers;

    @BeforeEach
    public void init() {
        //given
        brawlerId = new BrawlerId(16000045);
        brawlerName = "STU";
        power = 10;
        rank = 21;
        trophies = 553;
        highestTrophies = 595;
        gears = new Gears(Arrays.asList(gear()));
        gadgets = new Gadgets(Arrays.asList(gadget()));
        starPowers = new StarPowers(Arrays.asList(starPower()));
    }

    @DisplayName(value = "브롤러를 생성한다")
    @Test
    void create() throws Exception {
        //given&when
        final Brawler brawler = new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets);
        //then
        assertThat(brawler).isNotNull();
        assertThat(brawler.getBrawlerId()).isEqualTo(16000045);
        assertThat(brawler.getBrawlerName()).isEqualTo("STU");
        assertThat(brawler.getBrawlerPower()).isEqualTo(10);
        assertThat(brawler.getBrawlerRank()).isEqualTo(21);
        assertThat(brawler.getBrawlerTrophy()).isEqualTo(553);
        assertThat(brawler.getBrawlerHighestTrophy()).isEqualTo(595);
        assertThat(brawler.getGears()).isNotNull();
        assertThat(brawler.getGears().isEmpty()).isFalse();
        assertThat(brawler.getGadgets()).isNotNull();
        assertThat(brawler.getGadgets().isEmpty()).isFalse();
        assertThat(brawler.getStarPowers()).isNotNull();
        assertThat(brawler.getStarPowers().isEmpty()).isFalse();
    }

    @DisplayName(value = "브롤러 아이디가 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_id(final BrawlerId brawlerId) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 명이 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(strings = {" ", ""})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_name(final String brawlerName) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 파워(레벨)가 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_power(final Integer power) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 랭크가 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_rank(final Integer rank) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 트로피가 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_trophies(final Integer trophies) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 트로피가 올바르지 않으면 브롤러를 생성할 수 없다")
    @ValueSource(ints = {-1, 0})
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_highest_trophies(final Integer highestTrophies) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 기어가 올바르지 않으면 브롤러를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_gears(final Gears gears) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 기어가 올바르지 않으면 브롤러를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_starPowers(final StarPowers starPowers) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "브롤러 가젯이 올바르지 않으면 브롤러를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_brawler_gadgets(final Gadgets gadgets) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
