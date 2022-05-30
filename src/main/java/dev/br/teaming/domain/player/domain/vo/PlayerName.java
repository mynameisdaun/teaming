package dev.br.teaming.domain.player.domain.vo;

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
public class PlayerName {

    @Column(name = "player_name")
    private String name;
    @Column(name = "player_name_color")
    private String color;

    public PlayerName(String name, String color) {
        if (!Strings.isNotBlank(name) || !Strings.isNotBlank(color) || color.length() != 10) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.color = color;
    }


}
