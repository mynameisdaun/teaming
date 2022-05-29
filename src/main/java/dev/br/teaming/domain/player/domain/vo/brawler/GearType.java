package dev.br.teaming.domain.player.domain.vo.brawler;

public enum GearType {
    SPEED, DAMAGE;

    public boolean isSpeed() {
        return this==GearType.SPEED;
    }

    public boolean isDamage() {
        return this==GearType.DAMAGE;
    }
}
