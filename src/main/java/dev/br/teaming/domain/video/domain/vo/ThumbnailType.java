package dev.br.teaming.domain.video.domain.vo;

public enum ThumbnailType {
    DEFAULT, MEDIUM, HIGH;

    public boolean isDefault() {
        return this == ThumbnailType.DEFAULT;
    }

    public boolean isMedium() {
        return this == ThumbnailType.MEDIUM;
    }

    public boolean isHigh() {
        return this == ThumbnailType.HIGH;
    }
}
