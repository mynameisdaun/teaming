package dev.br.teaming.domain.player.domain.vo.brawler;

import java.util.Objects;

public class Gear {

    private Integer gearId;
    private Integer gearLevel;
    private GearType gearType;

    public Gear(Integer gearId, Integer gearLevel, GearType gearType) {
        if( Objects.isNull(gearId) || Objects.isNull(gearLevel) || gearLevel <=0 || gearId <=0 || Objects.isNull(gearType) ) {
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
