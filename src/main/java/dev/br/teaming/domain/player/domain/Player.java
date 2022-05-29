package dev.br.teaming.domain.player.domain;

import dev.br.teaming.domain.player.domain.vo.PlayerName;
import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.player.domain.vo.Trophy;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userSeq;

    @Embedded
    private PlayerName playerName;

    @Embedded
    @Column(name = "player_tag")
    private PlayerTag playerTag;

    @Embedded
    private Trophy trophy;

}
