package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.List;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Thumbnails {

    private List<Thumbnail> thumbnails;

    public Thumbnails(List<Thumbnail> thumbnails) {
        if(Objects.isNull(thumbnails) || thumbnails.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.thumbnails = thumbnails;
    }
}
