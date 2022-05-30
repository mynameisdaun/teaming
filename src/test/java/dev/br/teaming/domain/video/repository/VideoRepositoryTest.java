package dev.br.teaming.domain.video.repository;

import dev.br.teaming.domain.fixture.Fixture;
import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.VideoId;
import dev.br.teaming.domain.video.domain.vo.Youtuber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class VideoRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    VideoRepository videoRepository;

    @DisplayName("Video를 저장한다")
    @Test
    public void save() {
        //given
        final Video video = Fixture.video();

        //when
        final Video saved = videoRepository.save(video);

        //then
        assertThat(saved).isNotNull();
        assertThat(saved.getVideoSeq()).isEqualTo(video.getVideoSeq());
        assertThat(saved.getVideoId()).isEqualTo(video.getVideoId());
        assertThat(saved.getVideoTitle()).isEqualTo(video.getVideoTitle());
        assertThat(saved.getDescription()).isEqualTo(video.getDescription());
        assertThat(saved.getPublishedAt()).isEqualTo(video.getPublishedAt());
        assertThat(saved.getThumbnails()).isEqualTo(video.getThumbnails());
        assertThat(saved.getYoutuber()).isEqualTo(video.getYoutuber());

    }

    @DisplayName(value = "VideoID로 비디오를 조회한다")
    @Test
    void findByVideoId() throws Exception {
        //given
        final Video video = Fixture.video();
        em.persist(video);
        //when
        final Video findVideo = videoRepository.findByVideoId(video.getVideoId())
                .orElseThrow(NoSuchElementException::new);
        //then
        assertThat(findVideo).isNotNull();
        assertThat(findVideo.getVideoSeq()).isEqualTo(video.getVideoSeq());
        assertThat(findVideo.getVideoId()).isEqualTo(video.getVideoId());
        assertThat(findVideo.getVideoTitle()).isEqualTo(video.getVideoTitle());
        assertThat(findVideo.getDescription()).isEqualTo(video.getDescription());
        assertThat(findVideo.getPublishedAt()).isEqualTo(video.getPublishedAt());
        assertThat(findVideo.getThumbnails()).isEqualTo(video.getThumbnails());
        assertThat(findVideo.getYoutuber()).isEqualTo(video.getYoutuber());
    }

    @DisplayName(value = "존재하지 않는 ID로 비디오를 조회할 수 없다")
    @Test
    void findByVideoId_fail_non_exist() throws Exception {
        //given
        final Video video = Fixture.video();
        em.persist(video);
        //when&&then
        assertThatThrownBy(() -> videoRepository.findByVideoId(new VideoId("no-exist-Id")).orElseThrow(NoSuchElementException::new))
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName(value = "Youtuber 리스트로 비디오를 조회한다")
    @Test
    void findByYoutuberIn() throws Exception {
        //given
        Youtuber youtuber = new Youtuber("UCoH2pCzAr6zWDG-LtUiLWRw", "stew");
        final Video video = Fixture.video(youtuber);
        final Video video2 = Fixture.video(youtuber);
        em.persist(video);
        em.persist(video2);
        em.flush();
        //when
        final List<Video> findVideos = videoRepository.findByYoutuberIn(Arrays.asList(youtuber));
        //then
        assertThat(findVideos).isNotNull();
        assertThat(findVideos.isEmpty()).isFalse();
        assertThat(findVideos.size()).isEqualTo(2);
        assertThat(findVideos.get(0).getVideoSeq()).isEqualTo(video.getVideoSeq());
        assertThat(findVideos.get(0).getVideoId()).isEqualTo(video.getVideoId());
        assertThat(findVideos.get(0).getVideoTitle()).isEqualTo(video.getVideoTitle());
        assertThat(findVideos.get(0).getDescription()).isEqualTo(video.getDescription());
        assertThat(findVideos.get(0).getPublishedAt()).isEqualTo(video.getPublishedAt());
        assertThat(findVideos.get(0).getThumbnails()).isEqualTo(video.getThumbnails());
        assertThat(findVideos.get(0).getYoutuber()).isEqualTo(video.getYoutuber());
    }
}
