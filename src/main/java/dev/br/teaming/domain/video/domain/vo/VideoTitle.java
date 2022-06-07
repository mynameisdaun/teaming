package dev.br.teaming.domain.video.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@ToString
public class VideoTitle {

    private String Title;

    public VideoTitle(String Title) {
        if (!Strings.isNotBlank(Title)) {
            throw new IllegalArgumentException();
        }
        this.Title = Title;
    }

    public String getValue() {
        return Title;
    }
}
