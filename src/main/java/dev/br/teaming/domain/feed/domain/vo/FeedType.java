package dev.br.teaming.domain.feed.domain.vo;

public enum FeedType {
    TALK, CHALLENGE, CLUB;

    public boolean isTalk() {
        return this==FeedType.TALK;
    }

    public boolean isChallenge() {
        return this==FeedType.CHALLENGE;
    }

    public boolean isClub() {
        return this==FeedType.CLUB;
    }
}
