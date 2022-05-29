package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StarPowers {
    private List<StarPower> starPowers;

    public StarPowers(List<StarPower> starPowers) {
        if(Objects.isNull(starPowers)) {
            throw new IllegalArgumentException();
        }
        this.starPowers = starPowers;
    }

    public boolean isEmpty() {
        return this.starPowers.isEmpty();
    }

    public int size() {
        return this.starPowers.size();
    }
}
