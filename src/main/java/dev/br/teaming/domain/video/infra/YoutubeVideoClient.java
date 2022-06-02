package dev.br.teaming.domain.video.infra;

import dev.br.teaming.domain.video.dto.VideoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface YoutubeVideoClient {
    List<VideoDTO> searchYoutubeVideoByKeyWord(String keyword);
}
