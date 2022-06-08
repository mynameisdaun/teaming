package dev.br.teaming.domain.feed.domain.vo;

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
public class FeedTitle {

    private String title;

    public FeedTitle(String title) {
        if(Strings.isBlank(title)) {
            throw new IllegalArgumentException("피드 제목은 빈 값이 될 수 없다");
       }
        this.title = title;
    }

    public String getValue() {
        return this.title;
    }
}
