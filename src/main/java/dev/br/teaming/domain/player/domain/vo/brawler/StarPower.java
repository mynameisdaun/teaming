package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class StarPower {

    private Integer starPowerId;
    private String starPowerName;

    public StarPower(Integer starPowerId, String starPowerName) {
        if(Objects.isNull(starPowerId) || starPowerId <= 0 || Strings.isBlank(starPowerName)) {
            throw new IllegalArgumentException();
        }
        this.starPowerId = starPowerId;
        this.starPowerName = starPowerName;
    }
}
