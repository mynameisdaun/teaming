package dev.br.teaming.domain.video.domain.vo;

import dev.br.teaming.domain.player.domain.Player;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Youtuber {

    @Id
    @Column(name = "youtuber_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long youtuberSeq;

    @Column(name = "youtuber_id", unique = true)
    private String youtuberId;

    @Column(name = "youtuber_name")
    private String name;

    public Youtuber(String youtuberId, String name) {
        if (!Strings.isNotBlank(youtuberId) || !Strings.isNotBlank(name)) {
            throw new IllegalArgumentException();
        }
        this.youtuberId = youtuberId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Youtuber youtuber = (Youtuber) o;

        return youtuberSeq == youtuber.youtuberSeq;
    }

    @Override
    public int hashCode() {
        return (int) (youtuberSeq ^ (youtuberSeq >>> 32));
    }
}
