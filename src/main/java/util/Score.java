package util;

public class Score {

    public static final int BLACK_JACK = 21;
    private static final int MAX_ACE_SCORE = 11;
    private static final int MIN_ACE_SCORE = 1;

    private Score() {

    }

    public static int calculate(int score, int aceCount) {
        int result = score + aceCount * MAX_ACE_SCORE;
        while (aceCount > 0) {
            if (result > BLACK_JACK) {
                result -= MAX_ACE_SCORE - MIN_ACE_SCORE;
            }
            aceCount--;
        }
        return result;
    }

    public static Result getResult(int dealerScore, int participantScore) {
        if (participantScore == dealerScore) {
            return Result.DEFAULT;
        }
        if (participantScore - dealerScore < 0) {
            return Result.LOSE;
        }
        return Result.WIN;

    }
}
