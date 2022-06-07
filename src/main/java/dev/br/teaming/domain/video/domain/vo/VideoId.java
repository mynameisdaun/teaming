package dev.br.teaming.domain.video.domain.vo;

import lombok.*;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
@ToString
public class VideoId {

    private String videoId;

    public VideoId(String videoId) {
        if (!Strings.isNotBlank(videoId)) {
            throw new IllegalArgumentException();
        }
        this.videoId = videoId;
    }
}
