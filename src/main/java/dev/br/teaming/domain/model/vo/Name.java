package dev.br.teaming.domain.model.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @EqualsAndHashCode
public class Name {

    private String name;

    public Name(String name) {
        if(!Strings.isNotEmpty(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

}
