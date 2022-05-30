package dev.br.teaming.domain.player.repository;

import dev.br.teaming.domain.fixture.Fixture;
import dev.br.teaming.domain.player.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private PlayerRepository playerRepository;


    @DisplayName(value = "Player를 저장한다")
    @Test
    void save() throws Exception {
        //given
        final Player player = Fixture.player();
        //when
        final Player saved = playerRepository.save(player);
        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getPlayerSeq()).isEqualTo(player.getPlayerSeq());
        assertThat(saved.getPlayerName()).isEqualTo(player.getPlayerName());
        assertThat(saved.getPlayerTag()).isEqualTo(player.getPlayerTag());
        assertThat(saved.getPlayerTrophy()).isEqualTo(player.getPlayerTrophy());
        assertThat(saved.getPlayerExp()).isEqualTo(player.getPlayerExp());
        assertThat(saved.getVictory()).isEqualTo(player.getVictory());
        assertThat(saved.getClub()).isEqualTo(player.getClub());
        assertThat(saved.getBrawlers()).isEqualTo(player.getBrawlers());
    }

    @DisplayName(value = "PlayerSeq로 플레이어를 조회한다")
    @Test
    void findByPlayerSeq() throws Exception {
        //given
        final Player player = Fixture.player();
        em.persist(player);
        //when
        final Player findPlayer = playerRepository.findById(player.getPlayerSeq())
                .orElseThrow(NoSuchElementException::new);
        //then
        assertThat(findPlayer).isNotNull();
        assertThat(findPlayer.getPlayerSeq()).isEqualTo(player.getPlayerSeq());
        assertThat(findPlayer.getPlayerName()).isEqualTo(player.getPlayerName());
        assertThat(findPlayer.getPlayerTag()).isEqualTo(player.getPlayerTag());
        assertThat(findPlayer.getPlayerTrophy()).isEqualTo(player.getPlayerTrophy());
        assertThat(findPlayer.getPlayerExp()).isEqualTo(player.getPlayerExp());
        assertThat(findPlayer.getVictory()).isEqualTo(player.getVictory());
        assertThat(findPlayer.getClub()).isEqualTo(player.getClub());
        assertThat(findPlayer.getBrawlers()).isEqualTo(player.getBrawlers());
    }

    @DisplayName(value = "존재하지 않는 ID로 플레이어를 조회할 수 없다")
    @Test
    void findByPlayer_fail_non_exist() throws Exception {
        //given
        final Player player = Fixture.player();
        em.persist(player);
        //when&&then
        assertThatThrownBy(() -> playerRepository.findById(200L).orElseThrow(NoSuchElementException::new))
                .isInstanceOf(NoSuchElementException.class);
    }
}
