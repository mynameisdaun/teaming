package dev.br.teaming.domain.fixture;

import dev.br.teaming.domain.video.domain.vo.Thumbnail;
import dev.br.teaming.domain.video.domain.vo.ThumbnailType;

public class Fixture {

    public static Thumbnail thumbnail() {
        return new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
    }

}
