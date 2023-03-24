package domain.player;

public enum HandsStatus {
    NONE,
    BUST,
    BLACK_JACK;


    public static HandsStatus of(int sum) {
        if (sum < Score.BLACK_JACK) {
            return NONE;
        }
        if (sum == Score.BLACK_JACK) {
            return BLACK_JACK;
        }
        return BUST;
    }
}
