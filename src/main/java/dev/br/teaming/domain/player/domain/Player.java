package dev.br.teaming.domain.player.domain;

import dev.br.teaming.domain.player.domain.vo.*;
import dev.br.teaming.domain.player.domain.vo.brawler.Brawlers;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerSeq;

    @Embedded
    private PlayerName playerName;

    @Embedded
    @Column(name = "player_tag")
    private PlayerTag playerTag;

    @Embedded
    private PlayerTrophy playerTrophy;

    @Embedded
    private PlayerExp playerExp;

    @Embedded
    private Victory victory;

    @Embedded
    private Club club;

    @Embedded
    private Brawlers brawlers;

    public Player(PlayerName playerName, PlayerTag playerTag, PlayerTrophy playerTrophy, PlayerExp playerExp, Victory victory, Club club, Brawlers brawlers) {
        if(Objects.isNull(playerName) || Objects.isNull(playerTag) || Objects.isNull(playerTrophy) ||
           Objects.isNull(playerExp) || Objects.isNull(victory) || Objects.isNull(club) || Objects.isNull(brawlers)) {
            throw new IllegalArgumentException();
        }
        this.playerName = playerName;
        this.playerTag = playerTag;
        this.playerTrophy = playerTrophy;
        this.playerExp = playerExp;
        this.victory = victory;
        this.club = club;
        this.brawlers = brawlers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return playerSeq == player.playerSeq;
    }

    @Override
    public int hashCode() {
        return (int) (playerSeq ^ (playerSeq >>> 32));
    }
}
