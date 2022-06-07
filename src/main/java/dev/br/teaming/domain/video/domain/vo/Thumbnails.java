package dev.br.teaming.domain.video.domain.vo;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchResultSnippet;
import com.google.api.services.youtube.model.ThumbnailDetails;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Thumbnails {

    @ElementCollection
    private List<Thumbnail> thumbnails;

    public Thumbnails(List<Thumbnail> thumbnails) {
        if (Objects.isNull(thumbnails) || thumbnails.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.thumbnails = thumbnails;
    }

    public Thumbnails(ThumbnailDetails thumbnailDetails) {
        List<Thumbnail> thumbnails = new ArrayList<>();
        if(!Objects.isNull(thumbnailDetails.getDefault())) {
            thumbnails.add(Thumbnail.of(ThumbnailType.DEFAULT, thumbnailDetails.getDefault()));
        }
        if(!Objects.isNull(thumbnailDetails.getHigh())) {
            thumbnails.add(Thumbnail.of(ThumbnailType.HIGH,    thumbnailDetails.getHigh()));
        }
        if(!Objects.isNull(thumbnailDetails.getMedium())) {
            thumbnails.add(Thumbnail.of(ThumbnailType.MEDIUM,  thumbnailDetails.getMedium()));
        }
        if(!Objects.isNull(thumbnailDetails.getStandard())) {
            thumbnails.add(Thumbnail.of(ThumbnailType.STANDARD,  thumbnailDetails.getStandard()));
        }
        if(!Objects.isNull(thumbnailDetails.getMaxres())) {
            thumbnails.add(Thumbnail.of(ThumbnailType.MAXRES,  thumbnailDetails.getMaxres()));
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
