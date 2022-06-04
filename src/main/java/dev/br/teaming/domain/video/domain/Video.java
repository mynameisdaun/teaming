package dev.br.teaming.domain.video.domain;

import com.google.api.services.youtube.model.SearchResult;
import dev.br.teaming.domain.video.domain.vo.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "video")
@Getter @ToString
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long videoSeq;

    @Embedded
    @Column(name = "video_id", nullable = false, unique = true)
    private VideoId videoId;

    @Embedded
    @Column(name = "video_title", nullable = false)
    private VideoTitle videoTitle;

    @Embedded
    @Column(name = "video_description", nullable = false)
    private Description description;

    @Column(name = "published_date_time", nullable = false)
    private Date publishedAt;

    @OneToOne
    private Youtuber youtuber;;

    @Embedded
    private Thumbnails thumbnails;

    public Video(VideoId videoId, VideoTitle title, Description description, Date publishedAt, Youtuber youtuber, Thumbnails thumbnails) {
        if (Objects.isNull(videoId) || Objects.isNull(title) || Objects.isNull(description) ||
                Objects.isNull(publishedAt) || Objects.isNull(youtuber) || Objects.isNull(thumbnails)) {
            throw new IllegalArgumentException();
        }
        this.videoId = videoId;
        this.videoTitle = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.youtuber = youtuber;
        this.thumbnails = thumbnails;
    }

    public static Video from (SearchResult singleVideo) {
        return new Video(
                new VideoId(singleVideo.getId().getVideoId()),
                new VideoTitle(singleVideo.getSnippet().getTitle()),
                new Description(singleVideo.getSnippet().getDescription()),
                new Date(singleVideo.getSnippet().getPublishedAt().getValue()),
                new Youtuber(singleVideo.getSnippet().getChannelId(), singleVideo.getSnippet().getChannelTitle()),
                new Thumbnails(singleVideo.getSnippet().getThumbnails())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        return videoSeq == video.videoSeq;
    }

    @Override
    public int hashCode() {
        return (int) (videoSeq ^ (videoSeq >>> 32));
    }
}
