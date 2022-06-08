package dev.br.teaming.domain.video.dto;

import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;
import com.google.api.services.youtube.model.Thumbnail;
import dev.br.teaming.domain.video.domain.Video;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class VideoDTO {

    private String videoId;
    private String videoTitle;
    private String description;
    private Date publishedAt;
    private String youtuberId;
    private String youtuberName;
    private List<Map<String, Object>> thumbnails;

    public VideoDTO(final Video video) {
        this.videoId = video.getVideoId().getVideoId();
        this.videoTitle = video.getVideoTitle().getValue();
        this.description = video.getDescription().getValue();
        this.publishedAt = video.getPublishedAt();
        this.youtuberId = video.getYoutuber().getYoutuberId();
        this.youtuberName = video.getYoutuber().getName();
        final List<Map<String, Object>> thumbnails = new ArrayList<>();
        video.getThumbnails().getThumbnails().forEach(thumbnail-> {
            Map<String, Object> t = new HashMap<>();
            t.put("type",thumbnail.getType());
            t.put("url",thumbnail.getUrl());
            t.put("width",thumbnail.getWidth());
            t.put("height",thumbnail.getHeight());
            thumbnails.add(t);
        });
        this.thumbnails=thumbnails;
    }
}
