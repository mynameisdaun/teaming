package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BrawlerId {
    private Integer brawlerId;

    public BrawlerId(Integer brawlerId) {
        if(Objects.isNull(brawlerId)||brawlerId <=0) {
            throw new IllegalArgumentException();
        }
        this.brawlerId = brawlerId;
    }
}
