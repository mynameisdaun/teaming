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
public class Gears {
    private List<Gear> gears;

    public Gears(List<Gear> gears) {
        if(Objects.isNull(gears)) {
            throw new IllegalArgumentException();
        }
        this.gears = gears;
    }

    public boolean isEmpty() {
        return this.gears.isEmpty();
    }

    public int size() {
        return this.gears.size();
    }
}
