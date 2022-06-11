package dev.br.teaming.domain.feed.domain;

import dev.br.teaming.domain.feed.domain.vo.FeedContent;
import dev.br.teaming.domain.feed.domain.vo.FeedTitle;
import dev.br.teaming.domain.feed.domain.vo.FeedType;
import dev.br.teaming.domain.player.domain.Player;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feed_id")
    private long feedSeq;

    @Embedded
    @Column(name = "feed_title")
    private FeedTitle feedTitle;

    @Embedded
    @Column(name = "feed_content")
    private FeedContent feedContent;

    @Enumerated
    @Column(name = "feed_type")
    private FeedType feedType;

    @ManyToOne
    @Column(name = "feed_writer")
    private Player writer;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;



}
