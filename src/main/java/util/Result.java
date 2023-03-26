package util;

public enum Result {
    WIN(1),
    LOSE(0),
    DEFAULT(0);
    private final int point;

    Result(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
