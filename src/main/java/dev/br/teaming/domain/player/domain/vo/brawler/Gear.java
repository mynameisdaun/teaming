package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@EqualsAndHashCode
public class Gear {
    @Column(name = "gear_id")
    private Integer gearId;
    @Column(name = "gear_level")
    private Integer gearLevel;
    @Column(name = "gear_type")
    private GearType gearType;

    public Gear(Integer gearId, Integer gearLevel, GearType gearType) {
        if (Objects.isNull(gearId) || Objects.isNull(gearLevel) || gearLevel <= 0 || gearId <= 0 || Objects.isNull(gearType)) {
            throw new IllegalArgumentException();
        }
        this.gearId = gearId;
        this.gearLevel = gearLevel;
        this.gearType = gearType;
    }

    public boolean isSpeed() {
        return this.gearType.isSpeed();
    }

    public boolean isDamage() {
        return this.gearType.isDamage();
    }
}
