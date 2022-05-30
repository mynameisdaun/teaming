package dev.br.teaming.domain.video.application;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.domain.vo.PlayerTag;
import dev.br.teaming.domain.player.repository.PlayerRepository;
import dev.br.teaming.domain.video.dto.VideoDTO;
import dev.br.teaming.domain.video.repository.VideoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Slf4j
@Transactional
@Service
public class VideoService {
    private final VideoRepository videoRepository;
    private final PlayerRepository playerRepository;

    public List<VideoDTO> findAllByPlayerTag(PlayerTag playerTag) {
        Player player = playerRepository.findByPlayerTag(playerTag)
                .orElseThrow(NoSuchElementException::new);
        return videoRepository.findByYoutuberIn(player.getYoutubers().getYoutubers())
                .stream()
                .map(VideoDTO::new)
                .collect(Collectors.toList());
    }
}
