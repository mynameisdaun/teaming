package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Objects;

@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Youtubers {

    @ElementCollection
    private List<Youtuber> youtubers;

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
