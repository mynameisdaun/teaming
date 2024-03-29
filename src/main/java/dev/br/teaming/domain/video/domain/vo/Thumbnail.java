package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
@ToString
@Slf4j
public class Thumbnail {

    private ThumbnailType type;
    private String url;
    private Long width;
    private Long height;

    public Thumbnail(final ThumbnailType type, final String url, final Long width, final Long height) {
        if (Objects.isNull(type) || Strings.isBlank(url) || width == null || width <= 0 || height == null || height <= 0) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public static Thumbnail of (final ThumbnailType type, final com.google.api.services.youtube.model.Thumbnail thumbnail) {
        Long width = thumbnail.getWidth();
        if(Objects.isNull(width)) {
            width = 600L;
        }
        Long height = thumbnail.getHeight();
        if(Objects.isNull(height)) {
            height = 600L;
        }
        return new Thumbnail(type, thumbnail.getUrl(), width, height);
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
