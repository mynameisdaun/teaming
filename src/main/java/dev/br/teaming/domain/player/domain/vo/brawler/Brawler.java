package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brawler {
    @Column(name = "brawler_id")
    private int brawlerId;
    @Column(name = "brawler_name")
    private int brawlerName;
    @Column(name = "brawler_power")
    private int brawlerPower;
    @Column(name = "brawler_rank")
    private int brawlerRank;
    @Column(name = "brawler_trophy")
    private int brawlerTrophy;
    @Column(name = "brawler_highest_trophy")
    private int brawlerHighestTrophy;
    @Embedded
    private Gears gears;
    @Embedded
    private StarPowers starPowers;
    @Embedded
    private Gadgets gadgets;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brawler brawler = (Brawler) o;

        return brawlerId == brawler.brawlerId;
    }

    @Override
    public int hashCode() {
        return brawlerId;
    }
}
