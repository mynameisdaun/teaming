package dev.br.teaming.domain.video.application;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.player.repository.PlayerRepository;
import dev.br.teaming.domain.video.dto.VideoDTO;
import dev.br.teaming.domain.video.infra.YoutubeVideoClient;
import dev.br.teaming.domain.video.repository.VideoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<VideoDTO> manualVideoUpdate(String keyword) {
        youtubeVideoClient.searchYoutubeVideoByKeyWord(keyword);
        return null;
    }
}
