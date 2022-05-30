package dev.br.teaming.domain.player.domain.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Victory {

    @Column(name = "victory_solo")
    private int solo;

    @Column(name = "victory_duo")
    private int duo;

    @Column(name = "victory_trio")
    private int trio;

    public Victory(int solo, int duo, int trio) {
        if (Objects.isNull(solo) || Objects.isNull(duo) || Objects.isNull(trio) || solo < 0 || duo < 0 || trio < 0) {
            throw new IllegalArgumentException();
        }
        this.solo = solo;
        this.duo = duo;
        this.trio = trio;
    }
}
