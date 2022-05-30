package dev.br.teaming.domain.video.repository;

import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.VideoId;
import dev.br.teaming.domain.video.domain.vo.Youtuber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    Optional<Video> findByVideoId(VideoId videoId);

    List<Video> findByYoutuberIn(List<Youtuber> youtubers);
}
