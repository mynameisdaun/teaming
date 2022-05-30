package dev.br.teaming.domain.video.application;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.repository.PlayerRepository;
import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.Youtuber;
import dev.br.teaming.domain.video.dto.VideoDTO;
import dev.br.teaming.domain.video.repository.VideoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static dev.br.teaming.domain.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {
    @InjectMocks
    VideoService videoService;
    @Mock
    VideoRepository videoRepository;
    @Mock
    PlayerRepository playerRepository;

    @DisplayName(value = "유튜버 리스트로 브롤 비디오를 조회할 수 있다")
    @Test
    void findByYoutuberIn() throws Exception {
        //given
        Youtuber youtuber = youtuber();
        Video video = video(youtuber);
        Player player = player();
        given(playerRepository.findByPlayerTag(player().getPlayerTag()))
                .willReturn(Optional.of(player));
        given(videoRepository.findByYoutuberIn(player.getYoutubers().getYoutubers()))
                .willReturn(Arrays.asList(video));
        //when
        List<VideoDTO> response = videoService.findAllByPlayerTag(player().getPlayerTag());
        //then
        verify(playerRepository, times(1)).findByPlayerTag(any());
        verify(videoRepository, times(1)).findByYoutuberIn(any());
        assertThat(response).isNotNull();
        assertThat(response.size()).isOne();
        assertThat(response.isEmpty()).isFalse();
    }

    @DisplayName(value = "회원이 조회되지 않는다면 유튜버 리스트로 브롤 비디오를 조회할 수 없다")
    @Test
    void findByYoutuberIn_fall_no_player() throws Exception {
        //given
        Player player = player();
        given(playerRepository.findByPlayerTag(player().getPlayerTag()))
                .willReturn(Optional.empty());
        //when&then
        assertThatThrownBy(() -> videoService.findAllByPlayerTag(player.getPlayerTag()))
                .isInstanceOf(NoSuchElementException.class);
    }
}
