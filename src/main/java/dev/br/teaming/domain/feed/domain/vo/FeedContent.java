package dev.br.teaming.domain.feed.domain.vo;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedContent {

    private String feedContent;

    public FeedContent(String feedContent) {
        if(Strings.isBlank(feedContent)) {
            throw new IllegalArgumentException("피드 컨텐츠는 빈 값이 될 수 없습니다");
        }
        this.feedContent = feedContent;
    }

    public String getValue() {
        return this.feedContent;
    }
}
