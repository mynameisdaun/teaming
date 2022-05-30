package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gadgets {

    @ElementCollection
    private List<Gadget> gadgets;

    public Gadgets(List<Gadget> gadgets) {
        if (Objects.isNull(gadgets)) {
            throw new IllegalArgumentException();
        }
        this.gadgets = gadgets;
    }

    public boolean isEmpty() {
        return this.gadgets.isEmpty();
    }

    public int size() {
        return this.gadgets.size();
    }
}
