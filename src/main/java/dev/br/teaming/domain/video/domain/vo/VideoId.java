package dev.br.teaming.domain.video.domain.vo;

import com.google.api.client.util.Strings;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class VideoId {

    @Column(name = "videoId", columnDefinition = "varbinary(16)")
    private String videoId;

    public VideoId(String videoId) {
        if(Strings.isNullOrEmpty(videoId)) {
            throw new IllegalArgumentException();
        }
        this.videoId = videoId;
    }
}
