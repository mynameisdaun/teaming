package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brawlers {

    @OneToMany
    @CollectionTable(name = "brawler", joinColumns = @JoinColumn(name = "player_seq"))
    private List<Brawler> brawlers;

    public Brawlers(List<Brawler> brawlers) {
        if (Objects.isNull(brawlers) || brawlers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.brawlers = brawlers;
    }

    public boolean isEmpty() {
        return brawlers.isEmpty();
    }

    public int size() {
        return brawlers.size();
    }
}
