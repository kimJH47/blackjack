package domain.player;

public class Score {

    public final static int BLACK_JACK = 21;
    private final static int MAX_ACE_SCORE = 11;
    private final static int MIN_ACE_SCORE = 1;

    private Score() {

    }

    public static HandsStatus calc(int score, int aceCount) {
        int result = score + aceCount * MAX_ACE_SCORE;
        while (aceCount > 0) {
            if (result > BLACK_JACK) {
                result -= MAX_ACE_SCORE - MIN_ACE_SCORE;
            }
            aceCount--;
        }
        return HandsStatus.of(result);
    }
}
