package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode
public class PlayerTag {

    private String playerTag;

    public PlayerTag(String playerTag) {
        if (!Strings.isNotBlank(playerTag) || !playerTag.startsWith("#")) {
            throw new IllegalArgumentException();
        }
        this.playerTag = playerTag;
    }
}
