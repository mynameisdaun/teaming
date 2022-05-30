package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brawler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long brawlerSeq;
    @Embedded
    @Column(name = "brawler_id")
    private BrawlerId brawlerId;
    @Column(name = "brawler_name")
    private String brawlerName;
    @Column(name = "brawler_power")
    private Integer brawlerPower;
    @Column(name = "brawler_rank")
    private Integer brawlerRank;
    @Column(name = "brawler_trophy")
    private Integer brawlerTrophy;
    @Column(name = "brawler_highest_trophy")
    private Integer brawlerHighestTrophy;
    @Embedded
    private Gears gears;
    @Embedded
    private StarPowers starPowers;
    @Embedded
    private Gadgets gadgets;

    public Brawler(BrawlerId brawlerId, String brawlerName, Integer brawlerPower, Integer brawlerRank, Integer brawlerTrophy, Integer brawlerHighestTrophy,
                   Gears gears, StarPowers starPowers, Gadgets gadgets) {
        if (Objects.isNull(brawlerId) || Strings.isBlank(brawlerName) || Objects.isNull(brawlerPower) || brawlerPower <= 0 ||
                Objects.isNull(brawlerRank) || brawlerRank <= 0 || Objects.isNull(brawlerTrophy) || brawlerTrophy <= 0 || Objects.isNull(brawlerHighestTrophy) || brawlerHighestTrophy <= 0 ||
                Objects.isNull(gears) || Objects.isNull(starPowers) || Objects.isNull(gadgets)) {
            throw new IllegalArgumentException();
        }
        this.brawlerId = brawlerId;
        this.brawlerName = brawlerName;
        this.brawlerPower = brawlerPower;
        this.brawlerRank = brawlerRank;
        this.brawlerTrophy = brawlerTrophy;
        this.brawlerHighestTrophy = brawlerHighestTrophy;
        this.gears = gears;
        this.starPowers = starPowers;
        this.gadgets = gadgets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brawler brawler = (Brawler) o;

        return brawlerId != null ? brawlerId.equals(brawler.brawlerId) : brawler.brawlerId == null;
    }

    @Override
    public int hashCode() {
        return brawlerId != null ? brawlerId.hashCode() : 0;
    }
}
