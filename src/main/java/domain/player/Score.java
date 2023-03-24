package domain.player;

public class Score {

    public final static int BLACK_JACK = 21;
    private final static int MAX_ACE_SCORE = 11;
    private final static int MIN_ACE_SCORE = 1;

    private Score() {

    }

    public static HandsStatus calc(int score, int aceCount) {
        if (score == 11 && aceCount == 1) {
            return HandsStatus.BLACK_JACK;
        }
        while (aceCount > 0 && score < 12) {
            score += MAX_ACE_SCORE;
            aceCount--;
        }
        while (aceCount > 0) {
            score += MIN_ACE_SCORE;
            aceCount--;
        }
        return HandsStatus.of(score);
    }
}
