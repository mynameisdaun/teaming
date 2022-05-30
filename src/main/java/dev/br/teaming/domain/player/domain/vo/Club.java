package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {

    @Column(name = "club_tag")
    private String clubTag;

    @Column(name = "club_name")
    private String clubName;

    public Club(String clubTag, String clubName) {
        if (Strings.isBlank(clubTag) || Strings.isBlank(clubName) || !clubTag.startsWith("#")) {
            throw new IllegalArgumentException();
        }
        this.clubTag = clubTag;
        this.clubName = clubName;
    }
}
