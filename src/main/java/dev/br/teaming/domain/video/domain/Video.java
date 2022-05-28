package dev.br.teaming.domain.video.domain;

import dev.br.teaming.domain.model.vo.Name;
import dev.br.teaming.domain.video.domain.vo.Description;
import dev.br.teaming.domain.video.domain.vo.Thumbnails;
import dev.br.teaming.domain.video.domain.vo.VideoId;
import dev.br.teaming.domain.video.domain.vo.Youtuber;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "video")
@Getter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long videoSeq;

    @Embedded
    @Column(name = "video_id", nullable = false)
    private VideoId videoId;

    @Embedded
    @Column(name = "video_title", nullable = false)
    private Name title;

    @Embedded
    @Column(name = "video_description", nullable = false)
    private Description description;

    @Column(name = "published_date_time", nullable = false)
    private Date publishedAt;

    @Embedded
    @Column(name = "youtuber", nullable = false)
    private Youtuber youtuber;

    @Embedded
    private Thumbnails thumbnails;

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
