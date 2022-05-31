package dev.br.teaming.domain.video.infra;

import org.springframework.stereotype.Component;

@Component
public interface YoutubeVideoClient {
    void searchYoutubeVideoByKeyWord(String keyword);
}
