package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class PlayerName {

    private String name;

    public PlayerName(String name) {
        if (!Strings.isNotBlank(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
