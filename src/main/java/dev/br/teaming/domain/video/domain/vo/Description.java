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
public class Description {

    private String description;

    public Description(String description) {
        if (!Strings.isNotBlank(description)) {
            throw new IllegalArgumentException();
        }
        this.description = description;
    }

    public String getValue() {
        return description;
    }

}
