package dev.br.teaming.domain.video.domain.vo;

public enum ThumbnailType {
    DEFAULT, MEDIUM, HIGH, STANDARD, MAXRES;

    public boolean isDefault() {
        return this == ThumbnailType.DEFAULT;
    }

    public boolean isMedium() {
        return this == ThumbnailType.MEDIUM;
    }

    public boolean isStandard() {
        return this == ThumbnailType.STANDARD;
    }

    public boolean isMaxres() {
        return this == ThumbnailType.MAXRES;
    }

    public boolean isHigh() {
        return this == ThumbnailType.HIGH;
    }
}
