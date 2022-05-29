package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Gadget {
    @Column(name = "gadget_id")
    private Integer gadgetId;
    @Column(name = "gadget_name")
    private String gadgetName;

    public Gadget(Integer gadgetId, String gadgetName) {
        if(Objects.isNull(gadgetId) || gadgetId <= 0 || Strings.isBlank(gadgetName)) {
            throw new IllegalArgumentException();
        }
        this.gadgetId = gadgetId;
        this.gadgetName = gadgetName;
    }
}
