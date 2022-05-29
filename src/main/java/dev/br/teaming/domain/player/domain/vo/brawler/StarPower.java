package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class StarPower {
    @Column(name = "starpower_id")
    private Integer starPowerId;
    @Column(name = "starpower_name")
    private String starPowerName;

    public StarPower(Integer starPowerId, String starPowerName) {
        if(Objects.isNull(starPowerId) || starPowerId <= 0 || Strings.isBlank(starPowerName)) {
            throw new IllegalArgumentException();
        }
        this.starPowerId = starPowerId;
        this.starPowerName = starPowerName;
    }
}
