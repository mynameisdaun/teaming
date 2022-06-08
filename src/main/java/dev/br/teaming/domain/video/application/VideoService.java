package dev.br.teaming.domain.video.application;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.player.repository.PlayerRepository;
import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.dto.VideoDTO;
import dev.br.teaming.domain.video.infra.YoutubeVideoClient;
import dev.br.teaming.domain.video.repository.VideoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final PlayerRepository playerRepository;
    private final YoutubeVideoClient youtubeVideoClient;

    public List<VideoDTO> findAllByPlayerTag(PlayerTag playerTag) {
        Player player = playerRepository.findByPlayerTag(playerTag)
                .orElseThrow(NoSuchElementException::new);
        return videoRepository.findByYoutuberIn(player.getYoutubers().getYoutubers())
                .stream()
                .map(VideoDTO::new)
                .collect(Collectors.toList());
    }

    public List<VideoDTO> manualVideoUpdate(String keyword) throws IOException {
        List<VideoDTO> response = new ArrayList<>();
        List<Video> videos = youtubeVideoClient.searchYoutubeVideoByKeyWord(keyword);
        for(Video video : videos) {
            log.info(video.toString());
            response.add(new VideoDTO(videoRepository.save(video)));
        }
        return response;
    }
}
