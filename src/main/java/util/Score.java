package util;

import domain.dto.PlayerStatusDto;

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

    public static Result getResult(PlayerStatusDto dealer, PlayerStatusDto participant) {
        if (dealer.isBust() && participant.isBust()) {
            return Result.DEFAULT;
        }
        if (participant.isBust()) {
            return Result.LOSE;
        }
        if (participant.isBlackJack() && !dealer.isBlackJack()) {
            return Result.WIN;
        }
        int dealerScore = dealer.getScore();
        int participantScore = participant.getScore();

        if (participantScore == dealerScore) {
            return Result.DEFAULT;
        }
        if (participantScore - dealerScore < 0) {
            return Result.LOSE;
        }
        return Result.WIN;

    }
}
