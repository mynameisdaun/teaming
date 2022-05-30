package dev.br.teaming.domain.player.repository;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByPlayerTag(PlayerTag playerTag);
}
