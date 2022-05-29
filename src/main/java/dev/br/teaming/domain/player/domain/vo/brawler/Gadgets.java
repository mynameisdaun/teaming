package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gadgets {
    private List<Gadget> gadgets;

    public Gadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public boolean isEmpty() {
        return this.gadgets.isEmpty();
    }

    public int size() {
        return this.gadgets.size();
    }
}
