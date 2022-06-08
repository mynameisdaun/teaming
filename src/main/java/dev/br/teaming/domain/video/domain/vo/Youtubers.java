package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Youtubers {

    @OneToMany
    private List<Youtuber> youtubers = new ArrayList<>();

    public Youtubers(List<Youtuber> youtubers) {
        if (Objects.isNull(youtubers) || youtubers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.youtubers = youtubers;
    }

    public boolean isEmpty() {
        return this.youtubers.isEmpty();
    }

    public int size() {
        return this.youtubers.size();
    }

}
