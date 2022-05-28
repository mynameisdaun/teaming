package dev.br.teaming.domain.fixture;

import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.*;

import java.util.Arrays;
import java.util.Date;

public class Fixture {

    public static Video video() {
        VideoId videoId = new VideoId("jYMrymKeJY0");
        VideoTitle title = new VideoTitle("즐거운 테스트 영상 제목");
        Description description = new Description("안녕하세요 돈안쓰고 게임을 즐길 수 있는 꿀팁들을 전해드리는 브롤입니다! 여러분의 구독 & 좋아요는 영상을 만드는데 정말 큰 힘이 ...");
        Date publishedAt = new Date();
        Youtuber youtuber = new Youtuber("UCoH2pCzAr6zWDG-LtUiLWRw", "stew");
        Thumbnails thumbnails = new Thumbnails(Arrays.asList(Fixture.thumbnail()));
        return  new Video(videoId, title, description, publishedAt, youtuber, thumbnails);
    }

    public static Thumbnail thumbnail() {
        return new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
    }

}
