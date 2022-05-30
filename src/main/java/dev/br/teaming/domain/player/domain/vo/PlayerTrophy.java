package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class PlayerTrophy {

    @Column(name = "trophy_current")
    private int currentTrophy;

    @Column(name = "trophy_highest")
    private int highestTrophy;

    public PlayerTrophy(int currentTrophy, int highestTrophy) {
        if (Objects.isNull(currentTrophy) || Objects.isNull(highestTrophy) || currentTrophy < 0 || highestTrophy < 0 || currentTrophy > highestTrophy) {
            throw new IllegalArgumentException();
        }
        this.currentTrophy = currentTrophy;
        this.highestTrophy = highestTrophy;
    }
}
