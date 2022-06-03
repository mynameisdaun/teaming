package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Brawlers {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Brawler> brawlers = new ArrayList<>();

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
