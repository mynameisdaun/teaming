package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Thumbnails {

    @ElementCollection
    private List<Thumbnail> thumbnails;

    public Thumbnails(List<Thumbnail> thumbnails) {
        if (Objects.isNull(thumbnails) || thumbnails.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.thumbnails = thumbnails;
    }

    public boolean isEmpty() {
        return thumbnails.isEmpty();
    }

    public int size() {
        return thumbnails.size();
    }
}
