package dev.br.teaming.domain.video.domain.vo;

import dev.br.teaming.domain.model.vo.Name;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class Youtuber {

    @Column(name = "youtuber_id")
    private String youtuberId;

    @Column(name = "youtuber_name")
    private Name name;

    public Youtuber(String youtuberId, String name) {
        if (!Strings.isNotBlank(youtuberId)) {
            throw new IllegalArgumentException();
        }
        this.youtuberId = youtuberId;
        this.name = new Name(name);
    }
}
