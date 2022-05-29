package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayerExp {

    @Column(name="exp_level")
    private int expLevel;

    @Column(name="exp_points")
    private int expPoints;

    public PlayerExp(int expLevel, int expPoints) {
        if(Objects.isNull(expLevel) || Objects.isNull(expPoints) || expLevel < 0  || expPoints < 0) {
            throw new IllegalArgumentException();
        }
        this.expLevel = expLevel;
        this.expPoints = expPoints;
    }
}
