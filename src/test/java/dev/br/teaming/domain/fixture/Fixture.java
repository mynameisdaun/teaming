package dev.br.teaming.domain.fixture;

import dev.br.teaming.domain.player.domain.Player;
import dev.br.teaming.domain.player.domain.vo.*;
import dev.br.teaming.domain.player.domain.vo.brawler.*;
import dev.br.teaming.domain.video.domain.Video;
import dev.br.teaming.domain.video.domain.vo.*;

import java.util.Arrays;
import java.util.Date;

public class Fixture {

    public static Player player() {
        PlayerName playerName = new PlayerName("쵝오다운", "0xffffffff");
        PlayerTag playerTag = new PlayerTag("#YLUPG8PJP");
        PlayerTrophy playerTrophy = new PlayerTrophy(16860, 16860);
        PlayerExp playerExp = new PlayerExp(88, 41031);
        Victory victory = new Victory(310, 228, 2105);
        Club club = new Club("#LGPVQV", "다운스");
        Brawlers brawlers = new Brawlers(Arrays.asList(brawler()));
        Youtubers youtubers = new Youtubers(Arrays.asList(youtuber()));
        return new Player(playerName, playerTag, playerTrophy, playerExp, victory, club, brawlers, youtubers);
    }

    public static Video video() {
        VideoId videoId = new VideoId("jYMrymKeJY0");
        VideoTitle title = new VideoTitle("즐거운 테스트 영상 제목");
        Description description = new Description("안녕하세요 돈안쓰고 게임을 즐길 수 있는 꿀팁들을 전해드리는 브롤입니다! 여러분의 구독 & 좋아요는 영상을 만드는데 정말 큰 힘이 ...");
        Date publishedAt = new Date();
        Youtuber youtuber = new Youtuber("UCoH2pCzAr6zWDG-LtUiLWRw", "stew");
        Thumbnails thumbnails = new Thumbnails(Arrays.asList(Fixture.thumbnail()));
        return new Video(videoId, title, description, publishedAt, youtuber, thumbnails);
    }

    public static Video video(Youtuber youtuber) {
        VideoId videoId = new VideoId("jYMrymKeJY0");
        VideoTitle title = new VideoTitle("즐거운 테스트 영상 제목");
        Description description = new Description("안녕하세요 돈안쓰고 게임을 즐길 수 있는 꿀팁들을 전해드리는 브롤입니다! 여러분의 구독 & 좋아요는 영상을 만드는데 정말 큰 힘이 ...");
        Date publishedAt = new Date();
        Thumbnails thumbnails = new Thumbnails(Arrays.asList(Fixture.thumbnail()));
        return new Video(videoId, title, description, publishedAt, youtuber, thumbnails);
    }

    public static Thumbnail thumbnail() {
        return new Thumbnail(ThumbnailType.DEFAULT, "https://i.ytimg.com/vi/ZuPMKJ0G1R0/default.jpg", 120.0, 90.0);
    }

    public static Youtuber youtuber() {
        return new Youtuber("UCoH2pCzAr6zWDG-LtUiLWRw", "다우니");
    }

    public static Gadget gadget() {
        return new Gadget(23000433, "FREEZE FRAME");
    }

    public static Gear gear() {
        return new Gear(62000000, 3, GearType.SPEED);
    }

    public static StarPower starPower() {
        return new StarPower(23000438, "FRESH KICKS");
    }

    public static Brawler brawler() {
        BrawlerId brawlerId = new BrawlerId(16000045);
        String brawlerName = "STU";
        Integer power = 10;
        Integer rank = 21;
        Integer trophies = 553;
        Integer highestTrophies = 595;
        Gears gears = new Gears(Arrays.asList(gear()));
        StarPowers starPowers = new StarPowers(Arrays.asList(starPower()));
        Gadgets gadgets = new Gadgets(Arrays.asList(gadget()));
        return new Brawler(brawlerId, brawlerName, power, rank, trophies, highestTrophies, gears, starPowers, gadgets);
    }

}
