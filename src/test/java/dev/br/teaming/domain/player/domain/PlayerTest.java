package dev.br.teaming.domain.player.domain;

import dev.br.teaming.domain.player.domain.vo.*;
import dev.br.teaming.domain.player.domain.vo.brawler.Brawlers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

import static dev.br.teaming.domain.fixture.Fixture.brawler;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    private PlayerName playerName;
    private PlayerTag playerTag;
    private PlayerTrophy playerTrophy;
    private PlayerExp playerExp;
    private Victory victory;
    private Club club;
    private Brawlers brawlers;

    @BeforeEach
    void init() {
        playerName = new PlayerName("쵝오다운", "0xffffffff");
        playerTag = new PlayerTag("#YLUPG8PJP");
        playerTrophy = new PlayerTrophy(16860, 16860);
        playerExp = new PlayerExp(88, 41031);
        victory = new Victory(310, 228, 2105);
        club = new Club("#LGPVQV", "다운스");
        brawlers = new Brawlers(Arrays.asList(brawler()));
    }

    @DisplayName(value = "플레이어를 생성한다")
    @Test
    void create() throws Exception {
        //given//when
        Player player = new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers);
        //then
        assertThat(player).isNotNull();
        assertThat(player.getPlayerName().getName()).isEqualTo("쵝오다운");
        assertThat(player.getPlayerName().getColor()).isEqualTo("0xffffffff");
        assertThat(player.getPlayerTrophy().getCurrentTrophy()).isEqualTo(16860);
        assertThat(player.getPlayerTrophy().getHighestTrophy()).isEqualTo(16860);
        assertThat(player.getPlayerExp().getExpLevel()).isEqualTo(88);
        assertThat(player.getPlayerExp().getExpPoints()).isEqualTo(41031);
        assertThat(player.getVictory().getSolo()).isEqualTo(310);
        assertThat(player.getVictory().getDuo()).isEqualTo(228);
        assertThat(player.getVictory().getTrio()).isEqualTo(2105);
        assertThat(player.getClub().getClubTag()).isEqualTo("#LGPVQV");
        assertThat(player.getClub().getClubName()).isEqualTo("다운스");
        assertThat(player.getBrawler()).isNotNull();
        assertThat(player.getBrawler().isEmpty()).isFalse();
    }
    
    @DisplayName(value = "플레이어 네임이 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_name(final PlayerName playerName) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);
        
    }

    @DisplayName(value = "플레이어 태그가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_tag(final PlayerTag playerTag) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName(value = "플레이어 트로피가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_trophy(final PlayerTrophy playerTrophy) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName(value = "플레이어 경험치정보가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_exp(final PlayerExp playerExp) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName(value = "플레이어 승리정보가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_victory(final Victory victory) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName(value = "플레이어 클럽정보가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_club(final Club club) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName(value = "플레이어 브롤러정보가 없으면 플레이어를 생성할 수 없다")
    @NullSource
    @ParameterizedTest
    void create_fail_wrong_player_brawlers(final Brawlers brawlers) throws Exception {
        //given&when&then
        assertThatThrownBy(() -> new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
