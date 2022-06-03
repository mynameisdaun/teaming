package dev.br.teaming.domain.video.infra;

import dev.br.teaming.domain.video.domain.Video;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public interface YoutubeVideoClient {
    List<Video> searchYoutubeVideoByKeyWord(String keyword) throws IOException;
}
