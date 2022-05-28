package dev.br.teaming.domain.video.repository;

import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.VideoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Optional<Video> findByVideoId(VideoId videoId);
}
