package dev.br.teaming.domain.player.domain.vo.brawler;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Gadget {

    private Integer gadgetId;
    private String gadgetName;

    public Gadget(Integer gadgetId, String gadgetName) {
        if(Objects.isNull(gadgetId) || gadgetId <= 0 || Strings.isBlank(gadgetName)) {
            throw new IllegalArgumentException();
        }
        this.gadgetId = gadgetId;
        this.gadgetName = gadgetName;
    }
}
