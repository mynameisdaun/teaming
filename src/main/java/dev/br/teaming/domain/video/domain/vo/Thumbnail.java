package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class Thumbnail {

    private ThumbnailType type;
    private String url;
    private Double width;
    private Double height;

    public Thumbnail(final ThumbnailType type, final String url, final Double width, final Double height) {
        if (Objects.isNull(type) || Strings.isBlank(url) || width == null || width <= 0 || height == null || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public boolean isDefault() {
        return this.type.isDefault();
    }

    public boolean isMedium() {
        return this.type.isMedium();
    }

    public boolean isHigh() {
        return this.type.isHigh();
    }
}
